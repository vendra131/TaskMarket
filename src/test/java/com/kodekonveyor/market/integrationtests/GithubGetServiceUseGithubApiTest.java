package com.kodekonveyor.market.integrationtests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.kodekonveyor.SpringConfig;
import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.exception.ThrowableTester;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(SpringRunner.class)
@SpringBootTest(
    webEnvironment = WebEnvironment.MOCK, classes = SpringConfig.class
)
@TestedBehaviour("use github api")
@TestedService("GithubGetService")
@TestPropertySource(locations = "classpath:test.properties")
@Tag("IntegrationTest")
public class GithubGetServiceUseGithubApiTest extends GithubGetServiceTestBase {

  @Autowired
  Logger loggerService;

  @Test
  @DisplayName(
    "Get Github api data"
  )
  void test() {
    ThrowableTester.assertNoException(
        () -> assertEquals(
            githubGetService.call(JsonResultTestData.GITHUB_API_URL), JsonResultTestData.get()
        )
    );
  }
}
