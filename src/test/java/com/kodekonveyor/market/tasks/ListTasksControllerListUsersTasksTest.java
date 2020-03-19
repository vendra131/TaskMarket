package com.kodekonveyor.market.tasks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.authentication.AuthenticatedUserStubs;
import com.kodekonveyor.market.register.MarketUserDTOTestData;
import com.kodekonveyor.market.register.MarketUserStubs;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("List user's tasks")
@TestedService("ListTasksController")
public class ListTasksControllerListUsersTasksTest
    extends ListTasksControllerTestBase {

  MarketUserDTOTestData registerTestData;

  @Test
  @DisplayName("List all the task for a user")
  public void test() {
    MarketUserStubs
        .behaviour(marketUserEntityRepository, registerTestData);
    AuthenticatedUserStubs.authenticated(authenticatedUserService);
    assertEquals(
        TaskDTOTestData.list(),
        listTasksController.call()
    );
  }

}
