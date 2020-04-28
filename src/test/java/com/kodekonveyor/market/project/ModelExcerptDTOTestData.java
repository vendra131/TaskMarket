package com.kodekonveyor.market.project;

import com.kodekonveyor.market.tasks.TaskDTOTestData;

public class ModelExcerptDTOTestData {

  public static final String MILESTONE = "first milestone";

  public static ModelExcerptDTO get() {
    final ModelExcerptDTO dto = new ModelExcerptDTO();
    dto.setMilestones(MILESTONE);
    dto.setTasks(TaskDTOTestData.get());
    return dto;
  }

  public static ModelExcerptDTO getDifferentTaskName() {
    final ModelExcerptDTO dto = new ModelExcerptDTO();
    dto.setTasks(TaskDTOTestData.getDifferentIssueName());
    return dto;
  }

  public static ModelExcerptDTO getNewDescription() {
    final ModelExcerptDTO dto = new ModelExcerptDTO();
    dto.setTasks(TaskDTOTestData.getNewDescription());
    return dto;
  }

}
