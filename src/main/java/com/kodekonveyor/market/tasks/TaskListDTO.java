package com.kodekonveyor.market.tasks;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import lombok.Data;

@Data
public class TaskListDTO {

  private static List<TaskDTO> tasks = new ArrayList<>();

  public static List<TaskDTO> list() {
    return tasks;

  }

  public TaskListDTO(final TaskEntity task) {
    final TaskDTO taskDTO = new TaskDTO();
    BeanUtils.copyProperties(task, taskDTO);
    tasks.add(taskDTO);
  }

}
