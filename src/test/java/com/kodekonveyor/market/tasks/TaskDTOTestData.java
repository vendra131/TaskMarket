package com.kodekonveyor.market.tasks;

public class TaskDTOTestData {

  public static TaskDTO get() {
    final TaskDTO dto = new TaskDTO();
    dto.setId(TaskTestData.ID);
    dto.setService(TaskTestData.SERVICE);
    dto.setBehaviour(TaskTestData.BEHAVIOUR);
    dto.setGithubId(TaskTestData.GITHUB_ID);
    dto.setDescription(TaskTestData.DESCRIPTION);

    return dto;
  }

  public static final TaskDTO getDifferentBehaviour() {
    final TaskDTO taskDTO = get();
    taskDTO.setBehaviour(TaskTestData.DIFFERENT_BEHAVIOUR);
    return taskDTO;
  }

  public static final TaskDTO getNewDescription() {
    final TaskDTO taskDTO = get();
    taskDTO.setDescription(TaskTestData.NEW_DESCRIPTION);
    return taskDTO;
  }

}
