package com.acldigital.unaito.db.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.acldigital.unaito.service.customer.CustomerDto;
import com.acldigital.unaito.service.entity.ActivityPlanEntity;
import com.acldigital.unaito.service.entity.ApplicationLayerEntity;
import com.acldigital.unaito.service.entity.ApplicationOverviewEntity;
import com.acldigital.unaito.service.entity.CommunicationTemplateMasterEntity;
import com.acldigital.unaito.service.entity.CustomersEntity;
import com.acldigital.unaito.service.entity.IntegrationLayerEntity;
import com.acldigital.unaito.service.entity.NotificationsEntity;
import com.acldigital.unaito.service.entity.ProjectTeamEntity;
import com.acldigital.unaito.service.entity.ProjectsEntity;
import com.acldigital.unaito.service.entity.RecommendationsEntity;
import com.acldigital.unaito.service.entity.ResourceOnboardingEntity;
import com.acldigital.unaito.service.entity.RoleEntity;
import com.acldigital.unaito.service.entity.SecurityComplianceEntity;
import com.acldigital.unaito.service.entity.ServerDetailsEntity;
import com.acldigital.unaito.service.entity.StorageDetailsEntity;
import com.acldigital.unaito.service.entity.TeamMemberEntity;
import com.acldigital.unaito.service.entity.UserCryptoEntity;
import com.acldigital.unaito.service.entity.UserEmailVerificationEntity;
import com.acldigital.unaito.service.entity.UserEntity;
import com.acldigital.unaito.service.entity.UserLoggedInEntity;
import com.acldigital.unaito.service.entity.WorkflowMgmtEntity;
import com.acldigital.unaito.service.project.dto.ApplicationOverview;
import com.acldigital.unaito.service.project.dto.TeamMember;
import com.acldigital.unaito.service.project.dto.TeamOnboarding;
import com.acldigital.unaito.service.repository.IRoleRepository;
import com.acldigital.unaito.service.security.constants.RoleConstantsEnum;
import com.acldigital.unaito.service.user.constants.StatusEnum;
import com.acldigital.unaito.service.user.constants.UserConstants;
import com.acldigital.unaito.service.user.dto.ActivityPlan;
import com.acldigital.unaito.service.user.dto.ApplicationLayerDetails;
import com.acldigital.unaito.service.user.dto.CommunicationTemplateDetails;
import com.acldigital.unaito.service.user.dto.IntegrationLayerDetails;
import com.acldigital.unaito.service.user.dto.Notifications;
import com.acldigital.unaito.service.user.dto.ProjectTeam;
import com.acldigital.unaito.service.user.dto.ProjectsDto;
import com.acldigital.unaito.service.user.dto.Recommendations;
import com.acldigital.unaito.service.user.dto.ResourceOnboardingPlan;
import com.acldigital.unaito.service.user.dto.Roles;
import com.acldigital.unaito.service.user.dto.SecurityCompliance;
import com.acldigital.unaito.service.user.dto.ServerDetails;
import com.acldigital.unaito.service.user.dto.StorageDetails;
import com.acldigital.unaito.service.user.dto.UserCryptoDetails;
import com.acldigital.unaito.service.user.dto.UserDto;
import com.acldigital.unaito.service.user.dto.UserEmailVerification;
import com.acldigital.unaito.service.user.dto.UserLoggedInDetails;
import com.acldigital.unaito.service.user.dto.UserRegistrationDetails;
import com.acldigital.unaito.service.user.dto.WorkflowMgmt;
import com.acldigital.unaito.service.utils.ObjectMapperUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MapperUtils {

	@Autowired
	private IRoleRepository roleRepository;

	public UserDto convertToUserDto(UserEntity userEntity, String roleName) {
		return new UserDto(userEntity.getUserId(), userEntity.getUserName(), userEntity.getPassword(),
				userEntity.getFirstName(), userEntity.getLastName(), userEntity.getEmail(), roleName,
				userEntity.getContactNumber(), UserConstants.ACTIVE_STATUS, userEntity.getLocation(),userEntity.isFirstTimeLogin());
	}

	public UserDto convertToUserDto(UserEntity userEntity) {
		return new UserDto(userEntity.getUserId(), userEntity.getUserName(), userEntity.getPassword(),
				userEntity.getFirstName(), userEntity.getLastName(), userEntity.getEmail(), null,
				userEntity.getContactNumber(), UserConstants.ACTIVE_STATUS, userEntity.getLocation(),userEntity.isFirstTimeLogin());
	}

	public UserLoggedInEntity convertToUserLoginDetailsEntity(UserLoggedInDetails userLoggedInDetails) {
		UserLoggedInEntity entity = null;
		if (!ObjectUtils.isEmpty(userLoggedInDetails)) {
			return new UserLoggedInEntity(userLoggedInDetails.getUserId(), userLoggedInDetails.getSessionId(),
					userLoggedInDetails.getJwtType(), null, userLoggedInDetails.getJwt(),
					userLoggedInDetails.getJwtCreatedTime(), userLoggedInDetails.getJwtExpiryTime(), UserConstants.YES,
					userLoggedInDetails.getLoggedInTime(), UserConstants.NO);
		}
		return entity;
	}

	public UserLoggedInEntity convertToLoginDetailsEntity(UserLoggedInDetails userLoggedInDetails) {
		UserLoggedInEntity entity = null;
		if (!ObjectUtils.isEmpty(userLoggedInDetails)) {
			return new UserLoggedInEntity(userLoggedInDetails.getLoginId(), userLoggedInDetails.getUserId(),
					userLoggedInDetails.getJwtType(), userLoggedInDetails.getPreviousJwt(),
					userLoggedInDetails.getLoggedIn(), userLoggedInDetails.getLoggedOut(),
					userLoggedInDetails.getLoggedOutTime());
		}
		return entity;
	}

	public UserLoggedInDetails convertToUserLoginDetailsDto(UserLoggedInEntity entity) {
		UserLoggedInDetails loginDetails = null;
		if (!ObjectUtils.isEmpty(entity)) {
			return new UserLoggedInDetails(entity.getLoginId(), entity.getUserId(), entity.getSessionId(),
					entity.getJwtType(), null, entity.getJwt(), entity.getJwtCreatedTime(), entity.getJwtExpiryTime(),
					entity.getLoggedIn(), entity.getLoggedInTime());
		}
		return loginDetails;
	}

	public UserEntity convertToUserEntity(UserRegistrationDetails userRegistrationDetails) {
		UserEntity userEntity = new UserEntity();
		if (!ObjectUtils.isEmpty(userRegistrationDetails)) {
			return new UserEntity(userRegistrationDetails.getUserName(), userRegistrationDetails.getFirstName(),
					userRegistrationDetails.getLastName(), userRegistrationDetails.getPassword(),
					userRegistrationDetails.getEmail(), UserConstants.INACTIVE_STATUS,
					userRegistrationDetails.getContactNumber(), userRegistrationDetails.getLocation(),
					UserConstants.MAX_WRONG_PASSWORD_COUNT, UserConstants.DEFAULT_WRONG_PASSWORD_COUNT);
		}
		return userEntity;
	}

	public UserRegistrationDetails convertToUserRegistrationDetails(UserEntity userEntity) {
		UserRegistrationDetails userRegistrationDetails = null;
		if (!ObjectUtils.isEmpty(userEntity)) {
			userRegistrationDetails.setUserName(userEntity.getUserName());
			userRegistrationDetails.setFirstName(userEntity.getFirstName());
			userRegistrationDetails.setLastName(userEntity.getLastName());
			userRegistrationDetails.setEmail(userEntity.getEmail());
			userRegistrationDetails.setContactNumber(userEntity.getContactNumber());
			userRegistrationDetails.setLocation(userEntity.getLocation());
		}
		return userRegistrationDetails;
	}

	public UserCryptoEntity convertToUserCryptoEntity(UserCryptoDetails userCryptoDetails) {
		UserCryptoEntity userCryptoEntity = new UserCryptoEntity();
		if (!ObjectUtils.isEmpty(userCryptoDetails)) {
			return new UserCryptoEntity(userCryptoDetails.getSalt(), userCryptoDetails.getCryptoAlgoName());
		}
		return userCryptoEntity;
	}

	public CommunicationTemplateDetails convertToCommunicationTemplateDetails(
			CommunicationTemplateMasterEntity entity) {
		if (!ObjectUtils.isEmpty(entity)) {
			return new CommunicationTemplateDetails(entity.getCommunicationTemplateId(),
					entity.getCommunicationTemplateType(), entity.getTemplateName(), entity.getSubjectLine(),
					entity.getTemplateBody(), entity.getIsActive());
		}
		return new CommunicationTemplateDetails();
	}

	public UserEmailVerificationEntity convertToUserEmailVerificationEntity(
			UserEmailVerification userEmailVerification) {
		if (!ObjectUtils.isEmpty(userEmailVerification)) {
			return new UserEmailVerificationEntity(userEmailVerification.getUserId(),
					userEmailVerification.getCommunicationTemplateId(), userEmailVerification.getStatusId(),
					userEmailVerification.getSentFrom(), userEmailVerification.getSentTo(),
					userEmailVerification.getVerificationCode(), userEmailVerification.getVerificationUrl(),
					userEmailVerification.getVerificationUrlExpiry(), userEmailVerification.getRetryCount(),
					userEmailVerification.getVerificationUrlSent());
		}
		return null;
	}

	public UserEmailVerification convertToUserEmailVerification(UserEmailVerificationEntity entity) {
		if (!ObjectUtils.isEmpty(entity)) {
			return new UserEmailVerification(entity.getUserId(), entity.getSentFrom(), entity.getSentTo(),
					entity.getVerificationUrl());
		}
		return null;
	}

	public List<UserDto> convertToUsersList(List<UserEntity> userEntities) {
		List<UserDto> usersList = new ArrayList<>();
		if (!ObjectUtils.isEmpty(userEntities)) {
			usersList = userEntities.stream()
					.map(userEntity -> new UserDto(userEntity.getUserId(), userEntity.getUserName(),
							userEntity.getFirstName(), userEntity.getLastName(), userEntity.getEmail(),
							roleRepository.getRoleNameByRoleId(userEntity.getRoleId()), userEntity.getContactNumber(),
							userEntity.getIsActive(), userEntity.getLocation(),userEntity.isFirstTimeLogin()))
					.collect(Collectors.toList());
		}
		return usersList;
	}

	public List<Roles> convertToRolesList(List<RoleEntity> roleEntities) {
		List<Roles> rolesList = new ArrayList<>();
		if (!ObjectUtils.isEmpty(roleEntities)) {
			rolesList = roleEntities.stream()
					.map(role -> new Roles(role.getRoleId(), role.getRoleName(), role.getIsActive()))
					.collect(Collectors.toList());
		}
		return rolesList;
	}

	public CustomersEntity convertToCustomerEntity(CustomerDto customerDto) {
		return new CustomersEntity(customerDto.getCustomerName(), customerDto.getUserId(), customerDto.getLocation(),
				customerDto.getSpocFirstName(), customerDto.getSpocLastName(), customerDto.getEmailId(),
				UserConstants.ACTIVE_STATUS, customerDto.getContactNumber());

	}

	public CustomerDto convertToCustomerDto(CustomersEntity responseEntity) {
		return new CustomerDto(responseEntity.getCustomerId(), responseEntity.getCustomerName(),
				responseEntity.getUserId(), responseEntity.getLocation(), responseEntity.getSpocFirstName(),
				responseEntity.getSpocLastName(), responseEntity.getEmailId(), responseEntity.getContactNumber(),
				responseEntity.getIsActive());
	}

	public ProjectsEntity convertToProjectEntity(ProjectsDto project, CustomerDto customerDto) {
		return new ProjectsEntity(customerDto.getCustomerId(), Long.valueOf(StatusEnum.NEW.getValue()),
				project.getProjectName(), project.getDescription(), project.getStartDate(), project.getEndDate(),
				project.getDuration());
	}

	public ProjectsDto convertToProjectsDto(ProjectsEntity respEntity) throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		JsonNode driverObj = null;
		JsonNode scopeObj = null;
		JsonNode activityPlansObj = null;
		JsonNode resourcePlansObj = null;
		try {
			if (respEntity.getDrivers() != null) {
				driverObj = mapper.readTree(respEntity.getDrivers());
			}
			if (respEntity.getScope() != null) {
				scopeObj = mapper.readTree(respEntity.getScope());
			}

			if (respEntity.getActivityPlans() != null) {
				activityPlansObj = mapper.readTree(respEntity.getActivityPlans());
			}
			if (respEntity.getResourcePlans() != null) {
				resourcePlansObj = mapper.readTree(respEntity.getResourcePlans());
			}

			return new ProjectsDto(respEntity.getProjectId(), respEntity.getCustomerId(), respEntity.getStatusId(),
					respEntity.getProjectName(), respEntity.getDescription(), null, respEntity.getStartDate(),
					respEntity.getEndDate(), respEntity.getDuration(), driverObj, scopeObj, activityPlansObj,
					convertToProjectTeamsDtoList(respEntity.getProjectTeamEntities()), resourcePlansObj);
		} catch (JsonMappingException e) {
			System.out.println("---------------------------------------------");
		}
		return new ProjectsDto();
	}

	public ProjectTeamEntity convertToProjectTeamEntity(TeamOnboarding onboardingRequest, Long projectId) {
		List<TeamMemberEntity> teamMemberList = new ArrayList<>();
		teamMemberList.add(new TeamMemberEntity());
		ProjectTeamEntity toSave = new ProjectTeamEntity();
		toSave.setProjectsEntity(new ProjectsEntity(projectId));
		toSave.addTeamMember(new TeamMemberEntity(onboardingRequest.getTeamMembers().get(0).getMemberName(),
				onboardingRequest.getTeamMembers().get(0).getUserId(),
				Long.valueOf(RoleConstantsEnum.TEAM_MEMBER.getValue()),
				onboardingRequest.getTeamMembers().get(0).getEmail()));

		return toSave;
	}

	public ProjectTeamEntity convertToProjectTeamEntityWithOnboardingId(TeamOnboarding onboardingRequest,
			Long projectId, Long onboardingId) {
		List<TeamMemberEntity> teamMemberList = new ArrayList<>();
		teamMemberList.add(new TeamMemberEntity());
		ProjectTeamEntity toSaveEntity = new ProjectTeamEntity();
		toSaveEntity.setOnboardingId(onboardingId);
		toSaveEntity.setProjectsEntity(new ProjectsEntity(projectId));
		toSaveEntity.addTeamMember(new TeamMemberEntity(onboardingRequest.getTeamMembers().get(0).getMemberName(),
				onboardingRequest.getTeamMembers().get(0).getUserId(),
				Long.valueOf(RoleConstantsEnum.TEAM_MEMBER.getValue()),
				onboardingRequest.getTeamMembers().get(0).getEmail()));
		return toSaveEntity;
	}

	public TeamOnboarding convertToProjectTeamDto(ProjectTeamEntity responseEnity, List<TeamMember> teamMemberList) {
		if (!ObjectUtils.isEmpty(responseEnity)) {
			return new TeamOnboarding(responseEnity.getOnboardingId(), responseEnity.getProjectsEntity().getProjectId(),
					teamMemberList);
		}
		return null;
	}

	public ActivityPlanEntity convertToActivityPlanEntity(ActivityPlan activityPlan, Long projectId) {
		ActivityPlanEntity saveEntity = new ActivityPlanEntity();
		if (!ObjectUtils.isEmpty(activityPlan)) {
			saveEntity.setProjectEntity(new ProjectsEntity(projectId));
			saveEntity.setActivities(activityPlan.getActivities());
			saveEntity.setWeek(activityPlan.getWeek());
		}
		return saveEntity;
	}

	public ActivityPlan convertToActivityPlanDto(ActivityPlanEntity entity) {
		if (!ObjectUtils.isEmpty(entity)) {
			return new ActivityPlan(entity.getActivityId(), entity.getProjectEntity().getProjectId(),
					entity.getActivities(), entity.getWeek());
		} else
			return null;
	}

	public ResourceOnboardingEntity convertToResourcePlanEntity(ResourceOnboardingPlan resourcePlan, Long projectId) {
		ResourceOnboardingEntity saveEntity = new ResourceOnboardingEntity();
		if (!ObjectUtils.isEmpty(resourcePlan)) {
			saveEntity.setProjectEntity(new ProjectsEntity(projectId));
			saveEntity.setResourceName(resourcePlan.getResourceName());
			saveEntity.setNumberOfResources(resourcePlan.getNumberOfResources());
			saveEntity.setWeek(resourcePlan.getWeek());
		}
		return saveEntity;
	}

	public ResourceOnboardingPlan convertToResourceOnboardingPlan(ResourceOnboardingEntity entity) {
		if (!ObjectUtils.isEmpty(entity)) {
			return new ResourceOnboardingPlan(entity.getResourceId(), entity.getProjectEntity().getProjectId(),
					entity.getResourceName(), entity.getNumberOfResources(), entity.getWeek());
		} else
			return null;
	}

	private List<ActivityPlan> convertToActivityPlanList(List<ActivityPlanEntity> activityPlanEntities) {
		List<ActivityPlan> activityPlanDtos = new ArrayList<>();
		if (!ObjectUtils.isEmpty(activityPlanEntities)) {
			for (ActivityPlanEntity entity : activityPlanEntities) {
				activityPlanDtos.add(new ActivityPlan(entity.getActivityId(), entity.getProjectEntity().getProjectId(),
						entity.getActivities(), entity.getWeek()));
			}
		}
		return activityPlanDtos;
	}

	private List<ResourceOnboardingPlan> convertToResourcePlanList(
			List<ResourceOnboardingEntity> resourcePlanEntities) {
		List<ResourceOnboardingPlan> resourcePlanDtos = new ArrayList<>();
		if (!ObjectUtils.isEmpty(resourcePlanEntities)) {
			for (ResourceOnboardingEntity entity : resourcePlanEntities) {
				resourcePlanDtos.add(
						new ResourceOnboardingPlan(entity.getResourceId(), entity.getProjectEntity().getProjectId(),
								entity.getResourceName(), entity.getNumberOfResources(), entity.getWeek()));
			}
		}
		return resourcePlanDtos;
	}

	private List<Notifications> convertToNotificationsDtoList(List<NotificationsEntity> notificationsEntities) {
		List<Notifications> notificationsDtoList = new ArrayList<>();
		Notifications notificationsDto = null;
		if (!ObjectUtils.isEmpty(notificationsEntities)) {
			for (NotificationsEntity entity : notificationsEntities) {
				notificationsDto = ObjectMapperUtils.map(entity, Notifications.class);
				notificationsDto.setProjectId(entity.getProjectEntity().getProjectId());
				notificationsDtoList.add(notificationsDto);
			}
		}
		return notificationsDtoList;
	}

	private List<WorkflowMgmt> convertToWorkflowMgmtDtoList(List<WorkflowMgmtEntity> workflowMgmtEntities) {
		List<WorkflowMgmt> workflowMgmtDtoList = new ArrayList<>();
		WorkflowMgmt workflowMgmtDto = null;
		if (!ObjectUtils.isEmpty(workflowMgmtEntities)) {
			for (WorkflowMgmtEntity entity : workflowMgmtEntities) {
				workflowMgmtDto = ObjectMapperUtils.map(entity, WorkflowMgmt.class);
				workflowMgmtDto.setProjectId(entity.getProjectEntity().getProjectId());
				workflowMgmtDtoList.add(workflowMgmtDto);
			}
		}
		return workflowMgmtDtoList;
	}

	private List<ProjectTeam> convertToProjectTeamsDtoList(List<ProjectTeamEntity> projectTeamEntities) {
		List<ProjectTeam> projectTeamsDtoList = new ArrayList<>();
		ProjectTeam team = null;
		if (!ObjectUtils.isEmpty(projectTeamEntities)) {
			for (ProjectTeamEntity entity : projectTeamEntities) {
				team = ObjectMapperUtils.map(entity, ProjectTeam.class);
				team.setProjectId(entity.getProjectsEntity().getProjectId());
				projectTeamsDtoList.add(team);
			}
		}
		return projectTeamsDtoList;
	}

	public ApplicationOverview convertToApplicationOverviewCompleteDto(ApplicationOverviewEntity entity) {
		ApplicationOverview dto = new ApplicationOverview();

		if (!ObjectUtils.isEmpty(entity)) {
			dto.setApplicationId(entity.getApplicationId());
			dto.setApplicationName(entity.getApplicationName());
			dto.setBusinessCritical(entity.getBusinessCritical());
			dto.setBusinessUnit(entity.getBusinessUnit());
			dto.setContactFirstName(entity.getContactFirstName());
			dto.setContactLastName(entity.getContactLastName());
			dto.setContactNumber(entity.getContactNumber());
			dto.setDescription(entity.getDescription());
			dto.setEmail(entity.getEmail());
			dto.setProjectId(entity.getProjectEntity().getProjectId());
			dto.setResponseTime(entity.getResponseTime());
			dto.setHighAvailability(entity.getHighAvailability());
			dto.setNoOfInteractions(entity.getNoOfInteractions());
			dto.setApplicationLayerList(convertToApplicationLayerDetailsList(entity.getApplicationLayerEntities()));
			dto.setIntegrationLayerList(convertToIntegrationLayerDetailsList(entity.getIntegrationLayerEntities()));
			dto.setStorageList(convertToStorageDetailsList(entity.getStorageEntities()));
			dto.setServerDetailList(convertToServerDetailsList(entity.getServerDetailEntities()));
			dto.setSecurityComplianceList(convertToSecurityComplianceList(entity.getSecurityComplianceEntities()));
			dto.setRecommendationList(convertToRecommendationsList(entity.getRecommendationEntities()));
		}
		return dto;
	}

	public List<ApplicationLayerDetails> convertToApplicationLayerDetailsList(
			List<ApplicationLayerEntity> applicationLayerEntities) {
		List<ApplicationLayerDetails> dtoList = new ArrayList<>();
		if (!ObjectUtils.isEmpty(applicationLayerEntities)) {
			for (ApplicationLayerEntity entity : applicationLayerEntities) {
				dtoList.add(convertToApplicationLayerDetails(entity));
			}
		}
		return dtoList;
	}

	public List<IntegrationLayerDetails> convertToIntegrationLayerDetailsList(
			List<IntegrationLayerEntity> integrationLayerEntities) {
		List<IntegrationLayerDetails> dtoList = new ArrayList<>();
		if (!ObjectUtils.isEmpty(integrationLayerEntities)) {
			for (IntegrationLayerEntity entity : integrationLayerEntities) {
				dtoList.add(convertToIntegrationLayerDetails(entity));
			}
		}
		return dtoList;
	}

	public List<StorageDetails> convertToStorageDetailsList(List<StorageDetailsEntity> storageEntities) {
		List<StorageDetails> dtoList = new ArrayList<>();
		if (!ObjectUtils.isEmpty(storageEntities)) {
			for (StorageDetailsEntity entity : storageEntities) {
				dtoList.add(convertToStorageDetailsDto(entity));
			}
		}
		return dtoList;
	}

	public List<ServerDetails> convertToServerDetailsList(List<ServerDetailsEntity> serverDetailEntities) {
		List<ServerDetails> dtoList = new ArrayList<>();
		if (!ObjectUtils.isEmpty(serverDetailEntities)) {
			for (ServerDetailsEntity entity : serverDetailEntities) {
				dtoList.add(convertToServerDetailsDto(entity));
			}
		}
		return dtoList;
	}

	public List<SecurityCompliance> convertToSecurityComplianceList(
			List<SecurityComplianceEntity> securityComplianceEntities) {
		List<SecurityCompliance> dtoList = new ArrayList<>();
		if (!ObjectUtils.isEmpty(securityComplianceEntities)) {
			for (SecurityComplianceEntity entity : securityComplianceEntities) {
				dtoList.add(convertToSecurityComplianceDto(entity));
			}
		}
		return dtoList;
	}

	public List<Recommendations> convertToRecommendationsList(List<RecommendationsEntity> recommendationEntities) {
		List<Recommendations> dtoList = new ArrayList<>();
		if (!ObjectUtils.isEmpty(recommendationEntities)) {
			for (RecommendationsEntity entity : recommendationEntities) {
				dtoList.add(convertToRecommendationsDto(entity));
			}
		}
		return dtoList;
	}

	private List<ApplicationOverview> convertToApplicationOverviewList(
			List<ApplicationOverviewEntity> applicationOverviewEntities) {
		List<ApplicationOverview> applicationsList = new ArrayList<>();
		List<ApplicationLayerDetails> applicationLayerDetailsList = new ArrayList<>();
		List<IntegrationLayerDetails> integrationLayerDetailsList = new ArrayList<>();
		List<ServerDetails> serverDetailsList = new ArrayList<>();
		List<SecurityCompliance> securityCompliancesList = new ArrayList<>();
		List<Recommendations> recommendationsList = new ArrayList<>();
		List<StorageDetails> storageDetailsList = new ArrayList<>();
		ApplicationOverview applicationOverview = new ApplicationOverview();
		if (!ObjectUtils.isEmpty(applicationOverviewEntities)) {
			for (ApplicationOverviewEntity entity : applicationOverviewEntities) {
				applicationOverview = ObjectMapperUtils.map(entity, ApplicationOverview.class);
				applicationOverview.setProjectId(entity.getProjectEntity().getProjectId());

				applicationLayerDetailsList = convertToApplicationLayerDetailsList(
						entity.getApplicationLayerEntities());
				integrationLayerDetailsList = convertToIntegrationLayerDetailsList(
						entity.getIntegrationLayerEntities());
				serverDetailsList = convertToServerDetailsList(entity.getServerDetailEntities());
				securityCompliancesList = convertToSecurityComplianceList(entity.getSecurityComplianceEntities());
				recommendationsList = convertToRecommendationsList(entity.getRecommendationEntities());
				storageDetailsList = convertToStorageDetailsList(entity.getStorageEntities());

				applicationOverview.setApplicationLayerList(applicationLayerDetailsList);
				applicationOverview.setIntegrationLayerList(integrationLayerDetailsList);
				applicationOverview.setStorageList(storageDetailsList);
				applicationOverview.setRecommendationList(recommendationsList);
				applicationOverview.setSecurityComplianceList(securityCompliancesList);
				applicationOverview.setServerDetailList(serverDetailsList);
				applicationsList.add(applicationOverview);

				// applicationsList.add(convertToApplicationOverview(entity));
			}
		}
		return applicationsList;
	}

	public ProjectsDto convertToCompleteProjectsDto(ProjectsEntity entity) {
		ProjectsDto projectDto = new ProjectsDto();
		ObjectMapper mapper = new ObjectMapper();
		if (!ObjectUtils.isEmpty(entity)) {
			projectDto.setProjectId(entity.getProjectId());
			projectDto.setCustomerId(entity.getCustomerId());
			projectDto.setProjectName(entity.getProjectName());
			projectDto.setDescription(entity.getDescription());
			projectDto.setStartDate(entity.getStartDate());
			projectDto.setEndDate(entity.getEndDate());
			projectDto.setDuration(entity.getDuration());
			projectDto.setStatusId(entity.getStatusId());
			try {
				if (!ObjectUtils.isEmpty(entity.getDrivers())) {
					projectDto.setDrivers(mapper.readTree(entity.getDrivers()));
				}
				if (!ObjectUtils.isEmpty(entity.getScope())) {
					projectDto.setScope(mapper.readTree(entity.getScope()));
				}
				if (!ObjectUtils.isEmpty(entity.getActivityPlans())) {
					projectDto.setActivityPlanList(mapper.readTree(entity.getActivityPlans()));
				}
				if (!ObjectUtils.isEmpty(entity.getResourcePlans())) {
					projectDto.setResourceLoadingList(mapper.readTree(entity.getResourcePlans()));
				}
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			projectDto.setNotificationsList(convertToNotificationsDtoList(entity.getNotificationEntities()));
			projectDto.setWorkflowMgmtList(convertToWorkflowMgmtDtoList(entity.getWorkflowMgmtEntities()));
			projectDto.setProjectTeam(convertToProjectTeamsDtoList(entity.getProjectTeamEntities()));
			projectDto.setApplicationOverviewList(
					convertToApplicationOverviewList(entity.getApplicationOverviewEntities()));
		}
		return projectDto;
	}

	public ProjectTeam getProjectTeam(ProjectsEntity entity) {
		ProjectTeam team = new ProjectTeam();
		List<TeamMember> teamMembersList = new ArrayList<>();
		if (!ObjectUtils.isEmpty(entity.getProjectTeamEntities())) {
			teamMembersList = getTeamMembersList(entity.getProjectTeamEntities().get(0).getTeamMembersList());
		}
		List<ProjectTeamEntity> projectTeamEntities = new ArrayList<>();
		projectTeamEntities = entity.getProjectTeamEntities();
		for (ProjectTeamEntity projectTeamEntity : projectTeamEntities) {
			team.setOnboardingId(projectTeamEntity.getOnboardingId());
			team.setProjectId(projectTeamEntity.getProjectsEntity().getProjectId());
			team.setTeamMembersList(teamMembersList);
		}

		return team;
	}

	public List<TeamMember> getTeamMembersList(List<TeamMemberEntity> teamMemberEntities) {
		List<TeamMember> teamMembersList = new ArrayList<>();
		for (TeamMemberEntity entity : teamMemberEntities) {
			teamMembersList.add(new TeamMember(entity.getTeamMemberId(), entity.getMemberName(), entity.getUserId(),
					entity.getRoleId(), entity.getEmail()));
		}
		return teamMembersList;
	}

	public List<CustomerDto> convertToCustomerDtoList(Iterable<CustomersEntity> customersList) {
		List<CustomerDto> customerDtoList = new ArrayList<>();
		List<CustomersEntity> customerEntityList = new ArrayList<>();
		if (!ObjectUtils.isEmpty(customersList)) {
			customersList.forEach(customerEntityList::add);
			if (!ObjectUtils.isEmpty(customerEntityList)) {
				customerDtoList = ObjectMapperUtils.mapAll(customerEntityList, CustomerDto.class);
			}
		}
		return customerDtoList;
	}

	public List<ProjectsDto> convertToListOfProjectsDto(Iterable<ProjectsEntity> listOfProjectsEntities) {
		List<ProjectsDto> projectsDtoList = new ArrayList<>();
		List<ProjectsEntity> projectsEntityList = new ArrayList<>();
		if (!ObjectUtils.isEmpty(listOfProjectsEntities)) {
			listOfProjectsEntities.forEach(projectsEntityList::add);
			if (!ObjectUtils.isEmpty(projectsEntityList)) {
				for (ProjectsEntity entity : projectsEntityList) {
					projectsDtoList.add(convertToCompleteProjectsDto(entity));
				}
			}
		}
		return projectsDtoList;
	}

	public ApplicationOverviewEntity convertToApplicationOverviewEntity(ApplicationOverview applicationOverview) {
		ApplicationOverviewEntity entity = null;
		if (!ObjectUtils.isEmpty(applicationOverview)) {
			entity = ObjectMapperUtils.map(applicationOverview, ApplicationOverviewEntity.class);
		}
		return entity;
	}

	public ApplicationOverview convertToApplicationOverview(ApplicationOverviewEntity responseEntity) {
		ApplicationOverview applicationOverview = null;
		if (!ObjectUtils.isEmpty(responseEntity)) {
			applicationOverview = ObjectMapperUtils.map(responseEntity, ApplicationOverview.class);
			applicationOverview.setProjectId(responseEntity.getProjectEntity().getProjectId());
		}
		return applicationOverview;
	}

	public IntegrationLayerEntity convertToIntegrationLayerDetailsEntity(
			IntegrationLayerDetails integrationLayerDetails) {
		IntegrationLayerEntity entity = null;
		if (!ObjectUtils.isEmpty(integrationLayerDetails)) {
			entity = ObjectMapperUtils.map(integrationLayerDetails, IntegrationLayerEntity.class);
		}
		return entity;
	}

	public IntegrationLayerDetails convertToIntegrationLayerDetails(IntegrationLayerEntity integrationLayerEntity) {
		IntegrationLayerDetails integrationLayerDetails = null;
		if (!ObjectUtils.isEmpty(integrationLayerEntity)) {
			integrationLayerDetails = ObjectMapperUtils.map(integrationLayerEntity, IntegrationLayerDetails.class);
			integrationLayerDetails
					.setApplicationId(integrationLayerEntity.getApplicationOverviewEntity().getApplicationId());
		}
		return integrationLayerDetails;
	}

	public ApplicationLayerEntity convertToApplicationLayerEntity(ApplicationLayerDetails applicationLayerDetails) {
		ApplicationLayerEntity entity = null;
		if (!ObjectUtils.isEmpty(applicationLayerDetails)) {
			entity = ObjectMapperUtils.map(applicationLayerDetails, ApplicationLayerEntity.class);
		}
		return entity;
	}

	public ApplicationLayerDetails convertToApplicationLayerDetails(ApplicationLayerEntity applicationLayerEntity) {
		ApplicationLayerDetails applicationLayerDetails = null;
		if (!ObjectUtils.isEmpty(applicationLayerEntity)) {
			applicationLayerDetails = ObjectMapperUtils.map(applicationLayerEntity, ApplicationLayerDetails.class);
			applicationLayerDetails
					.setApplicationId(applicationLayerEntity.getApplicationOverviewEntity().getApplicationId());
		}
		return applicationLayerDetails;
	}

	public StorageDetailsEntity convertToStorageDetailsEntity(StorageDetails storageDetails) {
		StorageDetailsEntity entity = null;
		if (!ObjectUtils.isEmpty(storageDetails)) {
			entity = ObjectMapperUtils.map(storageDetails, StorageDetailsEntity.class);
		}
		return entity;
	}

	public StorageDetails convertToStorageDetailsDto(StorageDetailsEntity entity) {
		StorageDetails responDetailsDto = null;
		if (!ObjectUtils.isEmpty(entity)) {
			responDetailsDto = ObjectMapperUtils.map(entity, StorageDetails.class);
			responDetailsDto.setApplicationId(entity.getApplicationOverviewEntity().getApplicationId());
		}
		return responDetailsDto;
	}

	public SecurityComplianceEntity convertToSecurityComplianceEntity(SecurityCompliance securityCompliance,
			Long applicationId) {
		SecurityComplianceEntity entity = null;
		if (!ObjectUtils.isEmpty(securityCompliance)) {
			entity = ObjectMapperUtils.map(securityCompliance, SecurityComplianceEntity.class);
		}
		return entity;
	}

	public SecurityCompliance convertToSecurityComplianceDto(SecurityComplianceEntity entity) {
		SecurityCompliance responseDto = null;
		if (!ObjectUtils.isEmpty(entity)) {
			responseDto = ObjectMapperUtils.map(entity, SecurityCompliance.class);
			responseDto.setApplicationId(entity.getApplicationOverviewEntity().getApplicationId());
		}
		return responseDto;
	}

	public ServerDetailsEntity convertToServerDetailsEntity(ServerDetails serverDetails) {
		ServerDetailsEntity entity = null;
		if (!ObjectUtils.isEmpty(serverDetails)) {
			entity = ObjectMapperUtils.map(serverDetails, ServerDetailsEntity.class);
		}
		return entity;
	}

	public ServerDetails convertToServerDetailsDto(ServerDetailsEntity entity) {
		ServerDetails responseDto = null;
		if (!ObjectUtils.isEmpty(entity)) {
			responseDto = ObjectMapperUtils.map(entity, ServerDetails.class);
			responseDto.setApplicationId(entity.getApplicationOverviewEntity().getApplicationId());
		}
		return responseDto;
	}

	public RecommendationsEntity convertToRecommendationsEntity(Recommendations recommendations) {
		RecommendationsEntity entity = null;
		if (!ObjectUtils.isEmpty(recommendations)) {
			entity = ObjectMapperUtils.map(recommendations, RecommendationsEntity.class);
		}
		return entity;
	}

	public Recommendations convertToRecommendationsDto(RecommendationsEntity entity) {
		Recommendations responseDto = null;
		if (!ObjectUtils.isEmpty(entity)) {
			responseDto = ObjectMapperUtils.map(entity, Recommendations.class);
			responseDto.setApplicationId(entity.getApplicationEntity().getApplicationId());
		}
		return responseDto;
	}

	public NotificationsEntity convertToNotificationsEntity(Notifications notifications) {
		NotificationsEntity responseEntity = null;
		if (!ObjectUtils.isEmpty(notifications)) {
			responseEntity = ObjectMapperUtils.map(notifications, NotificationsEntity.class);
		}
		return responseEntity;
	}

	public Notifications convertToNotificationsDto(NotificationsEntity entity) {
		Notifications responseDto = null;
		if (!ObjectUtils.isEmpty(entity)) {
			responseDto = ObjectMapperUtils.map(entity, Notifications.class);
			responseDto.setProjectId(entity.getProjectEntity().getProjectId());
		}
		return responseDto;
	}

	public WorkflowMgmtEntity convertToWorkflowMgmtEntity(WorkflowMgmt workflowMgmt) {
		WorkflowMgmtEntity responseEntity = null;
		if (!ObjectUtils.isEmpty(workflowMgmt)) {
			responseEntity = ObjectMapperUtils.map(workflowMgmt, WorkflowMgmtEntity.class);
		}
		return responseEntity;
	}

	public WorkflowMgmt convertToWorkflowMgmtDto(WorkflowMgmtEntity entity) {
		WorkflowMgmt responseDto = null;
		if (!ObjectUtils.isEmpty(entity)) {
			responseDto = ObjectMapperUtils.map(entity, WorkflowMgmt.class);
			responseDto.setProjectId(entity.getProjectEntity().getProjectId());
		}
		return responseDto;
	}

	public CustomersEntity updateCustomerDetails(CustomerDto request, CustomersEntity entity) {
		entity.setContactNumber(request.getContactNumber());
		entity.setEmailId(request.getEmailId());
		entity.setLocation(request.getLocation());
		return entity;
	}

	/*
	 * public List<ApplicationLayerDetails>
	 * getApplicationLayerDtoList(List<ApplicationLayerEntity>
	 * applicationLayerEntities){ List<ApplicationLayerDetails>
	 * applicationLayerDtoList = new ArrayList<>();
	 * if(!ObjectUtils.isEmpty(applicationLayerEntities)) {
	 * for(ApplicationLayerEntity entity:applicationLayerEntities) {
	 * applicationLayerDtoList.add()); } } }
	 */

	/*
	 * public List<ApplicationOverview>
	 * convertToApplicationOverviewList(ProjectsEntity entity){ ProjectsDto
	 * dto=null; if(!ObjectUtils.isEmpty(entity)) {
	 * dto=ObjectMapperUtils.map(entity, ProjectsDto.class);
	 * dto.setActivityPlanList(convertToActivityPlanList(entity.
	 * getActivityPlanEntities()));
	 * dto.setResourceLoadingList(convertToResourcePlanList(entity.
	 * getResourceOnboardingEntities())); dto.setCustomerId(entity.getCustomerId());
	 * dto.setDescription(entity.getDescription()); dto.setDrivers(null);
	 * dto.setEndDate(entity.getEndDate());
	 * dto.setNotificationsList(convertToNotificationsDtoList(entity.
	 * getNotificationEntities())); dto.setProjectId(entity.getProjectId());
	 * dto.setProjectName(entity.getProjectName()); dto.setProjectTeam(null);
	 * dto.setProjectTeamList(convertToProjectTeamsDtoList(entity.
	 * getProjectTeamEntities())); dto.setScope(null);
	 * dto.setDuration(entity.getDuration());
	 * dto.setStartDate(entity.getStartDate());
	 * dto.setStatusId(entity.getStatusId());
	 * dto.setWorkflowMgmtList(convertToWorkflowMgmtDtoList(entity.
	 * getWorkflowMgmtEntities())); //dto.setApplicationOverviewList(); } return
	 * dto; }
	 */

	public JsonNode convertToActivityPlanJson(String activityPlans) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode activityPlansObj = null;
		try {
			if (activityPlans != null) {
				activityPlansObj = mapper.readTree(activityPlans);
			}
		} catch (JsonMappingException jme) {
			jme.printStackTrace();
		}
		return activityPlansObj;
	}

	public JsonNode convertToResourcePlanJson(String resourcePlans) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode resourcePlansObj = null;
		try {
			if (resourcePlans != null) {
				resourcePlansObj = mapper.readTree(resourcePlans);
			}
		} catch (JsonMappingException jme) {
			jme.printStackTrace();
		}
		return resourcePlansObj;
	}
}
