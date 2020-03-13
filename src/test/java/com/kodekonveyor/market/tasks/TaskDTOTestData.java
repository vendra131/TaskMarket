package com.kodekonveyor.market.tasks;

import java.util.ArrayList;
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

  public static final List<TaskDTO> getClosedTasks() {
    final TaskDTO taskDTO = get();
    final List<TaskDTO> dtos = new ArrayList<>();
    taskDTO.setStatus(TaskStatusEnum.DONE);
    dtos.add(taskDTO);
    return dtos;
  }

  public static final List<TaskDTO> getClosedUpForGrabTasks() {
    final TaskDTO taskDTO = get();
    final List<TaskDTO> dtos = new ArrayList<>();
    taskDTO.setStatus(TaskStatusEnum.UP_FOR_GRAB);
    taskDTO.setProject(ProjectEntityTestData.getClosedProject());
    dtos.add(taskDTO);
    return dtos;
  }

  public static final List<TaskDTO> getInProgressTasks() {
    final TaskDTO taskDTO = get();
    final List<TaskDTO> dtos = new ArrayList<>();
    taskDTO.setStatus(TaskStatusEnum.IN_PROGRESS);
    dtos.add(taskDTO);
    return dtos;
  }

  public static final List<TaskDTO> getOpenUpForGrabTasks() {
    final TaskDTO taskDTO = get();
    final List<TaskDTO> dtos = new ArrayList<>();
    taskDTO.setStatus(TaskStatusEnum.UP_FOR_GRAB);
    taskDTO.setProject(ProjectEntityTestData.getOpenProject());
    dtos.add(taskDTO);
    return dtos;
  }
}
