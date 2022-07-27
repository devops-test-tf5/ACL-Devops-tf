package com.acldigital.unaito.service.user.controller;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acldigital.unaito.service.project.dto.ActivityPlanResponse;
import com.acldigital.unaito.service.project.dto.ApplicationOverview;
import com.acldigital.unaito.service.project.dto.TeamOnboarding;
import com.acldigital.unaito.service.service.IApplicationService;
import com.acldigital.unaito.service.service.IProjectService;
import com.acldigital.unaito.service.user.dto.ApplicationLayerDetails;
import com.acldigital.unaito.service.user.dto.ApplicationLayerResponse;
import com.acldigital.unaito.service.user.dto.ApplicationOverViewResponse;
import com.acldigital.unaito.service.user.dto.CustomerResponse;
import com.acldigital.unaito.service.user.dto.IntegrationLayerDetails;
import com.acldigital.unaito.service.user.dto.IntegrationLayerResponse;
import com.acldigital.unaito.service.user.dto.Notifications;
import com.acldigital.unaito.service.user.dto.ProjectDtoResponse;
import com.acldigital.unaito.service.user.dto.ProjectTeam;
import com.acldigital.unaito.service.user.dto.ProjectsDto;
import com.acldigital.unaito.service.user.dto.Recommendations;
import com.acldigital.unaito.service.user.dto.ResourcePlanResponse;
import com.acldigital.unaito.service.user.dto.SecurityCompliance;
import com.acldigital.unaito.service.user.dto.ServerDetails;
import com.acldigital.unaito.service.user.dto.StorageDetails;
import com.acldigital.unaito.service.user.dto.TeamOnboardingResponse;
import com.acldigital.unaito.service.user.dto.WorkflowMgmt;
import com.acldigital.unaito.service.utils.CommonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/unaito/v1/projects")
public class ProjectController {

	Logger logger = Logger.getLogger(ProjectController.class);

	@Autowired
	private IProjectService projectService;

	@Autowired
	private IApplicationService applicationService;

	@PostMapping("/create")
	public ResponseEntity<Object> createProject(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken,
			@RequestBody @NotNull @NotBlank ProjectsDto newProjectRequest) throws JsonProcessingException {
		logger.info(String.format("BEGIN::/create POST %s", newProjectRequest.getProjectName()));
		ProjectsDto responseObject = null;
		String token = CommonUtils.resolveToken(jwtToken);
		if (!ObjectUtils.isEmpty(newProjectRequest)) {
			responseObject = projectService.createNewProject(apiKey, token, newProjectRequest);
		}
		logger.info(String.format("RETURN::/create POST %s", HttpStatus.CREATED.value()));
		return new ResponseEntity<>(new CustomerResponse(HttpStatus.CREATED.value(), responseObject),
				HttpStatus.CREATED);
	}

	@PostMapping("/{projectId}/add-drivers")
	public ResponseEntity<Object> addDrivers(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken, @RequestBody @NotNull @NotBlank JsonNode driverRequest,
			@PathVariable("projectId") Long projectId) throws JsonProcessingException {
		logger.info(String.format("BEGIN::/{projectId}/add-drivers POST %s", driverRequest.asText()));
		ProjectsDto responseObject = null;
		String token = CommonUtils.resolveToken(jwtToken);
		responseObject = projectService.addDrivers(apiKey, token, driverRequest, projectId);
		logger.info(String.format("RETURN::/{projectId}/add-drivers POST %s", HttpStatus.CREATED.value()));
		return new ResponseEntity<>(new CustomerResponse(HttpStatus.CREATED.value(), responseObject),
				HttpStatus.CREATED);
	}

	@PostMapping("/{projectId}/add-scope")
	public ResponseEntity<Object> addScope(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken, @RequestBody @NotNull @NotBlank JsonNode scopeRequest,
			@PathVariable("projectId") Long projectId) throws JsonProcessingException {
		ProjectsDto responseObject = null;
		logger.info(String.format("BEGIN::/{projectId}/add-scope POST %s", scopeRequest.asText()));
		String token = CommonUtils.resolveToken(jwtToken);
		responseObject = projectService.addScopes(apiKey, token, scopeRequest, projectId);
		logger.info(String.format("RETURN::/{projectId}/add-scope POST %s", HttpStatus.CREATED.value()));
		return new ResponseEntity<>(new CustomerResponse(HttpStatus.CREATED.value(), responseObject),
				HttpStatus.CREATED);
	}

