package com.kodekonveyor.market.project;

import java.util.List;

public class ProjectEntityTestData {

  public static final ProjectEntity get() {
    final ProjectEntity entity = new ProjectEntity();
    entity.setId(ProjectDTOTestData.ID);
    entity.setName(ProjectDTOTestData.NAME);
    return entity;
  }

  public static final ProjectEntity getClosedProject() {
    final ProjectEntity entity = get();
    entity.setPublic(false);
    return entity;
  }

  public static final ProjectEntity getOpenProject() {
    final ProjectEntity entity = get();
    entity.setPublic(true);
    return entity;
  }

  public static Object list() {
    return List.of(get());
  }

}
