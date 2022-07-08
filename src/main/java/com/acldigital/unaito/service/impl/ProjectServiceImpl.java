package com.acldigital.unaito.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.acldigital.unaito.db.ICustomerDataService;
import com.acldigital.unaito.db.IProjectsDataService;
import com.acldigital.unaito.service.customer.CustomerDto;
import com.acldigital.unaito.service.project.dto.TeamOnboarding;
import com.acldigital.unaito.service.service.IProjectService;
import com.acldigital.unaito.service.user.dto.ActivityPlan;
import com.acldigital.unaito.service.user.dto.ProjectsDto;
import com.acldigital.unaito.service.user.dto.ResourceOnboardingPlan;
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
	public ActivityPlan addActivityPlan(String apiKey, String token, ActivityPlan activityPlan, Long projectId) {
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
	public ResourceOnboardingPlan addResourcePlan(String apiKey, String token, ResourceOnboardingPlan resourcePlan,
			Long projectId) {
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

}
