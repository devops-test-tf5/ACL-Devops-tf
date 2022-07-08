package com.acldigital.unaito.db.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.acldigital.unaito.db.IProjectsDataService;
import com.acldigital.unaito.db.mapper.MapperUtils;
import com.acldigital.unaito.service.customer.CustomerDto;
import com.acldigital.unaito.service.entity.ActivityPlanEntity;
import com.acldigital.unaito.service.entity.ProjectTeamEntity;
import com.acldigital.unaito.service.entity.ProjectsEntity;
import com.acldigital.unaito.service.entity.ResourceOnboardingEntity;
import com.acldigital.unaito.service.entity.TeamMemberEntity;
import com.acldigital.unaito.service.project.dto.TeamMember;
import com.acldigital.unaito.service.project.dto.TeamOnboarding;
import com.acldigital.unaito.service.repository.IActivityPlanRepository;
import com.acldigital.unaito.service.repository.IProjectTeamRepository;
import com.acldigital.unaito.service.repository.IProjectsRepository;
import com.acldigital.unaito.service.repository.IResourcePlanRepository;
import com.acldigital.unaito.service.repository.ITeamMembersRepository;
import com.acldigital.unaito.service.user.dto.ActivityPlan;
import com.acldigital.unaito.service.user.dto.ProjectsDto;
import com.acldigital.unaito.service.user.dto.ResourceOnboardingPlan;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class ProjectsDataServiceImpl implements IProjectsDataService {

	@Autowired
	private MapperUtils mapperUtils;

	@Autowired
	private IProjectsRepository projectRepository;

	@Autowired
	private IProjectTeamRepository projectTeamRepository;

	@Autowired
	private ITeamMembersRepository teamMemberRepository;

	@Autowired
	private IActivityPlanRepository activityPlanRepository;

	@Autowired
	private IResourcePlanRepository resourcePlanRepository;

	@Override
	public ProjectsDto createNewProject(ProjectsDto project, CustomerDto customerDto) throws JsonProcessingException {
		ProjectsEntity projectEntity = mapperUtils.convertToProjectEntity(project, customerDto);
		ProjectsEntity respEntity = projectRepository.save(projectEntity);
		return mapperUtils.convertToProjectsDto(respEntity);
	}

	@Override
	public TeamOnboarding saveTeamOnboardingInfos(TeamOnboarding onboardingRequest, Long projectId) {
		List<TeamMember> teamMembersList = new ArrayList<>();
		Long onboardingId = projectTeamRepository.checkIfOnboardingAvailable(projectId);
		ProjectTeamEntity entity = null;
		if (!ObjectUtils.isEmpty(onboardingId)) {
			entity = mapperUtils.convertToProjectTeamEntityWithOnboardingId(onboardingRequest, projectId, onboardingId);
		} else {
			entity = mapperUtils.convertToProjectTeamEntity(onboardingRequest, projectId);
		}
		ProjectTeamEntity responseEnity = projectTeamRepository.save(entity);
		if (!ObjectUtils.isEmpty(responseEnity)) {
			List<TeamMemberEntity> memberEntities = teamMemberRepository.fetchTeamMembersByOnboardingId(onboardingId);
			for (TeamMemberEntity memberEntity : memberEntities) {
				teamMembersList.add(new TeamMember(memberEntity.getTeamMemberId(), memberEntity.getMemberName(),
						memberEntity.getUserId(), memberEntity.getRoleId(), memberEntity.getEmail()));
			}
		}
		return mapperUtils.convertToProjectTeamDto(responseEnity, teamMembersList);
	}

	@Override
	public ProjectsDto saveDriversInfos(JsonNode driverRequest, Long projectId) throws JsonProcessingException {
		Optional<ProjectsEntity> entity = projectRepository.findById(projectId);
		ProjectsEntity updatedEntity = null;
		if (entity.isPresent()) {
			updatedEntity = entity.get();
			updatedEntity.setDrivers(driverRequest.toString());
		}
		ProjectsEntity respEntity = projectRepository.save(updatedEntity);
		return mapperUtils.convertToProjectsDto(respEntity);
	}

	@Override
	public ProjectsDto saveScopeInfos(JsonNode scopeRequest, Long projectId) throws JsonProcessingException {
		Optional<ProjectsEntity> entity = projectRepository.findById(projectId);
		ProjectsEntity updatedEntity = null;
		if (entity.isPresent()) {
			updatedEntity = entity.get();
			updatedEntity.setScope(scopeRequest.toString());
		}
		ProjectsEntity respEntity = projectRepository.save(updatedEntity);
		return mapperUtils.convertToProjectsDto(respEntity);
	}

	@Override
	public ActivityPlan addActivityPlan(ActivityPlan activityPlan, Long projectId) {
		ActivityPlanEntity entity = null;
		if (!ObjectUtils.isEmpty(activityPlan)) {
			entity = activityPlanRepository.save(mapperUtils.convertToActivityPlanEntity(activityPlan, projectId));
		}
		if (!ObjectUtils.isEmpty(entity)) {
			return mapperUtils.convertToActivityPlanDto(entity);
		}
		return null;
	}

	@Override
	public ResourceOnboardingPlan addResourcePlan(ResourceOnboardingPlan resourcePlan, Long projectId) {
		ResourceOnboardingEntity entity = null;
		if (!ObjectUtils.isEmpty(resourcePlan)) {
			entity = resourcePlanRepository.save(mapperUtils.convertToResourcePlanEntity(resourcePlan, projectId));
		}
		if (!ObjectUtils.isEmpty(entity)) {
			return mapperUtils.convertToResourceOnboardingPlan(entity);
		}
		return null;
	}

	@Override
	public ProjectsDto fetchProjectDetails(Long projectId) {
		Optional<ProjectsEntity> entity = null;
		ProjectsDto projectsDto = null;
		entity = projectRepository.findById(projectId);
		if (entity.isPresent()) {
			projectsDto = mapperUtils.convertToCompleteProjectsDto(entity.get());
		}
		return projectsDto;
	}

}
