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
import com.acldigital.unaito.service.entity.ApplicationLayerEntity;
import com.acldigital.unaito.service.entity.ApplicationOverviewEntity;
import com.acldigital.unaito.service.entity.IntegrationLayerEntity;
import com.acldigital.unaito.service.entity.NotificationsEntity;
import com.acldigital.unaito.service.entity.ProjectTeamEntity;
import com.acldigital.unaito.service.entity.ProjectsEntity;
import com.acldigital.unaito.service.entity.StorageDetailsEntity;
import com.acldigital.unaito.service.entity.TeamMemberEntity;
import com.acldigital.unaito.service.entity.WorkflowMgmtEntity;
import com.acldigital.unaito.service.project.dto.ApplicationOverview;
import com.acldigital.unaito.service.project.dto.TeamMember;
import com.acldigital.unaito.service.project.dto.TeamOnboarding;
import com.acldigital.unaito.service.repository.IApplicationLayerRepository;
import com.acldigital.unaito.service.repository.IApplicationOverviewRepository;
import com.acldigital.unaito.service.repository.IIntegrationLayerRespository;
import com.acldigital.unaito.service.repository.INotificationsRepository;
import com.acldigital.unaito.service.repository.IProjectTeamRepository;
import com.acldigital.unaito.service.repository.IProjectsRepository;
import com.acldigital.unaito.service.repository.IResourcePlanRepository;
import com.acldigital.unaito.service.repository.IStorageDetailsRepository;
import com.acldigital.unaito.service.repository.ITeamMembersRepository;
import com.acldigital.unaito.service.repository.IWorkflowMgmtRepository;
import com.acldigital.unaito.service.user.dto.ApplicationLayerDetails;
import com.acldigital.unaito.service.user.dto.IntegrationLayerDetails;
import com.acldigital.unaito.service.user.dto.Notifications;
import com.acldigital.unaito.service.user.dto.ProjectsDto;
import com.acldigital.unaito.service.user.dto.StorageDetails;
import com.acldigital.unaito.service.user.dto.WorkflowMgmt;
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
	private IResourcePlanRepository resourcePlanRepository;

	@Autowired
	private IApplicationOverviewRepository applicationRepository;

	@Autowired
	private IIntegrationLayerRespository integrationLayerRespository;

	@Autowired
	private IApplicationLayerRepository applicationLayerRepository;

	@Autowired
	private IStorageDetailsRepository storageDetailsRepository;

	@Autowired
	private INotificationsRepository notificationsRepository;

	@Autowired
	private IWorkflowMgmtRepository workflowMgmtRepository;

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
			List<TeamMemberEntity> memberEntities = teamMemberRepository
					.fetchTeamMembersByOnboardingId(responseEnity.getOnboardingId());
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
	public ProjectsDto addActivityPlan(JsonNode activityPlan, Long projectId) throws JsonProcessingException {
		/*
		 * ActivityPlanEntity entity = null; if (!ObjectUtils.isEmpty(activityPlan)) {
		 * entity = activityPlanRepository.save(mapperUtils.convertToActivityPlanEntity(
		 * activityPlan, projectId)); } if (!ObjectUtils.isEmpty(entity)) { return
		 * mapperUtils.convertToActivityPlanDto(entity); }
		 */
		Optional<ProjectsEntity> entity = projectRepository.findById(projectId);
		ProjectsEntity updatedEntity = null;
		if (entity.isPresent()) {
			updatedEntity = entity.get();
			updatedEntity.setActivityPlans(activityPlan.toString());
		}
		ProjectsEntity respEntity = projectRepository.save(updatedEntity);
		return mapperUtils.convertToProjectsDto(respEntity);

	}

	@Override
	public ProjectsDto addResourcePlan(JsonNode resourcePlan, Long projectId) throws JsonProcessingException {
		/*
		 * ResourceOnboardingEntity entity = null; if
		 * (!ObjectUtils.isEmpty(resourcePlan)) { entity =
		 * resourcePlanRepository.save(mapperUtils.convertToResourcePlanEntity(
		 * resourcePlan, projectId)); } if (!ObjectUtils.isEmpty(entity)) { return
		 * mapperUtils.convertToResourceOnboardingPlan(entity); } return null;
		 */
		Optional<ProjectsEntity> entity = projectRepository.findById(projectId);
		ProjectsEntity updatedEntity = null;
		if (entity.isPresent()) {
			updatedEntity = entity.get();
			updatedEntity.setResourcePlans(resourcePlan.toString());
		}
		ProjectsEntity respEntity = projectRepository.save(updatedEntity);
		return mapperUtils.convertToProjectsDto(respEntity);
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

	@Override
	public List<ProjectsDto> fetchAllProjectDetails() {
		Iterable<ProjectsEntity> listOfProjectsEntities = projectRepository.findAll();
		if (!ObjectUtils.isEmpty(listOfProjectsEntities)) {
			return mapperUtils.convertToListOfProjectsDto(listOfProjectsEntities);
		}
		return null;
	}

	@Override
	public ApplicationOverview addApplicationOverviewDetails(ApplicationOverview applicationOverview, Long projectId) {
		ApplicationOverviewEntity entity = null;
		if (!ObjectUtils.isEmpty(applicationOverview)) {
			entity = mapperUtils.convertToApplicationOverviewEntity(applicationOverview);
			entity.setProjectEntity(new ProjectsEntity(projectId));
		}
		ApplicationOverviewEntity responseEntity = applicationRepository.save(entity);
		// commenting the below line temperorily
		return mapperUtils.convertToApplicationOverview(responseEntity);
	}

	@Override
	public IntegrationLayerDetails addIngrationLayerDetails(IntegrationLayerDetails integrationLayerDetails,
			Long applicationId) {
		IntegrationLayerEntity responseEntity = null;
		IntegrationLayerEntity entity = null;
		if (!ObjectUtils.isEmpty(integrationLayerDetails)) {
			entity = mapperUtils.convertToIntegrationLayerDetailsEntity(integrationLayerDetails);
			entity.setApplicationOverviewEntity(new ApplicationOverviewEntity(applicationId));
			//entity.setProjectsEntity(new ProjectsEntity(projectId));
		}
		responseEntity = integrationLayerRespository.save(entity);
		return mapperUtils.convertToIntegrationLayerDetails(responseEntity);
	}

	@Override
	public ApplicationLayerDetails addApplicationLayerDetails(ApplicationLayerDetails applicationLayerDetails,
			Long applicationId) {
		ApplicationLayerEntity entity = null;
		ApplicationLayerEntity responseEntity = null;
		if (!ObjectUtils.isEmpty(applicationLayerDetails)) {
			entity = mapperUtils.convertToApplicationLayerEntity(applicationLayerDetails);
			entity.setApplicationOverviewEntity(new ApplicationOverviewEntity(applicationId));
		}
		responseEntity = applicationLayerRepository.save(entity);
		return mapperUtils.convertToApplicationLayerDetails(responseEntity);
	}

	@Override
	public StorageDetails addStorageDetails(StorageDetails storageDetails, Long applicationId) {
		StorageDetailsEntity entity = null;
		StorageDetailsEntity responDetailsEntity = null;
		if (!ObjectUtils.isEmpty(storageDetails)) {
			entity = mapperUtils.convertToStorageDetailsEntity(storageDetails);
			entity.setApplicationOverviewEntity(new ApplicationOverviewEntity(applicationId));
		}
		responDetailsEntity = storageDetailsRepository.save(entity);
		return mapperUtils.convertToStorageDetailsDto(responDetailsEntity);
	}

	@Override
	public Notifications addNotifications(Notifications notifications, Long projectId) {
		NotificationsEntity entity = null;
		NotificationsEntity responseEntity = null;
		if (!ObjectUtils.isEmpty(notifications)) {
			entity = mapperUtils.convertToNotificationsEntity(notifications);
			entity.setProjectEntity(new ProjectsEntity(projectId));
		}
		responseEntity = notificationsRepository.save(entity);
		return mapperUtils.convertToNotificationsDto(responseEntity);
	}

	@Override
	public WorkflowMgmt createWorkflow(WorkflowMgmt workflowMgmt, Long projectId) {
		WorkflowMgmtEntity entity = null;
		WorkflowMgmtEntity responseEntity = null;
		if (!ObjectUtils.isEmpty(workflowMgmt)) {
			entity = mapperUtils.convertToWorkflowMgmtEntity(workflowMgmt);
			entity.setProjectEntity(new ProjectsEntity(projectId));
		}
		responseEntity = workflowMgmtRepository.save(entity);
		return mapperUtils.convertToWorkflowMgmtDto(responseEntity);
	}

	/*
	 * @Override public List<ApplicationOverview> getAllApplicationsByProjectId(Long
	 * projectId) {
	 * 
	 * Optional<ProjectsEntity> projectEntities =
	 * projectRepository.findById(projectId); ProjectsEntity entity=null;
	 * if(projectEntities.isPresent()) { entity=projectEntities.get(); }
	 * List<ApplicationOverview> applicationsList = new ArrayList<>();
	 * applicationsList = mapperUtils.convertToApplicationOverviewList(entity);
	 * 
	 * return null; }
	 */

}
