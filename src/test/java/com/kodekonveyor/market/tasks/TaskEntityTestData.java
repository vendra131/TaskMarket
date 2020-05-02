package com.kodekonveyor.market.tasks;

import javax.annotation.Generated;

@Generated("by zenta-tools")
public class TaskEntityTestData {

  public final static TaskEntity get() {
    final TaskEntity taskEntity = new TaskEntity();
    taskEntity.setId(TaskTestData.ID);
    taskEntity.setService(TaskTestData.SERVICE);
    taskEntity.setBehaviour(TaskTestData.BEHAVIOUR);
    taskEntity.setGithubId(TaskTestData.GITHUB_ID);
    taskEntity.setDescription(TaskTestData.DESCRIPTION);

    return taskEntity;
  };

  public static final TaskEntity getDifferentBehaviour() {
    final TaskEntity taskEntity = get();
    taskEntity.setId(null);
    taskEntity.setBehaviour(TaskTestData.DIFFERENT_BEHAVIOUR);
    return taskEntity;
  }

  public static final TaskEntity getNewDescription() {
    final TaskEntity taskEntity = get();
    taskEntity.setDescription(TaskTestData.NEW_DESCRIPTION);
    return taskEntity;
  }
}
