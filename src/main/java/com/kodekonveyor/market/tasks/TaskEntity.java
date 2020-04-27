package com.kodekonveyor.market.tasks;

import javax.persistence.Entity;

import com.kodekonveyor.market.project.ProjectEntity;
import com.kodekonveyor.market.register.MarketUserEntity;

import lombok.Data;

@Data
@Entity
public class TaskEntity {

  private String githubId;
  private String serviceName;
  private String behaviourName;
  private String documentation;
  private ProjectEntity project;
  private MarketUserEntity responsible;
  private TaskStatusEnum status;
}
