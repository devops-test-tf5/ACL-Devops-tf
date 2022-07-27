package com.acldigital.unaito.service.service;

import java.util.List;

import com.acldigital.unaito.service.project.dto.ApplicationOverview;
import com.acldigital.unaito.service.project.dto.TeamOnboarding;
import com.acldigital.unaito.service.user.dto.ApplicationLayerDetails;
import com.acldigital.unaito.service.user.dto.IntegrationLayerDetails;
import com.acldigital.unaito.service.user.dto.Notifications;
import com.acldigital.unaito.service.user.dto.ProjectTeam;
import com.acldigital.unaito.service.user.dto.ProjectsDto;
import com.acldigital.unaito.service.user.dto.SecurityCompliance;
import com.acldigital.unaito.service.user.dto.ServerDetails;
import com.acldigital.unaito.service.user.dto.StorageDetails;
import com.acldigital.unaito.service.user.dto.WorkflowMgmt;
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

	public ProjectsDto addActivityPlan(String apiKey, String token, JsonNode activityPlan, Long projectId)
			throws JsonProcessingException;

	public ProjectsDto addResourcePlan(String apiKey, String token, JsonNode resourcePlan, Long projectId)
			throws JsonProcessingException;

	public ProjectsDto fetchProjectDetails(String apiKey, String token, Long projectId);

	public List<ProjectsDto> fetchAllProjectDetails(String apiKey, String token);

	public ApplicationOverview addApplicationOverviewDetails(String apiKey, String token,
			ApplicationOverview applicationOverview, Long projectId);

	public IntegrationLayerDetails addIntegrationLayerDetails(String apiKey, String token,
			IntegrationLayerDetails integrationLayerDetails, Long applicationId);

	public ApplicationLayerDetails addIntegrationLayerDetails(String apiKey, String token,
			ApplicationLayerDetails applicationLayerDetails, Long applicationId);

	public StorageDetails addStorageDetails(String apiKey, String token, StorageDetails storageDetails,
			Long applicationId);

	public SecurityCompliance addSecurityComplianceDetails(String apiKey, String token,
			SecurityCompliance securityCompliance, Long applicationId);

	public ServerDetails addServerDetails(String apiKey, String token, ServerDetails serverDetails, Long applicationId);

	public Notifications addNotifications(String apiKey, String token, Notifications notifications, Long projectId);

	public WorkflowMgmt addWorkflow(String apiKey, String token, WorkflowMgmt workflowMgmt, Long projectId);
	
	public ProjectTeam getAllProjectTeamMembers(String apiKey,String  token,Long projectId);

	// public List<ApplicationOverview> getAllApplicationsByProjectId(String apiKey,
	// String token, Long projectId);
}