	@PostMapping(value = "/{projectId}/team-onboarding/add-team-member", consumes = { "application/json" }, produces = {
			"application/json" })
	public ResponseEntity<Object> addTeamMember(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken,
			@RequestBody @NotNull @NotBlank TeamOnboarding onboardingRequest,
			@PathVariable("projectId") Long projectId) {
		logger.info(String.format("BEGIN::/{projectId}/team-onboarding/add-team-member POST %s", projectId));
		String token = CommonUtils.resolveToken(jwtToken);
		TeamOnboarding onboardedTeamMembers = projectService.addTeamMember(apiKey, token, onboardingRequest, projectId);
		logger.info(String.format("RETURN::/{projectId}/team-onboarding/add-team-member POST %s",
				HttpStatus.CREATED.value()));
		return new ResponseEntity<>(new TeamOnboardingResponse(HttpStatus.CREATED.value(), onboardedTeamMembers),
				HttpStatus.CREATED);
	}

	@PostMapping(value = "/{projectId}/project-plan/upload-activity-plan")
	public ResponseEntity<Object> addActivityPlan(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken, @RequestBody @NotNull @NotBlank JsonNode activityPlan,
			@PathVariable("projectId") Long projectId) throws JsonProcessingException {
		logger.info(
				String.format("BEGIN::/{projectId}/project-plan/upload-activity-plan POST %s", activityPlan.asText()));
		String token = CommonUtils.resolveToken(jwtToken);
		ProjectsDto activityPlanResponse = projectService.addActivityPlan(apiKey, token, activityPlan, projectId);
		logger.info(String.format("RETURN::/{projectId}/project-plan/upload-activity-plan POST %s",
				HttpStatus.CREATED.value()));
		return new ResponseEntity<>(new ActivityPlanResponse(HttpStatus.CREATED.value(), activityPlanResponse),
				HttpStatus.CREATED);
	}

	@GetMapping(value = "/{projectId}/project-plan/get-activity-plans")
	public ResponseEntity<Object> fetchActivityPlanDetails(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken, @PathVariable("projectId") Long projectId)
			throws JsonProcessingException {
		logger.info(String.format("BEGIN::/{projectId}/project-plan/get-activity-plans GET %s", projectId));
		String token = CommonUtils.resolveToken(jwtToken);
		JsonNode activityPlans = null;
		activityPlans = applicationService.fetchActivityPlanDetails(apiKey, token, projectId);
		logger.info(
				String.format("RETURN::/{projectId}/project-plan/get-activity-plans GET %s", HttpStatus.OK.value()));
		return new ResponseEntity<>(new ApplicationOverViewResponse(HttpStatus.OK.value(), activityPlans),
				HttpStatus.OK);
	}

	@PostMapping(value = "/{projectId}/project-plan/upload-resource-plan")
	public ResponseEntity<Object> addResourcePlan(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken, @RequestBody @NotNull @NotBlank JsonNode resourcePlan,
			@PathVariable("projectId") Long projectId) throws JsonProcessingException {
		logger.info(
				String.format("BEGIN::/{projectId}/project-plan/upload-resource-plan POST %s", resourcePlan.asText()));
		String token = CommonUtils.resolveToken(jwtToken);
		ProjectsDto resourcePlanResponse = projectService.addResourcePlan(apiKey, token, resourcePlan, projectId);
		logger.info(String.format("RETURN::/{projectId}/project-plan/upload-resource-plan POST %s",
				HttpStatus.CREATED.value()));
		return new ResponseEntity<>(new ResourcePlanResponse(HttpStatus.CREATED.value(), resourcePlanResponse),
				HttpStatus.CREATED);
	}

	@GetMapping(value = "/{projectId}/project-plan/get-resource-plans")
	public ResponseEntity<Object> fetchResourcePlanDetails(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken, @PathVariable("projectId") Long projectId)
			throws JsonProcessingException {
		logger.info(String.format("BEGIN::/{projectId}/project-plan/get-resource-plans GET %s", projectId));
		String token = CommonUtils.resolveToken(jwtToken);
		JsonNode resourcePlans = null;
		resourcePlans = applicationService.fetchResourcePlanDetails(apiKey, token, projectId);
		logger.info(
				String.format("RETURN::/{projectId}/project-plan/get-resource-plans GET %s", HttpStatus.OK.value()));
		return new ResponseEntity<>(new ApplicationOverViewResponse(HttpStatus.OK.value(), resourcePlans),
				HttpStatus.OK);
	}

