package com.kodekonveyor.market.tasks;

import com.kodekonveyor.market.project.ProjectEntity;
import com.kodekonveyor.market.register.MarketUserEntity;

import lombok.Data;

@Data
public class TaskDTO {

  private String githubId;

  private String name;

  private ProjectEntity project;

  private MarketUserEntity responsible;

  private TaskStatusEnum status;
}
