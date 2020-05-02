package com.kodekonveyor.market.project;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kodekonveyor.authentication.AuthenticatedUserService;
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
  AuthenticatedUserService authenticatedUserService;

  @Mock
  MilestoneEntityRepository milestoneEntityRepository;

  @BeforeEach
  void setUp() {
    TaskEntityStubs.behaviour(taskEntityRepository);
    ProjectEntityRepositoryStubs.behaviour(projectEntityRepository);
    MilestoneEntityRepositoryStubs.behaviour(milestoneEntityRepository);
  }
}
