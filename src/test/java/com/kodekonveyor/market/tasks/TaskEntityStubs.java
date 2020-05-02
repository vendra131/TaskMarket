package com.kodekonveyor.market.tasks;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.reset;

import java.util.Optional;

public class TaskEntityStubs {

  public static void behaviour(
      final TaskEntityRepository taskEntityRepository
  ) {
    reset(taskEntityRepository);
    doReturn(Optional.of(TaskEntityTestData.get())).when(taskEntityRepository)
        .findByServiceAndBehaviour(
            TaskEntityTestData.get().getService(),
            TaskEntityTestData.get().getBehaviour()
        );
  }
}
