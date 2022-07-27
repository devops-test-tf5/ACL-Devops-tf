package com.acldigital.unaito.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acldigital.unaito.db.IApplicationsDataService;
import com.acldigital.unaito.service.project.dto.ApplicationOverview;
import com.acldigital.unaito.service.service.IApplicationService;
import com.acldigital.unaito.service.user.dto.ApplicationLayerDetails;
import com.acldigital.unaito.service.user.dto.IntegrationLayerDetails;
import com.acldigital.unaito.service.user.dto.Recommendations;
import com.acldigital.unaito.service.user.dto.SecurityCompliance;
import com.acldigital.unaito.service.user.dto.ServerDetails;
import com.acldigital.unaito.service.user.dto.StorageDetails;
import com.acldigital.unaito.service.utils.CommonUtils;
import com.acldigital.unaito.service.utils.SecurityUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class ApplicationServiceImpl implements IApplicationService {

	@Autowired
	private SecurityUtils securityUtils;

	@Autowired
	private CommonUtils commonUtils;

	@Autowired
	private IApplicationsDataService applicationsDataService;

	@Override
	public Recommendations addRecommendations(String apiKey, String token, Recommendations recommendations,
			Long applicationId) {
		Recommendations response = null;
		securityUtils.validateProjectApiKey(apiKey);
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			response = applicationsDataService.addRecommendations(recommendations, applicationId);
		}
		return response;
	}

	@Override
	public ServerDetails addServerDetails(String apiKey, String token, ServerDetails serverDetails,
			Long applicationId) {

		return null;
	}

	@Override
	public ApplicationOverview getApplicationDetailsById(String apiKey, String token, Long applicationId) {
		ApplicationOverview applicationOverviewResponse = null;
		securityUtils.validateProjectApiKey(apiKey);
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			applicationOverviewResponse = applicationsDataService.getApplicationDetailsById(applicationId);
		}
		return applicationOverviewResponse;
	}

	@Override
	public List<ApplicationLayerDetails> fetchApplicationLayerDetails(String apiKey, String token, Long applicationId) {
		List<ApplicationLayerDetails> applicationLayerDetailsList = null;
		securityUtils.validateProjectApiKey(apiKey);
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			applicationLayerDetailsList = applicationsDataService.fetchApplicationLayerDetails(applicationId);
		}
		return applicationLayerDetailsList;
	}

	@Override
	public List<IntegrationLayerDetails> fetchIntegrationLayerDetails(String apiKey, String token, Long applicationId) {
		List<IntegrationLayerDetails> integrationLayerDetailsList = new ArrayList<>();
		securityUtils.validateProjectApiKey(apiKey);
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			integrationLayerDetailsList = applicationsDataService.fetchIntegrationLayerDetails(applicationId);
		}
		return integrationLayerDetailsList;
	}

	@Override
	public List<StorageDetails> fetchStorageDetails(String apiKey, String token, Long applicationId) {
		List<StorageDetails> storageDetailsList = new ArrayList<>();
		securityUtils.validateProjectApiKey(apiKey);
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			storageDetailsList = applicationsDataService.fetchStorageDetails(applicationId);
		}
		return storageDetailsList;
	}

	@Override
	public List<SecurityCompliance> fetchSecurityComplianceDetails(String apiKey, String token, Long applicationId) {
		List<SecurityCompliance> securityCompliancesList = new ArrayList<>();
		securityUtils.validateProjectApiKey(apiKey);
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			securityCompliancesList = applicationsDataService.fetchSecurityComplianceDetails(applicationId);
		}
		return securityCompliancesList;
	}

	@Override
	public List<ServerDetails> fetchServerDetails(String apiKey, String token, Long applicationId) {
		List<ServerDetails> serverDetailsList = new ArrayList<>();
		securityUtils.validateProjectApiKey(apiKey);
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			serverDetailsList = applicationsDataService.fetchServerDetails(applicationId);
		}
		return serverDetailsList;
	}

	@Override
	public List<Recommendations> fetchRecommendationDetails(String apiKey, String token, Long applicationId) {
		List<Recommendations> recommendationsList = new ArrayList<>();
		securityUtils.validateProjectApiKey(apiKey);
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			recommendationsList = applicationsDataService.fetchRecommendationDetails(applicationId);
		}
		return recommendationsList;
	}

	@Override
	public JsonNode fetchActivityPlanDetails(String apiKey, String token, Long projectId)
			throws JsonProcessingException {
		JsonNode activityPlans = null;
		securityUtils.validateProjectApiKey(apiKey);
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			activityPlans = applicationsDataService.fetchActivityPlanDetails(projectId);
		}
		return activityPlans;
	}

	@Override
	public JsonNode fetchResourcePlanDetails(String apiKey, String token, Long projectId)
			throws JsonProcessingException {
		JsonNode resourcePlans = null;
		securityUtils.validateProjectApiKey(apiKey);
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			resourcePlans = applicationsDataService.fetchResourcePlanDetails(projectId);
		}
		return resourcePlans;
	}

}
