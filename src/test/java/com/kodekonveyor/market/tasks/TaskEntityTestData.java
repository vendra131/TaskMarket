package com.kodekonveyor.market.tasks;

import java.util.List;

import com.kodekonveyor.market.project.ProjectEntityTestData;
import com.kodekonveyor.market.register.MarketUserEntityTestData;

public class TaskEntityTestData {

  public static final String ISSUE_ID = "4422";
  public static final String ISSUE_NAME = "SomeController/behaviour";
  public static final String DIFFERENT_ISSUE_NAME =
      "UpdateController/behaviour";
  public static final String NEW_DESCRIPTION =
      "Task Description: documentation is updated End of Task Description";
  public static final String BEHAVIOUR = "behaviour";
  public static final String DOCUMENTATION =
      "Task Description: documentation End of Task Description";

  public static final TaskEntity get() {
    final TaskEntity taskEntity = new TaskEntity();
    taskEntity.setGithubId(ISSUE_ID);
    taskEntity.setServiceName(ISSUE_NAME);
    taskEntity.setBehaviourName(BEHAVIOUR);
    taskEntity.setDocumentation(DOCUMENTATION);
    taskEntity.setProject(ProjectEntityTestData.getNullMilestone());
    taskEntity.setResponsible(MarketUserEntityTestData.get());
    return taskEntity;
  }

  public static final TaskEntity getDifferentIssueName() {
    final TaskEntity taskEntity = get();
    taskEntity.setServiceName(DIFFERENT_ISSUE_NAME);
    return taskEntity;
  }

  public static final TaskEntity getNewDescription() {
    final TaskEntity taskEntity = get();
    taskEntity.setDocumentation(NEW_DESCRIPTION);
    return taskEntity;
  }

  public static final List<TaskEntity> list() {
    return List.of(get());
  }

}
