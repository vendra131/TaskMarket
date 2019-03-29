all: install

install: compile sonar 
	cp -rf taskmarket/* target

target:
	mkdir -p target

sonar: sonarconfig javabuild
	./tools/pullanalize

sonarconfig:
	cp etc/m2/settings.xml ~/.m2

compile: zentaworkaround javabuild taskmarket.compiled codedocs

codedocs: target/taskmarket-testcases.xml target/taskmarket-implementedBehaviours.xml target/taskmarket-implementedBehaviours.html target/bugpriorities.xml

target/taskmarket-testcases.xml: taskmarket.richescape target
	zenta-xslt-runner -xsl:xslt/generate_test_cases.xslt -s taskmarket.richescape outputbase=target/taskmarket-

target/taskmarket-implementedBehaviours.xml: javadoc target
	zenta-xslt-runner -xsl:xslt/generate-behaviours.xslt -s target/test/javadoc.xml outputbase=target/taskmarket-

javadoc:
	mkdir -p target/production target/test
	mvn javadoc:javadoc javadoc:test-javadoc site

CONSISTENCY_INPUTS=target/taskmarket-testcases.xml target/taskmarket-implementedBehaviours.xml

include /usr/share/zenta-tools/model.rules

taskmarket.consistencycheck: taskmarket.rich taskmarket.check $(CONSISTENCY_INPUTS)
	zenta-xslt-runner -xsl:xslt/consistencycheck.xslt -s:$(basename $@).check -o:$@ >$(basename $@).consistency.stderr 2>&1
	sed 's/\//:/' <$(basename $@).consistency.stderr |sort --field-separator=':' --key=2

testenv:
	./tools/testenv

javabuild: target/TaskMarket-0.0.1-SNAPSHOT.jar

target/TaskMarket-0.0.1-SNAPSHOT.jar:
	mvn build-helper:parse-version versions:set versions:commit -DnewVersion=\$${parsedVersion.majorVersion}.\$${parsedVersion.minorVersion}.\$${parsedVersion.incrementalVersion}-$$(tools/getbranch|sed 'sA/A_Ag').$$(git rev-parse --short HEAD)
	mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install org.pitest:pitest-maven:mutationCoverage site
	zenta-xslt-runner -xsl:xslt/cpd2pmd.xslt -s:target/pmd.xml -o target/pmd_full.xml
	java -jar /usr/local/lib/mutation-analysis-plugin-1.3-SNAPSHOT.jar

clean:
	git clean -fdx
	rm -rf zenta-tools

inputs/taskmarket.issues.xml: target/taskmarket-implementedBehaviours.xml target/taskmarket-testcases.xml
	mkdir -p inputs
	tools/getGithubIssues kode-konveyor TaskMarket f279765590d25bedfc9f08f7fc39a8c39c891711 >inputs/taskmarket.issues.xml

zentaworkaround:
	mkdir -p ~/.zenta/.metadata/.plugins/org.eclipse.e4.workbench/
	cp workbench.xmi ~/.zenta/.metadata/.plugins/org.eclipse.e4.workbench/
	touch zentaworkaround

target/bugpriorities.xml: taskmarket.consistencycheck inputs/taskmarket.issues.xml taskmarket.richescape target
	zenta-xslt-runner -xsl:xslt/issue-priorities.xslt -s:taskmarket.consistencycheck -o:target/bugpriorities.xml issuesfile=inputs/taskmarket.issues.xml modelfile=taskmarket.richescape missingissuefile=target/missing.xml

