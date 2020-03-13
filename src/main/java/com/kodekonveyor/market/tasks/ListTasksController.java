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
  public List<TaskDTO>
      call(final TaskStatusEnum status, final boolean... isPublic) {
    final UserEntity user = authenticatedUserService.call();

    final MarketUserEntity marketUserEntity = getMarketUserEntity(user);
    final Iterable<TaskEntity> tasks;

    if (isPublic.length > 0) {
      if (isPublic[0])
        tasks =
            taskRepository.findByStatusAndProjectIsPublic(status, isPublic[0]);
      else
        tasks = taskRepository.findByStatusAndResponsibleAndProjectIsPublic(
            status, marketUserEntity, isPublic[0]
        );
    } else
      tasks =
          taskRepository.findByStatusAndResponsible(status, marketUserEntity);

    return convertTaskEntityToDTO(tasks);
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

  private MarketUserEntity getMarketUserEntity(final UserEntity user) {
    final List<MarketUserEntity> marketUserEntities =
        marketUserEntityRepository.findByLogin(user);

    MarketUserEntity entity = new MarketUserEntity();
    if (!marketUserEntities.isEmpty())
      entity = marketUserEntities.get(0);

    return entity;
  }

}
