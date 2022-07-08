package com.acldigital.unaito.db.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.acldigital.unaito.service.customer.CustomerDto;
import com.acldigital.unaito.service.entity.ActivityPlanEntity;
import com.acldigital.unaito.service.entity.CommunicationTemplateMasterEntity;
import com.acldigital.unaito.service.entity.CustomersEntity;
import com.acldigital.unaito.service.entity.ProjectTeamEntity;
import com.acldigital.unaito.service.entity.ProjectsEntity;
import com.acldigital.unaito.service.entity.ResourceOnboardingEntity;
import com.acldigital.unaito.service.entity.RoleEntity;
import com.acldigital.unaito.service.entity.TeamMemberEntity;
import com.acldigital.unaito.service.entity.UserCryptoEntity;
import com.acldigital.unaito.service.entity.UserEmailVerificationEntity;
import com.acldigital.unaito.service.entity.UserEntity;
import com.acldigital.unaito.service.entity.UserLoggedInEntity;
import com.acldigital.unaito.service.project.dto.TeamMember;
import com.acldigital.unaito.service.project.dto.TeamOnboarding;
import com.acldigital.unaito.service.repository.IRoleRepository;
import com.acldigital.unaito.service.security.constants.RoleConstantsEnum;
import com.acldigital.unaito.service.user.constants.StatusEnum;
import com.acldigital.unaito.service.user.constants.UserConstants;
import com.acldigital.unaito.service.user.dto.ActivityPlan;
import com.acldigital.unaito.service.user.dto.CommunicationTemplateDetails;
import com.acldigital.unaito.service.user.dto.ProjectTeam;
import com.acldigital.unaito.service.user.dto.ProjectsDto;
import com.acldigital.unaito.service.user.dto.ResourceOnboardingPlan;
import com.acldigital.unaito.service.user.dto.Roles;
import com.acldigital.unaito.service.user.dto.UserCryptoDetails;
import com.acldigital.unaito.service.user.dto.UserDto;
import com.acldigital.unaito.service.user.dto.UserEmailVerification;
import com.acldigital.unaito.service.user.dto.UserLoggedInDetails;
import com.acldigital.unaito.service.user.dto.UserRegistrationDetails;
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
				userEntity.getContactNumber(), UserConstants.ACTIVE_STATUS, userEntity.getLocation());
	}

	public UserDto convertToUserDto(UserEntity userEntity) {
		return new UserDto(userEntity.getUserId(), userEntity.getUserName(), userEntity.getPassword(),
				userEntity.getFirstName(), userEntity.getLastName(), userEntity.getEmail(), null,
				userEntity.getContactNumber(), UserConstants.ACTIVE_STATUS, userEntity.getLocation());
	}

	public UserLoggedInEntity convertToUserLoginDetailsEntity(UserLoggedInDetails userLoggedInDetails) {
		UserLoggedInEntity entity = null;
		if (!ObjectUtils.isEmpty(userLoggedInDetails)) {
			return new UserLoggedInEntity(userLoggedInDetails.getUserId(), userLoggedInDetails.getSessionId(),
					userLoggedInDetails.getJwtType(), null, userLoggedInDetails.getJwt(),
					userLoggedInDetails.getJwtCreatedTime(), userLoggedInDetails.getJwtExpiryTime(), UserConstants.YES,
					userLoggedInDetails.getLoggedInTime());
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
							userEntity.getIsActive(), userEntity.getLocation()))
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
		/*
		 * return new CustomersEntity(customerDto.getCustomerName(),
		 * customerDto.getUserId(), customerDto.getLocation(),
		 * customerDto.getSpocFirstName(), customerDto.getSpocLastName(),
		 * customerDto.getEmailId(), UserConstants.ACTIVE_STATUS,
		 * customerDto.getContactNumber());
		 */
		return null;
	}

	public CustomerDto convertToCustomerDto(CustomersEntity responseEntity) {
		/*
		 * return new CustomerDto(responseEntity.getCustomerId(),
		 * responseEntity.getCustomerName(), responseEntity.getLocation(),
		 * responseEntity.getSpocFirstName(), responseEntity.getSpocLastName(),
		 * responseEntity.getEmailId(), responseEntity.getContactNumber(),
		 * responseEntity.getUserId());
		 * 
		 */
		return null;
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
		try {
			if (respEntity.getDrivers() != null) {
				driverObj = mapper.readTree(respEntity.getDrivers().toString());
			}
			if (respEntity.getScope() != null) {
				scopeObj = mapper.readTree(respEntity.getScope().toString());
			}

			return new ProjectsDto(respEntity.getProjectId(), respEntity.getCustomerId(), respEntity.getProjectName(),
					null, respEntity.getDescription(), null, respEntity.getStartDate(), respEntity.getEndDate(),
					respEntity.getDuration(), respEntity.getStatusId(), driverObj, scopeObj, null, null, null, null,
					null);
		} catch (JsonMappingException e) {
			System.out.println("---------------------------------------------");
		}
		return null;
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
		}
		return saveEntity;
	}

	public ResourceOnboardingPlan convertToResourceOnboardingPlan(ResourceOnboardingEntity entity) {
		if (!ObjectUtils.isEmpty(entity)) {
			return new ResourceOnboardingPlan(entity.getResourceId(), entity.getProjectEntity().getProjectId(),
					entity.getResourceName(), entity.getNumberOfResources());
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
			projectDto.setProjectTeam(getProjectTeam(entity));
			try {
				projectDto.setDrivers(mapper.readTree(entity.getDrivers()));
				projectDto.setScope(mapper.readTree(entity.getScope()));
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			projectDto.setActivityPlanList(convertToActivityPlanList(entity.getActivityPlanEntities()));
		}
		return projectDto;
	}

	public ProjectTeam getProjectTeam(ProjectsEntity entity) {
		ProjectTeam team = new ProjectTeam();
		List<TeamMember> teamMembersList = new ArrayList<>();
		if(!ObjectUtils.isEmpty(entity.getProjectTeamEntities())) {
			teamMembersList = getTeamMembersList(entity.getProjectTeamEntities().get(0).getTeamMembersList());
		}
		List<ProjectTeamEntity> projectTeamEntities = new ArrayList<>();
		//System.out.println("project teamssss--->" + projectTeamEntities.get(0));
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
	
	
	public List<CustomerDto> convertToCustomerDtoList(Iterable<CustomersEntity> customersList){
		List<CustomerDto> customerDtoList = new ArrayList<>();
		List<CustomersEntity> customerEntityList=new ArrayList<>();
		if(!ObjectUtils.isEmpty(customersList)) {
			customersList.forEach(customerEntityList::add);
			if(!ObjectUtils.isEmpty(customerEntityList)) {
				customerDtoList=ObjectMapperUtils.mapAll(customerEntityList, CustomerDto.class);
			}
		}
		System.out.println("List of customer dtos... :: "+customerDtoList.toString());
		
		return null;
	}

}
