package com.kodekonveyor.market.tasks;

import java.util.List;

import com.kodekonveyor.market.project.ProjectEntityTestData;
import com.kodekonveyor.market.register.MarketUserEntityTestData;

public class TaskDTOTestData {

  public static final TaskDTO get() {
    final TaskDTO taskDTO = new TaskDTO();
    taskDTO.setGithubId(TaskEntityTestData.ISSUE_ID);
    taskDTO.setName(TaskEntityTestData.ISSUE_NAME);
    taskDTO.setProject(ProjectEntityTestData.get());
    taskDTO.setResponsible(MarketUserEntityTestData.get());
    return taskDTO;
  }

  public static final TaskDTO getIsPublicFalse() {
    final TaskDTO taskDTO = getStatusUpForGrab();
    taskDTO.setProject(ProjectEntityTestData.getIspublicFalse());
    return taskDTO;
  }

  public static final TaskDTO getIsPublicTrue() {
    final TaskDTO taskDTO = getStatusUpForGrab();
    taskDTO.setProject(ProjectEntityTestData.getIsPublicTrue());
    return taskDTO;
  }

  public static final TaskDTO getStatusDone() {
    final TaskDTO taskDTO = get();
    taskDTO.setStatus(TaskStatusEnum.DONE);
    return taskDTO;
  }

  public static final TaskDTO getStatusInProgress() {
    final TaskDTO taskDTO = get();
    taskDTO.setStatus(TaskStatusEnum.IN_PROGRESS);
    return taskDTO;
  }

  public static final TaskDTO getStatusUpForGrab() {
    final TaskDTO taskDTO = get();
    taskDTO.setStatus(TaskStatusEnum.UP_FOR_GRAB);
    return taskDTO;
  }

  public static List<TaskDTO> list() {
    return List.of(
        getStatusInProgress(), getIsPublicFalse(),
        getIsPublicTrue(), getStatusDone()
    );
  }
}
