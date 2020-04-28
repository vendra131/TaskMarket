package com.kodekonveyor.market.tasks;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodekonveyor.authentication.AuthenticatedUserService;
import com.kodekonveyor.authentication.UserEntity;
import com.kodekonveyor.market.UnauthorizedException;
import com.kodekonveyor.market.lead.CheckRoleUtil;
import com.kodekonveyor.market.project.ProjectConstants;
import com.kodekonveyor.market.project.ProjectEntity;
import com.kodekonveyor.market.project.ProjectEntityRepository;
import com.kodekonveyor.market.register.MarketUserEntity;
import com.kodekonveyor.market.register.MarketUserEntityRepository;

@Service
public class UpdateTasksService {

  @Autowired
  private GetRepositoryTasksService getRepositoryTasksService;

  @Autowired
  private TaskEntityRepository taskEntityRepository;

  @Autowired
  private AuthenticatedUserService authenticatedUserService;

  @Autowired
  private ProjectEntityRepository projectEntityRepository;

  @Autowired
  private MarketUserEntityRepository marketUserEntityRepository;

  public void call(final TaskDTO taskDTO) {

    final UserEntity user = authenticatedUserService.call();
    if (
      !CheckRoleUtil.hasRole(user, ProjectConstants.PROJECT_MANAGER)
    )
      throw new UnauthorizedException(TaskConstants.NO_PROJECT_MANAGER_ROLE);

    final List<TaskDTO> list = getRepositoryTasksService.call();
    for (final TaskDTO dto : list)
      if (dto.getName().equals(taskDTO.getName())) {
        if (!dto.getDocumentation().equals(taskDTO.getDocumentation())) {
          final String description = StringUtils.substringBetween(
              taskDTO.getDocumentation(), TaskConstants.START_DELIMETER,
              TaskConstants.END_DELIMETER
          );
          dto.setDocumentation(
              TaskConstants.START_DELIMETER + description +
                  TaskConstants.END_DELIMETER
          );
          storage(dto);
        }
      } else
        storage(taskDTO);
  }

  private void storage(final TaskDTO taskDTO) {
    final TaskEntity taskEntity = new TaskEntity();
    taskEntity.setBehaviourName(taskDTO.getBehaviourName());
    taskEntity.setDocumentation(taskDTO.getDocumentation());
    taskEntity.setGithubId(taskDTO.getGithubId());
    taskEntity.setName(taskDTO.getName());
    taskEntity.setStatus(taskDTO.getStatus());
    final ProjectEntity projectEntity =
        projectEntityRepository.findByName(taskDTO.getProject()).get(0);
    taskEntity.setProject(projectEntity);

    final MarketUserEntity marketUserEntity = marketUserEntityRepository
        .findByLoginLogin(taskDTO.getResponsible()).get(0);
    taskEntity.setResponsible(marketUserEntity);
    taskEntityRepository.save(taskEntity);
  }
}
