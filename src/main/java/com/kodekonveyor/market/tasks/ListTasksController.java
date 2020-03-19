package com.kodekonveyor.market.tasks;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.UserEntity;
import com.kodekonveyor.market.UrlMapConstants;
import com.kodekonveyor.market.register.MarketUserEntity;
import com.kodekonveyor.market.register.MarketUserEntityRepository;

@RestController
public class ListTasksController {

  @Autowired
  AuthenticatedUserService authenticatedUserService;

  @Autowired
  MarketUserEntityRepository marketUserEntityRepository;

  @Autowired
  TaskRepository taskRepository;

  @GetMapping(UrlMapConstants.LIST_TASK_PATH)
  public List<TaskDTO> call() {
    final UserEntity user = authenticatedUserService.call();
    final List<MarketUserEntity> marketUserEntities =
        marketUserEntityRepository.findByLogin(user);
    MarketUserEntity marketUserEntity = new MarketUserEntity();
    if (!marketUserEntities.isEmpty())
      marketUserEntity = marketUserEntities.get(0);
    final List<TaskDTO> ret = new ArrayList<>();
    ret.addAll(
        convertTaskEntityToDTO(
            getInProgressOrClosedTask(
                marketUserEntity, TaskStatusEnum.IN_PROGRESS
            )
        )
    );
    ret.addAll(
        convertTaskEntityToDTO(
            getClosedUpForGrabTask(marketUserEntity)
        )
    );
    ret.addAll(
        convertTaskEntityToDTO(
            getOpenUpForGrabTask()
        )
    );
    ret.addAll(
        convertTaskEntityToDTO(
            getInProgressOrClosedTask(marketUserEntity, TaskStatusEnum.DONE)
        )
    );

    return ret;
  }

  private List<TaskDTO>
      convertTaskEntityToDTO(final Iterable<TaskEntity> taIterable) {

    final List<TaskDTO> ret = new ArrayList<>();
    for (final TaskEntity taskEntity : taIterable) {
      final TaskDTO taskDTO = createTaskDTO();
      taskDTO.setGithubId(taskEntity.getGithubId());
      taskDTO.setName(taskEntity.getName());
      taskDTO.setProject(taskEntity.getProject());
      taskDTO.setResponsible(taskEntity.getResponsible());
      taskDTO.setStatus(taskEntity.getStatus());
      ret.add(taskDTO);
    }
    return ret;
  }

  private TaskDTO createTaskDTO() {
    return new TaskDTO();
  }

  private Iterable<TaskEntity> getClosedUpForGrabTask(
      final MarketUserEntity marketUserEntity
  ) {
    return taskRepository.findByStatusAndResponsibleAndProjectIsPublic(
        TaskStatusEnum.UP_FOR_GRAB, marketUserEntity, false
    );
  }

  private Iterable<TaskEntity> getInProgressOrClosedTask(
      final MarketUserEntity marketUserEntity, final TaskStatusEnum status
  ) {
    return taskRepository.findByStatusAndResponsible(
        status, marketUserEntity
    );
  }

  private Iterable<TaskEntity> getOpenUpForGrabTask() {
    return taskRepository
        .findByStatusAndProjectIsPublic(TaskStatusEnum.UP_FOR_GRAB, true);
  }

}
