package com.acldigital.unaito.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.acldigital.unaito.db.IApplicationsDataService;
import com.acldigital.unaito.db.ICustomerDataService;
import com.acldigital.unaito.db.IProjectsDataService;
import com.acldigital.unaito.service.customer.CustomerDto;
import com.acldigital.unaito.service.project.dto.ApplicationOverview;
import com.acldigital.unaito.service.project.dto.TeamOnboarding;
import com.acldigital.unaito.service.service.IProjectService;
import com.acldigital.unaito.service.user.dto.ApplicationLayerDetails;
import com.acldigital.unaito.service.user.dto.IntegrationLayerDetails;
import com.acldigital.unaito.service.user.dto.Notifications;
import com.acldigital.unaito.service.user.dto.ProjectTeam;
import com.acldigital.unaito.service.user.dto.ProjectsDto;
import com.acldigital.unaito.service.user.dto.SecurityCompliance;
import com.acldigital.unaito.service.user.dto.ServerDetails;
import com.acldigital.unaito.service.user.dto.StorageDetails;
import com.acldigital.unaito.service.user.dto.WorkflowMgmt;
import com.acldigital.unaito.service.user.exception.InvalidJwtTokenException;
import com.acldigital.unaito.service.utils.CommonUtils;
import com.acldigital.unaito.service.utils.SecurityUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	private SecurityUtils securityUtils;

	@Autowired
	private IProjectsDataService projectsDataService;

	@Autowired
	private ICustomerDataService customerDataService;

	@Autowired
	private CommonUtils commonUtils;

	@Autowired
	private IApplicationsDataService applicationsDataService;

	/**
	 * Create new project.
	 */
	@Override
	public ProjectsDto createNewProject(String apiKey, String jwtToken, ProjectsDto newProject)
			throws JsonProcessingException {
		ProjectsDto respProject = null;
		securityUtils.validateProjectApiKey(apiKey);
		// validate the token
		boolean isTokenValid = commonUtils.validateToken(jwtToken);
		if (isTokenValid) {
			CustomerDto customerDto = customerDataService.getCustomerDetails(newProject.getCustomerName());
			if (!ObjectUtils.isEmpty(customerDto)) {
				respProject = projectsDataService.createNewProject(newProject, customerDto);
			}
			CustomerDto custDto = customerDataService.getCustomerDetails(respProject.getCustomerId());
			if (!ObjectUtils.isEmpty(custDto)) {
				respProject.setCustomerName(custDto.getCustomerName());
			}
		}

		return respProject;
	}

	@Override
	public TeamOnboarding addTeamMember(String apiKey, String jwtToken, TeamOnboarding onboardingRequest,
			Long projectId) {
		securityUtils.validateProjectApiKey(apiKey);
		boolean isTokenValid = commonUtils.validateToken(jwtToken);
		if (isTokenValid) {
			return projectsDataService.saveTeamOnboardingInfos(onboardingRequest, projectId);
		} else {
			throw new InvalidJwtTokenException("invalid token", HttpStatus.FORBIDDEN.value());
		}
	}

	@Override
	public ProjectsDto addDrivers(String apiKey, String token, JsonNode driverRequest, Long projectId)
			throws JsonProcessingException {
		securityUtils.validateProjectApiKey(apiKey);
		// write some validations to check if the project id ,
		// customer id, user id are matching with jwt token details
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			return projectsDataService.saveDriversInfos(driverRequest, projectId);
		} else {
			throw new InvalidJwtTokenException("Invalid token.", org.springframework.http.HttpStatus.FORBIDDEN.value());
		}
	}

	@Override
	public ProjectsDto addScopes(String apiKey, String token, JsonNode scopeRequest, Long projectId)
			throws JsonProcessingException {
		securityUtils.validateProjectApiKey(apiKey);
		// write some validations to check if the project id ,
		// customer id, user id are matching with jwt token details
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			return projectsDataService.saveScopeInfos(scopeRequest, projectId);
		} else {
			throw new InvalidJwtTokenException("Invalid token.", org.springframework.http.HttpStatus.FORBIDDEN.value());
		}
	}

	@Override
	public ProjectsDto addActivityPlan(String apiKey, String token, JsonNode activityPlan, Long projectId)
			throws JsonProcessingException {
		securityUtils.validateProjectApiKey(apiKey);
		// write some validations to check if the project id ,
		// customer id, user id are matching with jwt token details
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			return projectsDataService.addActivityPlan(activityPlan, projectId);
		} else {
			throw new InvalidJwtTokenException("Invalid token.", org.springframework.http.HttpStatus.FORBIDDEN.value());
		}
	}

	@Override
	public ProjectsDto addResourcePlan(String apiKey, String token, JsonNode resourcePlan,
			Long projectId)throws JsonProcessingException {
		securityUtils.validateProjectApiKey(apiKey);
		// write some validations to check if the project id ,
		// customer id, user id are matching with jwt token details
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			return projectsDataService.addResourcePlan(resourcePlan, projectId);
		} else {
			throw new InvalidJwtTokenException("Invalid token.", org.springframework.http.HttpStatus.FORBIDDEN.value());
		}
	}

	@Override
	public Notifications addNotifications(String apiKey, String token, Notifications notifications, Long projectId) {
		securityUtils.validateProjectApiKey(apiKey);
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			return projectsDataService.addNotifications(notifications, projectId);
		} else {
			throw new InvalidJwtTokenException("Invalid token.", org.springframework.http.HttpStatus.FORBIDDEN.value());
		}
	}

	@Override
	public ProjectsDto fetchProjectDetails(String apiKey, String token, Long projectId) {
		securityUtils.validateProjectApiKey(apiKey);
		// write some validations to check if the project id ,
		// customer id, user id are matching with jwt token details
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			return projectsDataService.fetchProjectDetails(projectId);
		} else {
			throw new InvalidJwtTokenException("Invalid token.", org.springframework.http.HttpStatus.FORBIDDEN.value());
		}

	}

	@Override
	public List<ProjectsDto> fetchAllProjectDetails(String apiKey, String token) {
		securityUtils.validateProjectApiKey(apiKey);
		boolean isTokenValid = commonUtils.validateToken(token);
		List<ProjectsDto> projectsList = new ArrayList<>();
		if (isTokenValid) {
			projectsList = projectsDataService.fetchAllProjectDetails();
		} else {
			throw new InvalidJwtTokenException("Invalid token.", org.springframework.http.HttpStatus.FORBIDDEN.value());
		}
		return projectsList;
	}

	@Override
	public ApplicationOverview addApplicationOverviewDetails(String apiKey, String token,
			ApplicationOverview applicationOverview, Long projectId) {
		ApplicationOverview applicationOverviewResponse = null;
		securityUtils.validateProjectApiKey(apiKey);
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			applicationOverviewResponse = projectsDataService.addApplicationOverviewDetails(applicationOverview,
					projectId);
		}
		return applicationOverviewResponse;
	}

	@Override
	public IntegrationLayerDetails addIntegrationLayerDetails(String apiKey, String token,
			IntegrationLayerDetails integrationLayerDetails, Long applicationId) {
		IntegrationLayerDetails response = null;
		securityUtils.validateProjectApiKey(apiKey);
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			response = projectsDataService.addIngrationLayerDetails(integrationLayerDetails, applicationId);
		}
		return response;
	}

	@Override
	public ApplicationLayerDetails addIntegrationLayerDetails(String apiKey, String token,
			ApplicationLayerDetails applicationLayerDetails, Long applicationId) {
		ApplicationLayerDetails response = null;
		securityUtils.validateProjectApiKey(apiKey);
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			response = projectsDataService.addApplicationLayerDetails(applicationLayerDetails, applicationId);
		}
		return response;
	}

	@Override
	public StorageDetails addStorageDetails(String apiKey, String token, StorageDetails storageDetails,
			Long applicationId) {
		StorageDetails response = null;
		securityUtils.validateProjectApiKey(apiKey);
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			response = projectsDataService.addStorageDetails(storageDetails, applicationId);
		}
		return response;
	}

	@Override
	public SecurityCompliance addSecurityComplianceDetails(String apiKey, String token,
			SecurityCompliance securityCompliance, Long applicationId) {
		SecurityCompliance response = null;
		securityUtils.validateProjectApiKey(apiKey);
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			response = applicationsDataService.addSecurityComplianceDetails(securityCompliance, applicationId);
		}
		return response;
	}

	@Override
	public ServerDetails addServerDetails(String apiKey, String token, ServerDetails serverDetails,
			Long applicationId) {
		ServerDetails response = null;
		securityUtils.validateProjectApiKey(apiKey);
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			response = applicationsDataService.addServerDetails(serverDetails, applicationId);
		}
		return response;
	}

	@Override
	public WorkflowMgmt addWorkflow(String apiKey, String token, WorkflowMgmt workflowMgmt, Long projectId) {
		securityUtils.validateProjectApiKey(apiKey);
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			return projectsDataService.createWorkflow(workflowMgmt, projectId);
		} else {
			throw new InvalidJwtTokenException("Invalid token.", org.springframework.http.HttpStatus.FORBIDDEN.value());
		}
	}
	
	

	@Override
	public ProjectTeam getAllProjectTeamMembers(String apiKey, String token, Long projectId) {
		securityUtils.validateProjectApiKey(apiKey);
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
		
		}
		return null;
	}

	/*
	 * @Override public List<ApplicationOverview>
	 * getAllApplicationsByProjectId(String apiKey, String token, Long projectId) {
	 * securityUtils.validateProjectApiKey(apiKey); boolean isTokenValid =
	 * commonUtils.validateToken(token); if (isTokenValid) { return
	 * projectsDataService.getAllApplicationsByProjectId(projectId); } else { throw
	 * new InvalidJwtTokenException("Invalid token.",
	 * org.springframework.http.HttpStatus.FORBIDDEN.value()); } }
	 */

}
