package com.kodekonveyor.market.register;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kodekonveyor.authentication.UserEntity;

public interface MarketUserEntityRepository
    extends CrudRepository<MarketUserEntity, Long> {

  List<MarketUserEntity> findByLogin(UserEntity userEntity);

  List<MarketUserEntity> findByLogin_Login(String username);

}
