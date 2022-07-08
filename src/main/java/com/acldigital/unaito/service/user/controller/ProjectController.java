package com.acldigital.unaito.service.user.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
import com.acldigital.unaito.service.project.dto.TeamOnboarding;
import com.acldigital.unaito.service.service.IProjectService;
import com.acldigital.unaito.service.user.dto.ActivityPlan;
import com.acldigital.unaito.service.user.dto.CustomerResponse;
import com.acldigital.unaito.service.user.dto.ProjectDtoResponse;
import com.acldigital.unaito.service.user.dto.ProjectsDto;
import com.acldigital.unaito.service.user.dto.ResourceOnboardingPlan;
import com.acldigital.unaito.service.user.dto.ResourcePlanResponse;
import com.acldigital.unaito.service.user.dto.TeamOnboardingResponse;
import com.acldigital.unaito.service.utils.CommonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/unaito/v1/projects")
public class ProjectController {

	@Autowired
	private IProjectService projectService;

	@PostMapping("/create")
	public ResponseEntity<Object> createProject(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken,
			@RequestBody @NotNull @NotBlank ProjectsDto newProjectRequest) throws JsonProcessingException {
		ProjectsDto responseObject = null;
		String token = CommonUtils.resolveToken(jwtToken);
		if (!ObjectUtils.isEmpty(newProjectRequest)) {
			responseObject = projectService.createNewProject(apiKey, token, newProjectRequest);
		}
		return new ResponseEntity<>(new CustomerResponse(HttpStatus.CREATED.value(), responseObject),
				HttpStatus.CREATED);
	}

	@PostMapping("/{projectId}/add-drivers")
	public ResponseEntity<Object> addDrivers(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken, @RequestBody @NotNull @NotBlank JsonNode driverRequest,
			@PathVariable("projectId") Long projectId) throws JsonProcessingException {
		ProjectsDto responseObject = null;
		String token = CommonUtils.resolveToken(jwtToken);
		responseObject = projectService.addDrivers(apiKey, token, driverRequest, projectId);
		return new ResponseEntity<>(new CustomerResponse(HttpStatus.CREATED.value(), responseObject),
				HttpStatus.CREATED);
	}

	@PostMapping("/{projectId}/add-scope")
	public ResponseEntity<Object> addScope(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken, @RequestBody @NotNull @NotBlank JsonNode scopeRequest,
			@PathVariable("projectId") Long projectId) throws JsonProcessingException {
		ProjectsDto responseObject = null;
		String token = CommonUtils.resolveToken(jwtToken);
		responseObject = projectService.addScopes(apiKey, token, scopeRequest, projectId);
		return new ResponseEntity<>(new CustomerResponse(HttpStatus.CREATED.value(), responseObject),
				HttpStatus.CREATED);
	}

	@PostMapping(value = "/{projectId}/team-onboarding/add-team-member", consumes = { "application/json" }, produces = {
			"application/json" })
	public ResponseEntity<Object> addTeamMember(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken,
			@RequestBody @NotNull @NotBlank TeamOnboarding onboardingRequest,
			@PathVariable("projectId") Long projectId) {
		String token = CommonUtils.resolveToken(jwtToken);
		TeamOnboarding onboardedTeamMembers = projectService.addTeamMember(apiKey, token, onboardingRequest, projectId);
		return new ResponseEntity<>(new TeamOnboardingResponse(HttpStatus.CREATED.value(), onboardedTeamMembers),
				HttpStatus.CREATED);
	}

	@PostMapping(value = "/{projectId}/project-plan/add-activity-plan")
	public ResponseEntity<Object> addActivityPlan(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken, @RequestBody @NotNull @NotBlank ActivityPlan activityPlan,
			@PathVariable("projectId") Long projectId) {
		String token = CommonUtils.resolveToken(jwtToken);
		ActivityPlan activityPlanResponse = projectService.addActivityPlan(apiKey, token, activityPlan, projectId);
		return new ResponseEntity<>(new ActivityPlanResponse(HttpStatus.CREATED.value(), activityPlanResponse),
				HttpStatus.CREATED);
	}

	@PostMapping(value = "/{projectId}/project-plan/add-resource-plan")
	public ResponseEntity<Object> addResourcePlan(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken,
			@RequestBody @NotNull @NotBlank ResourceOnboardingPlan resourcePlan,
			@PathVariable("projectId") Long projectId) {
		String token = CommonUtils.resolveToken(jwtToken);
		ResourceOnboardingPlan activityPlanResponse = projectService.addResourcePlan(apiKey, token, resourcePlan,
				projectId);
		return new ResponseEntity<>(new ResourcePlanResponse(HttpStatus.CREATED.value(), activityPlanResponse),
				HttpStatus.CREATED);
	}

	@GetMapping(value = "/{projectId}")
	public ResponseEntity<Object> getProjectById(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken, @PathVariable("projectId") Long projectId) {
		String token = CommonUtils.resolveToken(jwtToken);
		ProjectsDto projectsDto = projectService.fetchProjectDetails(apiKey, token, projectId);
		return new ResponseEntity<>(new ProjectDtoResponse(HttpStatus.CREATED.value(), projectsDto),
				HttpStatus.CREATED);
	}
	
}
