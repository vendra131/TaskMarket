package com.kodekonveyor.market.tasks;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.reset;

public class TaskEntityStubs {

  public static void behaviour(
      final TaskEntityRepository taskEntityRepository,
      final GetRepositoryTasksService getRepositoryTasksService
  ) {
    reset(taskEntityRepository);
    doReturn(TaskEntityTestData.list()).when(taskEntityRepository)
        .findAll();
    doReturn(TaskDTOTestData.list()).when(getRepositoryTasksService)
        .call();
  }
}
