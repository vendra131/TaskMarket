package com.kodekonveyor.market.tasks;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.reset;

import java.util.Optional;

import com.kodekonveyor.authentication.UserEntityTestData;
import com.kodekonveyor.market.register.MarketUserEntityRepository;
import com.kodekonveyor.market.register.MarketUserEntityTestData;

public class TaskEntityStubs {

  public static void behaviour(
      final TaskEntityRepository taskEntityRepository,
      final MarketUserEntityRepository marketUserEntityRepository
  ) {
    reset(taskEntityRepository);
    doReturn(Optional.of(TaskEntityTestData.get())).when(taskEntityRepository)
        .findByServiceAndBehaviour(
            TaskEntityTestData.get().getService(),
            TaskEntityTestData.get().getBehaviour()
        );
    doReturn(
        Optional.of(MarketUserEntityTestData.getRoleProjectManager())
    )
        .when(marketUserEntityRepository)
        .findByUser(UserEntityTestData.getRoleProjectManager());
  }
}