	@PostMapping(value = "/{projectId}/add-notifications")
	public ResponseEntity<Object> addNotifications(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken,
			@RequestBody @NotNull @NotBlank Notifications notifications, @PathVariable("projectId") Long projectId) {
		logger.info(String.format("BEGIN::/{projectId}/add-notifications POST %s", projectId));
		String token = CommonUtils.resolveToken(jwtToken);
		Notifications notificationResponse = projectService.addNotifications(apiKey, token, notifications, projectId);
		logger.info(String.format("RETURN::/{projectId}/add-notifications POST %s", HttpStatus.CREATED.value()));
		return new ResponseEntity<>(new ProjectDtoResponse(HttpStatus.CREATED.value(), notificationResponse),
				HttpStatus.CREATED);
	}

	@PostMapping(value = "/{projectId}/create-workflow")
	public ResponseEntity<Object> addWorkflow(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken, @RequestBody @NotNull @NotBlank WorkflowMgmt workflowMgmt,
			@PathVariable("projectId") Long projectId) {
		logger.info(String.format("BEGIN::/{projectId}/create-workflow POST %s", projectId));
		String token = CommonUtils.resolveToken(jwtToken);
		WorkflowMgmt workflowResponse = projectService.addWorkflow(apiKey, token, workflowMgmt, projectId);
		logger.info(String.format("RETURN::/{projectId}/create-workflow POST %s", HttpStatus.CREATED.value()));
		return new ResponseEntity<>(new ProjectDtoResponse(HttpStatus.CREATED.value(), workflowResponse),
				HttpStatus.CREATED);
	}

	@GetMapping(value = "/{projectId}")
	public ResponseEntity<Object> getProjectById(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken, @PathVariable("projectId") Long projectId) {
		logger.info(String.format("BEGIN::/{projectId} GET %s", projectId));
		String token = CommonUtils.resolveToken(jwtToken);
		ProjectsDto projectsDto = projectService.fetchProjectDetails(apiKey, token, projectId);
		logger.info(String.format("RETURN::/{projectId} GET %s", HttpStatus.OK.value()));
		return new ResponseEntity<>(new ProjectDtoResponse(HttpStatus.OK.value(), projectsDto), HttpStatus.OK);
	}

	@GetMapping(value = "/get-all-projects")
	public ResponseEntity<Object> getAllProjects(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken) {
		logger.info(String.format("BEGIN::/get-all-projects GET %s", "Get all projects"));
		String token = CommonUtils.resolveToken(jwtToken);
		List<ProjectsDto> projectsDtoList = projectService.fetchAllProjectDetails(apiKey, token);
		logger.info(String.format("RETURN::/get-all-projects GET %s", HttpStatus.OK.value()));
		return new ResponseEntity<>(new ProjectDtoResponse(HttpStatus.OK.value(), projectsDtoList), HttpStatus.OK);
	}

	@PostMapping(value = "/{projectId}/add-application-overview")
	public ResponseEntity<Object> addApplicationsOverviewDetails(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken,
			@RequestBody @NotBlank @NotNull ApplicationOverview applicationOverview,
			@PathVariable("projectId") Long projectId) {
		logger.info(String.format("BEGIN::/{projectId}/add-application-overview POST %s",
				applicationOverview.getApplicationName()));
		String token = CommonUtils.resolveToken(jwtToken);
		ApplicationOverview applicationOverviewResponse = null;
		applicationOverviewResponse = projectService.addApplicationOverviewDetails(apiKey, token, applicationOverview,
				projectId);
		logger.info(String.format("RETURN::/{projectId}/add-application-overview POST %s", HttpStatus.CREATED.value()));
		return new ResponseEntity<>(
				new ApplicationOverViewResponse(HttpStatus.CREATED.value(), applicationOverviewResponse),
				HttpStatus.CREATED);
	}

