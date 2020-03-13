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

  public static final List<TaskEntity> getClosedTasks() {
    final TaskEntity taskEntity = get();
    final List<TaskEntity> taskEntities = new ArrayList<>();
    taskEntity.setStatus(TaskStatusEnum.DONE);
    taskEntities.add(taskEntity);
    return taskEntities;
  }

  public static final List<TaskEntity> getClosedUpForGrabTasks() {
    final TaskEntity taskEntity = get();
    final List<TaskEntity> taskEntities = new ArrayList<>();
    taskEntity.setStatus(TaskStatusEnum.UP_FOR_GRAB);
    taskEntity.setProject(ProjectEntityTestData.getClosedProject());
    taskEntities.add(taskEntity);
    return taskEntities;
  }

  public static final List<TaskEntity> getInProgressTasks() {
    final TaskEntity taskEntity = get();
    final List<TaskEntity> taskEntities = new ArrayList<>();
    taskEntity.setStatus(TaskStatusEnum.IN_PROGRESS);
    taskEntities.add(taskEntity);
    return taskEntities;
  }

  public static final List<TaskEntity> getOpenUpForGrabTasks() {
    final TaskEntity taskEntity = get();
    final List<TaskEntity> taskEntities = new ArrayList<>();
    taskEntity.setStatus(TaskStatusEnum.UP_FOR_GRAB);
    taskEntity.setProject(ProjectEntityTestData.getOpenProject());
    taskEntities.add(taskEntity);
    return taskEntities;
  }
}
