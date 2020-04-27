package com.kodekonveyor.market.tasks;

import java.util.List;

import com.kodekonveyor.market.project.ProjectEntityTestData;
import com.kodekonveyor.market.register.MarketUserEntityTestData;

public class TaskEntityTestData {

  public static final String ISSUE_ID = "4422";
  public static final String ISSUE_NAME = "SomeController/behaviour";
  public static final String DIFFERENT_ISSUE_NAME =
      "UpdateController/behaviour";
  public static final String NEW_DESCRIPTION =
      "Task Description: documentation is updated End of Task Description";
  public static final String BEHAVIOUR = "behaviour";
  public static final String DOCUMENTATION =
      "Task Description: documentation End of Task Description";

  public static final TaskEntity getDifferentIssueName() {
    final TaskEntity taskEntity = get();
    taskEntity.setName(DIFFERENT_ISSUE_NAME);
    return taskEntity;
  }

  public static final TaskEntity getNewDescription() {
    final TaskEntity taskEntity = get();
    taskEntity.setDocumentation(NEW_DESCRIPTION);
    return taskEntity;
  }

  public static final List<TaskEntity> list() {
    return List.of(get());
  }

  public static TaskEntity get() {
    final TaskEntity entity = new TaskEntity();
    entity.setGithubId(ISSUE_ID);
    entity.setName(ISSUE_NAME);
    entity.setBehaviourName(BEHAVIOUR);
    entity.setDocumentation(DOCUMENTATION);
    entity.setProject(ProjectEntityTestData.get());
    entity.setResponsible(MarketUserEntityTestData.get());
    entity.setStatus(TaskStatusEnum.UP_FOR_GRAB);
    return entity;
  }

}