	@PostMapping(value = "/application/{applicationId}/add-integration-layer")
	public ResponseEntity<Object> addIntegrationLayerDetails(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken,
			@RequestBody @NotBlank @NotNull IntegrationLayerDetails integrationLayerDetails,
			// @PathVariable("projectId") Long projectId,
			@PathVariable("applicationId") Long applicationId) {
		logger.info(String.format("BEGIN::/application/{applicationId}/add-integration-layer POST %s",
				integrationLayerDetails.getApplicationId()));
		String token = CommonUtils.resolveToken(jwtToken);
		IntegrationLayerDetails integrationLayerResponse = null;
		integrationLayerResponse = projectService.addIntegrationLayerDetails(apiKey, token, integrationLayerDetails,
				applicationId);
		logger.info(String.format("RETURN::/application/{applicationId}/add-integration-layer POST %s",
				HttpStatus.CREATED.value()));
		return new ResponseEntity<>(new IntegrationLayerResponse(HttpStatus.CREATED.value(), integrationLayerResponse),
				HttpStatus.CREATED);
	}

	@PostMapping(value = "/application/{applicationId}/add-application-layer")
	public ResponseEntity<Object> addApplicationsLayerDetails(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken,
			@RequestBody @NotBlank @NotNull ApplicationLayerDetails applicationLayerDetails,
			@PathVariable("applicationId") Long applicationId) {
		logger.info(String.format("BEGIN::/application/{applicationId}/add-application-layer POST %s",
				applicationLayerDetails.getApplicationId()));
		String token = CommonUtils.resolveToken(jwtToken);
		ApplicationLayerDetails response = null;
		response = projectService.addIntegrationLayerDetails(apiKey, token, applicationLayerDetails, applicationId);
		logger.info(String.format("RETURN::/application/{applicationId}/add-application-layer POST %s",
				HttpStatus.CREATED.value()));
		return new ResponseEntity<>(new ApplicationLayerResponse(HttpStatus.CREATED.value(), response),
				HttpStatus.CREATED);
	}

	@PostMapping(value = "/application/{applicationId}/add-storage-details")
	public ResponseEntity<Object> addStorageDetails(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken,
			@RequestBody @NotBlank @NotNull StorageDetails storageDetails,
			@PathVariable("applicationId") Long applicationId) {
		logger.info(String.format("BEGIN::/application/{applicationId}/add-storage-details POST %s", applicationId));
		String token = CommonUtils.resolveToken(jwtToken);
		StorageDetails response = null;
		response = projectService.addStorageDetails(apiKey, token, storageDetails, applicationId);
		logger.info(String.format("RETURN::/application/{applicationId}/add-storage-details POST %s",
				HttpStatus.CREATED.value()));
		return new ResponseEntity<>(new ApplicationLayerResponse(HttpStatus.CREATED.value(), response),
				HttpStatus.CREATED);
	}

	@PostMapping(value = "/application/{applicationId}/add-security-compliance")
	public ResponseEntity<Object> addSecurityComplianceDetails(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken,
			@RequestBody @NotBlank @NotNull SecurityCompliance securityCompliance,
			@PathVariable("applicationId") Long applicationId) {
		logger.info(
				String.format("BEGIN::/application/{applicationId}/add-security-compliance POST %s", applicationId));
		String token = CommonUtils.resolveToken(jwtToken);
		SecurityCompliance response = null;
		response = projectService.addSecurityComplianceDetails(apiKey, token, securityCompliance, applicationId);
		logger.info(String.format("RETURN::/application/{applicationId}/add-security-compliance POST %s",
				HttpStatus.CREATED.value()));
		return new ResponseEntity<>(new ApplicationOverViewResponse(HttpStatus.CREATED.value(), response),
				HttpStatus.CREATED);
	}

	@PostMapping(value = "/application/{applicationId}/add-server-details")
	public ResponseEntity<Object> addServerDetails(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken,
			@RequestBody @NotBlank @NotNull ServerDetails serverDetails,
			@PathVariable("applicationId") Long applicationId) {
		logger.info(String.format("BEGIN::/application/{applicationId}/add-server-details POST %s", applicationId));
		String token = CommonUtils.resolveToken(jwtToken);
		ServerDetails response = null;
		response = projectService.addServerDetails(apiKey, token, serverDetails, applicationId);
		logger.info(String.format("RETURN::/application/{applicationId}/add-server-details POST %s",
				HttpStatus.CREATED.value()));
		return new ResponseEntity<>(new ApplicationOverViewResponse(HttpStatus.CREATED.value(), response),
				HttpStatus.CREATED);
	}

