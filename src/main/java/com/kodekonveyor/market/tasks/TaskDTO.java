package com.kodekonveyor.market.tasks;

import lombok.Data;

@Data
public class TaskDTO {

  private String githubId;
  private String serviceName;
  private String behaviourName;
  private String documentation;
  private String name;
  private String project;
  private String responsible;
  private TaskStatusEnum status;
}
