package com.kodekonveyor.market.tasks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetRepositoryTasksService {

  @Autowired
  private TaskEntityRepository taskRepository;

  public List<TaskDTO> call() {
    final List<TaskEntity> tasks = (List<TaskEntity>) taskRepository.findAll();
    tasks.forEach(task -> new TaskListDTO(task));
    return TaskListDTO.list();
  }
}
