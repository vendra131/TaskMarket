package com.kodekonveyor.market.tasks;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.kodekonveyor.market.project.ProjectEntityTestData;
import com.kodekonveyor.market.register.MarketUserEntityTestData;

@Generated("by zenta-tools")
public class TaskEntityTestData {

  public static final long ISSUE_ID_INPROGRESS = 4567;
  public static final long ISSUE_ID_UPFORGRAB_OPEN = 5897;
  public static final long ISSUE_ID_UPFORGRAB_CLOSED = 5997;
  public static final long ISSUE_ID_CLOSED = 9897;
  public static final long ISSUE_ID = 4422;

  public final static TaskEntity get() {
    final TaskEntity taskEntity = new TaskEntity();
    taskEntity.setId(TaskTestData.ID);
    taskEntity.setMarketUser(MarketUserEntityTestData.get());
    taskEntity.setService(TaskTestData.SERVICE);
    taskEntity.setBehaviour(TaskTestData.BEHAVIOUR);
    taskEntity.setGithubId(TaskTestData.GITHUB_ID);
    taskEntity.setDescription(TaskTestData.DESCRIPTION);

    return taskEntity;
  };

  public static final TaskEntity getStatusUpFprGrab() {
    final TaskEntity taskEntity = get();
    taskEntity.setStatus(TaskStatusEnum.UP_FOR_GRAB);
    return taskEntity;
  }

  public static final List<TaskEntity> listStatusDone() {
    final TaskEntity taskEntity = get();
    final List<TaskEntity> taskEntities = new ArrayList<>();
    taskEntity.setGithubId(ISSUE_ID_CLOSED);
    taskEntity.setStatus(TaskStatusEnum.DONE);
    taskEntities.add(taskEntity);
    return taskEntities;
  }

  public static final List<TaskEntity> listStatusInProgress() {
    final TaskEntity taskEntity = get();
    final List<TaskEntity> taskEntities = new ArrayList<>();
    taskEntity.setGithubId(ISSUE_ID_INPROGRESS);
    taskEntity.setStatus(TaskStatusEnum.IN_PROGRESS);
    taskEntities.add(taskEntity);
    return taskEntities;
  }

  public static final List<TaskEntity> listIsPublicTrue() {
    final TaskEntity taskEntity = getStatusUpFprGrab();
    final List<TaskEntity> taskEntities = new ArrayList<>();
    taskEntity.setGithubId(ISSUE_ID_UPFORGRAB_OPEN);
    taskEntity.setStatus(TaskStatusEnum.UP_FOR_GRAB);
    taskEntity.setProject(ProjectEntityTestData.getIsPublicTrue());
    taskEntities.add(taskEntity);
    return taskEntities;
  }

  public static final List<TaskEntity> listIsPublicFalse() {
    final TaskEntity taskEntity = getStatusUpFprGrab();
    final List<TaskEntity> taskEntities = new ArrayList<>();
    taskEntity.setGithubId(ISSUE_ID_UPFORGRAB_CLOSED);
    taskEntity.setStatus(TaskStatusEnum.UP_FOR_GRAB);
    taskEntity.setProject(ProjectEntityTestData.getIspublicFalse());
    taskEntities.add(taskEntity);
    return taskEntities;
  }
}