	@PostMapping(value = "/application/{applicationId}/add-recommendations")
	public ResponseEntity<Object> addRecommendations(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken,
			@RequestBody @NotBlank @NotNull Recommendations recommendations,
			@PathVariable("applicationId") Long applicationId) {
		logger.info(String.format("BEGIN::/application/{applicationId}/add-recommendations POST %s", applicationId));
		String token = CommonUtils.resolveToken(jwtToken);
		Recommendations response = null;
		response = applicationService.addRecommendations(apiKey, token, recommendations, applicationId);
		logger.info(String.format("RETURN::/application/{applicationId}/add-recommendations POST %s",
				HttpStatus.CREATED.value()));
		return new ResponseEntity<>(new ApplicationOverViewResponse(HttpStatus.CREATED.value(), response),
				HttpStatus.CREATED);
	}

	@GetMapping(value = "/application/{applicationId}/get-applicaiton")
	public ResponseEntity<Object> getApplicationDetailsById(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken, @PathVariable("applicationId") Long applicationId) {
		logger.info(String.format("BEGIN::/application/{applicationId}/get-applicaiton GET %s", applicationId));
		String token = CommonUtils.resolveToken(jwtToken);
		ApplicationOverview applicationOverviewResponse = null;
		applicationOverviewResponse = applicationService.getApplicationDetailsById(apiKey, token, applicationId);
		logger.info(
				String.format("RETURN::/application/{applicationId}/get-applicaiton GET %s", HttpStatus.OK.value()));
		return new ResponseEntity<>(new ApplicationOverViewResponse(HttpStatus.OK.value(), applicationOverviewResponse),
				HttpStatus.OK);
	}

	@GetMapping(value = "/application/{applicationId}/get-application-layer")
	public ResponseEntity<Object> fetchApplicationLayerDetails(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken, @PathVariable("applicationId") Long applicationId) {
		logger.info(String.format("BEGIN::/application/{applicationId}/get-application-layer GET %s", applicationId));
		String token = CommonUtils.resolveToken(jwtToken);
		List<ApplicationLayerDetails> applicationLayerDetailsList = null;
		applicationLayerDetailsList = applicationService.fetchApplicationLayerDetails(apiKey, token, applicationId);
		logger.info(String.format("RETURN::/application/{applicationId}/get-application-layer GET %s",
				HttpStatus.OK.value()));
		return new ResponseEntity<>(new ApplicationOverViewResponse(HttpStatus.OK.value(), applicationLayerDetailsList),
				HttpStatus.OK);
	}

	@GetMapping(value = "/application/{applicationId}/get-integration-layer")
	public ResponseEntity<Object> fetchIntegrationLayerDetails(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken, @PathVariable("applicationId") Long applicationId) {
		logger.info(String.format("BEGIN::/application/{applicationId}/get-integration-layer GET %s", applicationId));
		String token = CommonUtils.resolveToken(jwtToken);
		List<IntegrationLayerDetails> integrationLayerDetailsList = null;
		integrationLayerDetailsList = applicationService.fetchIntegrationLayerDetails(apiKey, token, applicationId);
		logger.info(String.format("RETURN::/application/{applicationId}/get-integration-layer GET %s",
				HttpStatus.OK.value()));
		return new ResponseEntity<>(new ApplicationOverViewResponse(HttpStatus.OK.value(), integrationLayerDetailsList),
				HttpStatus.OK);
	}

	@GetMapping(value = "/application/{applicationId}/get-storage-details")
	public ResponseEntity<Object> fetchStorageDetails(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken, @PathVariable("applicationId") Long applicationId) {
		logger.info(String.format("BEGIN::/application/{applicationId}/get-storage-details GET %s", applicationId));
		String token = CommonUtils.resolveToken(jwtToken);
		List<StorageDetails> storageDetailsList = null;
		storageDetailsList = applicationService.fetchStorageDetails(apiKey, token, applicationId);
		logger.info(String.format("RETURN::/application/{applicationId}/get-storage-details GET %s",
				HttpStatus.OK.value()));
		return new ResponseEntity<>(new ApplicationOverViewResponse(HttpStatus.OK.value(), storageDetailsList),
				HttpStatus.OK);
	}

