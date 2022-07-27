package com.acldigital.unaito.db;

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

public interface IApplicationsDataService {

	public SecurityCompliance addSecurityComplianceDetails(SecurityCompliance securityCompliance, Long applicationId);

	public ServerDetails addServerDetails(ServerDetails serverDetails, Long applicationId);

	public Recommendations addRecommendations(Recommendations recommendations, Long applicationId);

	public ApplicationOverview getApplicationDetailsById(Long applicationId);

	public List<ApplicationLayerDetails> fetchApplicationLayerDetails(Long applicationId);

	public List<IntegrationLayerDetails> fetchIntegrationLayerDetails(Long applicationId);

	public List<StorageDetails> fetchStorageDetails(Long applicationId);

	public List<SecurityCompliance> fetchSecurityComplianceDetails(Long applicationId);

	public List<ServerDetails> fetchServerDetails(Long applicationId);

	public List<Recommendations> fetchRecommendationDetails(Long applicationId);

	public JsonNode fetchActivityPlanDetails(Long projectId) throws JsonProcessingException;

	public JsonNode fetchResourcePlanDetails(Long projectId) throws JsonProcessingException;

}
