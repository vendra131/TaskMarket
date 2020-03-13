package com.kodekonveyor.market.tasks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
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

  @Override
  @BeforeEach
  void setUp() {
    super.setUp();
    MarketUserStubs
        .behaviour(marketUserEntityRepository, registerTestData);
    AuthenticatedUserStubs.authenticated(authenticatedUserService);
  }

  @Test
  @DisplayName("List In_Progress tasks where the user is responsible")
  public void test() {
    assertEquals(
        TaskDTOTestData.getInProgressTasks(),
        listTasksController.call(TaskStatusEnum.IN_PROGRESS)
    );
  }

  @Test
  @DisplayName(
    "List Up_For_Grab tasks for closed projects the user is a member of"
  )
  public void test1() {
    final boolean isPublic = false;
    assertEquals(
        TaskDTOTestData.getClosedUpForGrabTasks(),
        listTasksController.call(TaskStatusEnum.UP_FOR_GRAB, isPublic)
    );
  }

  @Test
  @DisplayName("List Up_For_Grab tasks for open projects")
  public void test2() {
    final boolean isPublic = true;
    assertEquals(
        TaskDTOTestData.getOpenUpForGrabTasks(),
        listTasksController.call(TaskStatusEnum.UP_FOR_GRAB, isPublic)
    );
  }

  @Test
  @DisplayName("List Closed tasks where the user is responsible")
  public void test3() {
    assertEquals(
        TaskDTOTestData.getClosedTasks(),
        listTasksController.call(TaskStatusEnum.DONE)
    );
  }

}
