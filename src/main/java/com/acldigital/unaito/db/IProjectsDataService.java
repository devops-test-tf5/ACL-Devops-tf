package com.acldigital.unaito.db;

import java.util.List;

import com.acldigital.unaito.service.customer.CustomerDto;
import com.acldigital.unaito.service.project.dto.ApplicationOverview;
import com.acldigital.unaito.service.project.dto.TeamOnboarding;
import com.acldigital.unaito.service.user.dto.ActivityPlan;
import com.acldigital.unaito.service.user.dto.ApplicationLayerDetails;
import com.acldigital.unaito.service.user.dto.IntegrationLayerDetails;
import com.acldigital.unaito.service.user.dto.Notifications;
import com.acldigital.unaito.service.user.dto.ProjectsDto;
import com.acldigital.unaito.service.user.dto.ResourceOnboardingPlan;
import com.acldigital.unaito.service.user.dto.StorageDetails;
import com.acldigital.unaito.service.user.dto.WorkflowMgmt;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public interface IProjectsDataService {

	public ProjectsDto createNewProject(ProjectsDto project, CustomerDto customerDto) throws JsonProcessingException;

	public TeamOnboarding saveTeamOnboardingInfos(TeamOnboarding onboardingRequest, Long projectId);

	public ProjectsDto saveDriversInfos(JsonNode driverRequest, Long projectId) throws JsonProcessingException;

	public ProjectsDto saveScopeInfos(JsonNode scopeRequest, Long projectId) throws JsonProcessingException;

	public ProjectsDto addActivityPlan(JsonNode activityPlan, Long projectId) throws JsonProcessingException;

	public ProjectsDto addResourcePlan(JsonNode resourcePlan, Long projectId) throws JsonProcessingException;

	public ProjectsDto fetchProjectDetails(Long projectId);

	public List<ProjectsDto> fetchAllProjectDetails();

	public ApplicationOverview addApplicationOverviewDetails(ApplicationOverview applicationOverview, Long projectId);

	public IntegrationLayerDetails addIngrationLayerDetails(IntegrationLayerDetails integrationLayerDetails,
			Long applicationId);

	public ApplicationLayerDetails addApplicationLayerDetails(ApplicationLayerDetails applicationLayerDetails,
			Long applicationId);

	public StorageDetails addStorageDetails(StorageDetails storageDetails, Long applicationId);

	public Notifications addNotifications(Notifications notifications, Long projectId);

	public WorkflowMgmt createWorkflow(WorkflowMgmt workflowMgmt, Long projectId);

	// public List<ApplicationOverview> getAllApplicationsByProjectId(Long
	// projectId);
}
