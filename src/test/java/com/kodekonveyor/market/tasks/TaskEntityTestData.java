package com.kodekonveyor.market.tasks;

import java.util.ArrayList;
import java.util.List;

import com.kodekonveyor.market.project.ProjectEntityTestData;
import com.kodekonveyor.market.register.MarketUserEntityTestData;

public class TaskEntityTestData {

  public static final String ISSUE_ID = "1234";
  public static final String ISSUE_NAME = "xyz";

  public static final TaskEntity get() {
    final TaskEntity taskEntity = new TaskEntity();
    taskEntity.setGithubId(ISSUE_ID);
    taskEntity.setName(ISSUE_NAME);
    taskEntity.setProject(ProjectEntityTestData.get());
    taskEntity.setResponsible(MarketUserEntityTestData.get());
    return taskEntity;
  }
  
  public static final TaskEntity getStatusUpFprGrab() {
    final TaskEntity taskEntity = get();
    taskEntity.setStatus(TaskStatusEnum.UP_FOR_GRAB);
    return taskEntity;
  }
  

  public static final List<TaskEntity> listStatusDone() {
    final TaskEntity taskEntity = get();
    final List<TaskEntity> taskEntities = new ArrayList<>();
    taskEntity.setStatus(TaskStatusEnum.DONE);
    taskEntities.add(taskEntity);
    return taskEntities;
  }

  public static final List<TaskEntity> listStatusInProgress() {
    final TaskEntity taskEntity = get();
    final List<TaskEntity> taskEntities = new ArrayList<>();
    taskEntity.setStatus(TaskStatusEnum.IN_PROGRESS);
    taskEntities.add(taskEntity);
    return taskEntities;
  }

  public static final List<TaskEntity> listIsPublicTrue() {
    final TaskEntity taskEntity = getStatusUpFprGrab();
    final List<TaskEntity> taskEntities = new ArrayList<>();
    taskEntity.setStatus(TaskStatusEnum.UP_FOR_GRAB);
    taskEntity.setProject(ProjectEntityTestData.getIsPublicTrue());
    taskEntities.add(taskEntity);
    return taskEntities;
  }

  public static final List<TaskEntity> listIsPublicFalse() {
    final TaskEntity taskEntity = getStatusUpFprGrab();
    final List<TaskEntity> taskEntities = new ArrayList<>();
    taskEntity.setStatus(TaskStatusEnum.UP_FOR_GRAB);
    taskEntity.setProject(ProjectEntityTestData.getIspublicFalse());
    taskEntities.add(taskEntity);
    return taskEntities;
  }

}
