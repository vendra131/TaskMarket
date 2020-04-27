package com.kodekonveyor.market.project;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.market.register.MarketUserDTOTestData;
import com.kodekonveyor.market.register.MarketUserEntityRepository;
import com.kodekonveyor.market.register.MarketUserStubs;
import com.kodekonveyor.market.tasks.GetRepositoryTasksService;
import com.kodekonveyor.market.tasks.TaskEntityRepository;
import com.kodekonveyor.market.tasks.TaskEntityStubs;
import com.kodekonveyor.market.tasks.UpdateTasksService;

public class UpdateProjectModelControllerTestBase {

  @InjectMocks
  UpdateProjectModelController updateProjectModelController;

  @InjectMocks
  UpdateTasksService updateTasksService;

  @Mock
  ProjectEntityRepository projectEntityRepository;

  @Mock
  TaskEntityRepository taskEntityRepository;

  @Mock
  GetRepositoryTasksService getRepositoryTasksService;

  @Mock
  MarketUserEntityRepository marketUserEntityRepository;

  MarketUserDTOTestData registerTestData;

  @BeforeEach
  void setUp() {
    TaskEntityStubs.behaviour(taskEntityRepository, getRepositoryTasksService);
    MarketUserStubs.behaviour(marketUserEntityRepository, registerTestData);
    ProjectEntityStubs.behaviour(projectEntityRepository);
  }
}
