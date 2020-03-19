package com.kodekonveyor.market.tasks;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.reset;

import com.kodekonveyor.market.register.MarketUserEntityTestData;

public class TaskEntityStubs {

  public static void behaviour(
      final TaskRepository taskRepository
  ) {
    reset(taskRepository);
    doReturn(TaskEntityTestData.listStatusInProgress()).when(taskRepository)
        .findByStatusAndResponsible(
            TaskStatusEnum.IN_PROGRESS, MarketUserEntityTestData.get()
        );
    doReturn(TaskEntityTestData.listStatusDone()).when(taskRepository)
        .findByStatusAndResponsible(
            TaskStatusEnum.DONE, MarketUserEntityTestData.get()
        );
    doReturn(TaskEntityTestData.listIsPublicFalse())
        .when(taskRepository)
        .findByStatusAndResponsibleAndProjectIsPublic(
            TaskStatusEnum.UP_FOR_GRAB, MarketUserEntityTestData.get(), false
        );
    doReturn(TaskEntityTestData.listIsPublicTrue())
        .when(taskRepository)
        .findByStatusAndProjectIsPublic(
            TaskStatusEnum.UP_FOR_GRAB, true
        );
  }
}
