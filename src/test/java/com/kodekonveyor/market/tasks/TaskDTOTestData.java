package com.kodekonveyor.market.tasks;

import java.util.List;

import com.kodekonveyor.market.project.ProjectEntityTestData;
import com.kodekonveyor.market.register.MarketUserEntityTestData;

public class TaskDTOTestData {

  public static final TaskDTO get() {
    final TaskDTO taskDTO = new TaskDTO();
    taskDTO.setGithubId(TaskEntityTestData.ISSUE_ID);
    taskDTO.setServiceName(TaskEntityTestData.ISSUE_NAME);
    taskDTO.setBehaviourName(TaskEntityTestData.BEHAVIOUR);
    taskDTO.setDocumentation(TaskEntityTestData.DOCUMENTATION);
    taskDTO.setProject(ProjectEntityTestData.get().getName());
    taskDTO
        .setResponsible(MarketUserEntityTestData.get().getLogin().getLogin());
    return taskDTO;
  }

  public static final TaskDTO getDifferentIssueName() {
    final TaskDTO taskDTO = get();
    taskDTO.setServiceName(TaskEntityTestData.DIFFERENT_ISSUE_NAME);
    return taskDTO;
  }

  public static final TaskDTO getNewDescription() {
    final TaskDTO taskDTO = get();
    taskDTO.setDocumentation(TaskEntityTestData.NEW_DESCRIPTION);
    return taskDTO;
  }

  public static final List<TaskDTO> list() {
    return List.of(get());
  }

}
