package com.kodekonveyor.market.tasks;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.kodekonveyor.market.project.ProjectEntity;
import com.kodekonveyor.market.register.MarketUserEntity;

import lombok.Data;

@Data
@Entity
public class TaskEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  
  @Id
  private String githubId;
  private String name;

  @OneToOne(fetch = FetchType.LAZY)
  private ProjectEntity project;

  @OneToOne(fetch = FetchType.LAZY)
  private MarketUserEntity responsible;
  private TaskStatusEnum status;
}
