package com.kodekonveyor.market.integrationtests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;

import com.kodekonveyor.SpringConfig;
import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;

@SpringBootTest(
    webEnvironment = WebEnvironment.MOCK, classes = SpringConfig.class
)
@TestedBehaviour("use github api")
@TestedService("GithubGetService")
@TestPropertySource(locations = "classpath:test.properties")
@Testable
@Tag("IntegrationTest")
public class GithubGetServiceUseGithubApiIT extends GithubGetServiceTestBase {

  @Autowired
  Logger loggerService;

  @Test
  @DisplayName(
    "Get Github api data"
  )
  void test() throws IOException {
    assertEquals(
        JsonResultTestData.get(),
        githubGetService.call(JsonResultTestData.GITHUB_API_URL)
    );
  }
}
