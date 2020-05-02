package com.kodekonveyor.market.tasks;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface TaskEntityRepository extends CrudRepository<TaskEntity, Long> {

  Optional<TaskEntity>
      findByServiceAndBehaviour(String service, String behaviour);

}
