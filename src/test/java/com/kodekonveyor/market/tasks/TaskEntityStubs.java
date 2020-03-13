package com.kodekonveyor.market.tasks;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.reset;

import com.kodekonveyor.market.register.MarketUserEntityTestData;

public class TaskEntityStubs {

  public static void behaviour(
      final TaskRepository taskRepository
  ) {
    reset(taskRepository);
    doReturn(TaskEntityTestData.getInProgressTasks()).when(taskRepository)
        .findByStatusAndResponsible(
            TaskStatusEnum.IN_PROGRESS, MarketUserEntityTestData.get()
        );
    doReturn(TaskEntityTestData.getClosedTasks()).when(taskRepository)
        .findByStatusAndResponsible(
            TaskStatusEnum.DONE, MarketUserEntityTestData.get()
        );
    doReturn(TaskEntityTestData.getClosedUpForGrabTasks()).when(taskRepository)
        .findByStatusAndResponsibleAndProjectIsPublic(
            TaskStatusEnum.UP_FOR_GRAB, MarketUserEntityTestData.get(), false
        );
    doReturn(TaskEntityTestData.getOpenUpForGrabTasks()).when(taskRepository)
        .findByStatusAndProjectIsPublic(
            TaskStatusEnum.UP_FOR_GRAB, true
        );
  }
}
