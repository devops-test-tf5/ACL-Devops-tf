package com.acldigital.unaito.service.service;

import com.acldigital.unaito.service.project.dto.TeamOnboarding;
import com.acldigital.unaito.service.user.dto.ActivityPlan;
import com.acldigital.unaito.service.user.dto.ProjectsDto;
import com.acldigital.unaito.service.user.dto.ResourceOnboardingPlan;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public interface IProjectService {

	public ProjectsDto createNewProject(String apiKey, String jwtToken, ProjectsDto newProject)
			throws JsonProcessingException;

	public TeamOnboarding addTeamMember(String apiKey, String jwtToken, TeamOnboarding onboardingRequest,
			Long projectId);

	public ProjectsDto addDrivers(String apiKey, String token, JsonNode driverRequest, Long projectId)
			throws JsonProcessingException;

	public ProjectsDto addScopes(String apiKey, String token, JsonNode scopeRequest, Long projectId)
			throws JsonProcessingException;

	public ActivityPlan addActivityPlan(String apiKey, String token, ActivityPlan activityPlan, Long projectId);

	public ResourceOnboardingPlan addResourcePlan(String apiKey, String token, ResourceOnboardingPlan resourcePlan,
			Long projectId);

	public ProjectsDto fetchProjectDetails(String apiKey, String token, Long projectId);
}
