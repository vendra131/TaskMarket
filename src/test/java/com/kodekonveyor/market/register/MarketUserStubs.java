package com.kodekonveyor.market.register;

import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import com.kodekonveyor.authentication.UserEntityTestData;

public class MarketUserStubs {

  public static void
      behaviour(
          final MarketUserEntityRepository marketUserEntityRepository,
          final MarketUserDTOTestData registerTestData
      ) {
    doReturn(Optional.of(MarketUserEntityTestData.get()))
        .when(marketUserEntityRepository)
        .findByLogin(UserEntityTestData.get());
  }
}