	@GetMapping(value = "/application/{applicationId}/get-security-compliance")
	public ResponseEntity<Object> fetchSecurityComplianceDetails(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken, @PathVariable("applicationId") Long applicationId) {
		logger.info(String.format("BEGIN::/application/{applicationId}/get-security-compliance GET %s", applicationId));
		String token = CommonUtils.resolveToken(jwtToken);
		List<SecurityCompliance> securityCompliancesList = null;
		securityCompliancesList = applicationService.fetchSecurityComplianceDetails(apiKey, token, applicationId);
		logger.info(String.format("RETURN::/application/{applicationId}/get-security-compliance GET %s",
				HttpStatus.OK.value()));
		return new ResponseEntity<>(new ApplicationOverViewResponse(HttpStatus.OK.value(), securityCompliancesList),
				HttpStatus.OK);
	}

	@GetMapping(value = "/application/{applicationId}/get-server-details")
	public ResponseEntity<Object> fetchServerDetails(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken, @PathVariable("applicationId") Long applicationId) {
		logger.info(String.format("BEGIN::/application/{applicationId}/get-server-details GET %s", applicationId));
		String token = CommonUtils.resolveToken(jwtToken);
		List<ServerDetails> serverDetailsList = null;
		serverDetailsList = applicationService.fetchServerDetails(apiKey, token, applicationId);
		logger.info(
				String.format("RETURN::/application/{applicationId}/get-server-details GET %s", HttpStatus.OK.value()));
		return new ResponseEntity<>(new ApplicationOverViewResponse(HttpStatus.OK.value(), serverDetailsList),
				HttpStatus.OK);
	}

	@GetMapping(value = "/application/{applicationId}/get-recommendations")
	public ResponseEntity<Object> fetchRecommendationDetails(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken, @PathVariable("applicationId") Long applicationId) {
		logger.info(String.format("BEGIN::/application/{applicationId}/get-recommendations GET %s", applicationId));
		String token = CommonUtils.resolveToken(jwtToken);
		List<Recommendations> recommendationsList = null;
		recommendationsList = applicationService.fetchRecommendationDetails(apiKey, token, applicationId);
		logger.info(String.format("RETURN::/application/{applicationId}/get-recommendations GET %s",
				HttpStatus.OK.value()));
		return new ResponseEntity<>(new ApplicationOverViewResponse(HttpStatus.OK.value(), recommendationsList),
				HttpStatus.OK);
	}

	@GetMapping(value = "/{projectId}/project-team/get-all-team-members")
	public ResponseEntity<Object> getAllTeamMembers(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken, @PathVariable("projectId") Long projectId) {
		logger.info(String.format("BEGIN::/{projectId}/project-team/get-all-team-members GET %s", projectId));
		String token = CommonUtils.resolveToken(jwtToken);
		ProjectTeam projectTeam = projectService.getAllProjectTeamMembers(apiKey, token, projectId);
		logger.info(
				String.format("RETURN::/{projectId}/project-team/get-all-team-members GET %s", HttpStatus.OK.value()));
		return new ResponseEntity<>(new TeamOnboardingResponse(HttpStatus.OK.value(), projectTeam), HttpStatus.OK);
	}

	/*
	 * @GetMapping(value="/{projectId}/get-all-applications") public
	 * ResponseEntity<Object>
	 * getAllApplicationsByProjectId(@RequestHeader("API-KEY") String apiKey,
	 * 
	 * @RequestHeader("Authorization") String jwtToken,
	 * 
	 * @PathVariable("projectId") @NotNull @NotBlank Long projectId){ String token =
	 * CommonUtils.resolveToken(jwtToken); List<ApplicationOverview>
	 * applicationOverviewList=new ArrayList<>(); applicationOverviewList =
	 * projectService.getAllApplicationsByProjectId(apiKey,token,projectId); return
	 * new ResponseEntity<>(new ApplicationOverViewResponse(HttpStatus.OK.value(),
	 * applicationOverviewList), HttpStatus.OK); }
	 */
}
