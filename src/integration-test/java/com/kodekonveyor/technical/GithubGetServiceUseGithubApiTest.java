package com.kodekonveyor.technical;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.market.LogSeverityEnum;
import com.kodekonveyor.market.LoggerService;
import com.kodekonveyor.market.github.GithubConstants;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("use github api")
@TestedService("GithubGetService")
public class GithubGetServiceUseGithubApiTest extends GithubGetServiceTestBase {

  @Autowired
  LoggerService loggerService;

  @Test
  @DisplayName(
    "Get Github api data"
  )
  void test() {
    try {
      assertEquals(
          githubGetService.call(JsonResultTestData.GITHUB_API_URL), JsonResultTestData.get()
      );
    } catch (final IOException exception) {
      loggerService.call(
          GithubConstants.INTERNAL_ERROR, LogSeverityEnum.ERROR,
          JsonResultTestData.GITHUB_API_URL
      );
    }

  }
}
