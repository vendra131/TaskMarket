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

  public static final TaskDTO getClosedTasks() {
    final TaskDTO taskDTO = get();
    taskDTO.setStatus(TaskStatusEnum.DONE);
    return taskDTO;
  }

  public static final TaskDTO getClosedUpForGrabTasks() {
    final TaskDTO taskDTO = get();
    taskDTO.setStatus(TaskStatusEnum.UP_FOR_GRAB);
    taskDTO.setProject(ProjectEntityTestData.getClosedProject());
    return taskDTO;
  }

  public static final TaskDTO getInProgressTasks() {
    final TaskDTO taskDTO = get();
    taskDTO.setStatus(TaskStatusEnum.IN_PROGRESS);
    return taskDTO;
  }

  public static final TaskDTO getOpenUpForGrabTasks() {
    final TaskDTO taskDTO = get();
    taskDTO.setStatus(TaskStatusEnum.UP_FOR_GRAB);
    taskDTO.setProject(ProjectEntityTestData.getOpenProject());
    return taskDTO;
  }

  public static List<TaskDTO> list() {
    return List.of(
        getInProgressTasks(), getClosedUpForGrabTasks(),
        getOpenUpForGrabTasks(), getClosedTasks()
    );
  }
}
