package com.acldigital.unaito.db;

import com.acldigital.unaito.service.customer.CustomerDto;
import com.acldigital.unaito.service.project.dto.TeamOnboarding;
import com.acldigital.unaito.service.user.dto.ActivityPlan;
import com.acldigital.unaito.service.user.dto.ProjectsDto;
import com.acldigital.unaito.service.user.dto.ResourceOnboardingPlan;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public interface IProjectsDataService {

	public ProjectsDto createNewProject(ProjectsDto project, CustomerDto customerDto) throws JsonProcessingException;

	public TeamOnboarding saveTeamOnboardingInfos(TeamOnboarding onboardingRequest, Long projectId);

	public ProjectsDto saveDriversInfos(JsonNode driverRequest, Long projectId) throws JsonProcessingException;

	public ProjectsDto saveScopeInfos(JsonNode scopeRequest, Long projectId) throws JsonProcessingException;

	public ActivityPlan addActivityPlan(ActivityPlan activityPlan, Long projectId);

	public ResourceOnboardingPlan addResourcePlan(ResourceOnboardingPlan resourcePlan, Long projectId);

	public ProjectsDto fetchProjectDetails(Long projectId);
}
