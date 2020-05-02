package com.kodekonveyor.market.project;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.market.register.MarketUserDTOTestData;
import com.kodekonveyor.market.register.MarketUserEntityRepository;
import com.kodekonveyor.market.register.MarketUserStubs;
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
  MarketUserEntityRepository marketUserEntityRepository;

  @Mock
  AuthenticatedUserService authenticatedUserService;

  MarketUserDTOTestData registerTestData;

  @BeforeEach
  void setUp() {
    TaskEntityStubs.behaviour(taskEntityRepository);
    MarketUserStubs.behaviour(marketUserEntityRepository, registerTestData);
    ProjectEntityStubs.behaviour(projectEntityRepository);
    ProjectEntityRepositoryStubs.behaviour(projectEntityRepository);
    MilestoneEntityRepositoryStubs.behaviour(milestoneEntityRepository);
    MilestoneEntityRepository milestoneEntityRepository;
}
