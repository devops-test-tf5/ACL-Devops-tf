package com.acldigital.unaito.service.service;

import java.util.List;

import com.acldigital.unaito.service.project.dto.ApplicationOverview;
import com.acldigital.unaito.service.user.dto.ApplicationLayerDetails;
import com.acldigital.unaito.service.user.dto.IntegrationLayerDetails;
import com.acldigital.unaito.service.user.dto.Recommendations;
import com.acldigital.unaito.service.user.dto.SecurityCompliance;
import com.acldigital.unaito.service.user.dto.ServerDetails;
import com.acldigital.unaito.service.user.dto.StorageDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public interface IApplicationService {

	public ServerDetails addServerDetails(String apiKey, String token, ServerDetails serverDetails, Long applicationId);

	public Recommendations addRecommendations(String apiKey, String token, Recommendations recommendations,
			Long applicationId);

	public ApplicationOverview getApplicationDetailsById(String apiKey, String token, Long applicationId);

	public List<ApplicationLayerDetails> fetchApplicationLayerDetails(String apiKey, String token, Long applicationId);

	public List<IntegrationLayerDetails> fetchIntegrationLayerDetails(String apiKey, String token, Long applicationId);

	public List<StorageDetails> fetchStorageDetails(String apiKey, String token, Long applicationId);

	public List<SecurityCompliance> fetchSecurityComplianceDetails(String apiKey, String token, Long applicationId);

	public List<ServerDetails> fetchServerDetails(String apiKey, String token, Long applicationId);

	public List<Recommendations> fetchRecommendationDetails(String apiKey, String token, Long applicationId);

	public JsonNode fetchActivityPlanDetails(String apiKey, String token, Long applicationId)
			throws JsonProcessingException;

	public JsonNode fetchResourcePlanDetails(String apiKey, String token, Long applicationId)
			throws JsonProcessingException;
	
}
