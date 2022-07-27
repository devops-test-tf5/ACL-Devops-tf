package com.acldigital.unaito.db.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.acldigital.unaito.db.IApplicationsDataService;
import com.acldigital.unaito.db.mapper.MapperUtils;
import com.acldigital.unaito.service.entity.ApplicationLayerEntity;
import com.acldigital.unaito.service.entity.ApplicationOverviewEntity;
import com.acldigital.unaito.service.entity.IntegrationLayerEntity;
import com.acldigital.unaito.service.entity.ProjectsEntity;
import com.acldigital.unaito.service.entity.RecommendationsEntity;
import com.acldigital.unaito.service.entity.SecurityComplianceEntity;
import com.acldigital.unaito.service.entity.ServerDetailsEntity;
import com.acldigital.unaito.service.entity.StorageDetailsEntity;
import com.acldigital.unaito.service.project.dto.ApplicationOverview;
import com.acldigital.unaito.service.repository.IApplicationLayerRepository;
import com.acldigital.unaito.service.repository.IApplicationOverviewRepository;
import com.acldigital.unaito.service.repository.IIntegrationLayerRespository;
import com.acldigital.unaito.service.repository.IProjectsRepository;
import com.acldigital.unaito.service.repository.IRecommendationsRepository;
import com.acldigital.unaito.service.repository.ISecurityComplianceRepository;
import com.acldigital.unaito.service.repository.IServerDetailsRepository;
import com.acldigital.unaito.service.repository.IStorageDetailsRepository;
import com.acldigital.unaito.service.user.dto.ApplicationLayerDetails;
import com.acldigital.unaito.service.user.dto.IntegrationLayerDetails;
import com.acldigital.unaito.service.user.dto.Recommendations;
import com.acldigital.unaito.service.user.dto.SecurityCompliance;
import com.acldigital.unaito.service.user.dto.ServerDetails;
import com.acldigital.unaito.service.user.dto.StorageDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class ApplicationsDataServiceImpl implements IApplicationsDataService {

	@Autowired
	private MapperUtils mapperUtils;

	@Autowired
	private ISecurityComplianceRepository securityComplianceRepository;

	@Autowired
	private IServerDetailsRepository serverDetailsRepository;

	@Autowired
	private IRecommendationsRepository recommendationsRepository;

	@Autowired
	private IApplicationOverviewRepository applicationOverviewRepository;

	@Autowired
	private IApplicationLayerRepository applicationLayerRepository;

	@Autowired
	private IIntegrationLayerRespository integrationLayerRespository;

	@Autowired
	private IStorageDetailsRepository storageDetailsRepository;
	
	@Autowired
	private IProjectsRepository projectsRepository;

	@Override
	public SecurityCompliance addSecurityComplianceDetails(SecurityCompliance securityCompliance, Long applicationId) {
		SecurityComplianceEntity entity = null;
		SecurityComplianceEntity responseEntity = null;
		if (!ObjectUtils.isEmpty(securityCompliance)) {
			entity = mapperUtils.convertToSecurityComplianceEntity(securityCompliance, applicationId);
			entity.setApplicationOverviewEntity(new ApplicationOverviewEntity(applicationId));
		}
		responseEntity = securityComplianceRepository.save(entity);
		return mapperUtils.convertToSecurityComplianceDto(responseEntity);
	}

	@Override
	public ServerDetails addServerDetails(ServerDetails serverDetails, Long applicationId) {
		ServerDetailsEntity entity = null;
		ServerDetailsEntity responseEntity = null;
		if (!ObjectUtils.isEmpty(serverDetails)) {
			entity = mapperUtils.convertToServerDetailsEntity(serverDetails);
			entity.setApplicationOverviewEntity(new ApplicationOverviewEntity(applicationId));
		}
		responseEntity = serverDetailsRepository.save(entity);
		return mapperUtils.convertToServerDetailsDto(responseEntity);
	}

	@Override
	public Recommendations addRecommendations(Recommendations recommendations, Long applicationId) {
		RecommendationsEntity entity = null;
		RecommendationsEntity responseEntity = null;
		if (!ObjectUtils.isEmpty(recommendations)) {
			entity = mapperUtils.convertToRecommendationsEntity(recommendations);
			entity.setApplicationEntity(new ApplicationOverviewEntity(applicationId));
		}
		responseEntity = recommendationsRepository.save(entity);
		return mapperUtils.convertToRecommendationsDto(responseEntity);
	}

	@Override
	public ApplicationOverview getApplicationDetailsById(Long applicationId) {
		ApplicationOverview applicationOverviewDto = null;
		Optional<ApplicationOverviewEntity> responseEntity = applicationOverviewRepository.findById(applicationId);
		if (responseEntity.isPresent()) {
			applicationOverviewDto = mapperUtils.convertToApplicationOverviewCompleteDto(responseEntity.get());
		}
		return applicationOverviewDto;
	}

	@Override
	public List<ApplicationLayerDetails> fetchApplicationLayerDetails(Long applicationId) {
		List<ApplicationLayerDetails> applicationLayerDetailsList = null;
		List<ApplicationLayerEntity> responseEntities = applicationLayerRepository.fetchApplicationLayerDetails(applicationId);
		applicationLayerDetailsList = mapperUtils.convertToApplicationLayerDetailsList(responseEntities);
		return applicationLayerDetailsList;
	}

	@Override
	public List<IntegrationLayerDetails> fetchIntegrationLayerDetails(Long applicationId) {
		List<IntegrationLayerDetails> integrationLayerDetailsList = new ArrayList<>();
		List<IntegrationLayerEntity> responseEntities = integrationLayerRespository
				.fetchIntegrationLayerDetails(applicationId);
		integrationLayerDetailsList = mapperUtils.convertToIntegrationLayerDetailsList(responseEntities);
		return integrationLayerDetailsList;
	}

	@Override
	public List<StorageDetails> fetchStorageDetails(Long applicationId) {
		List<StorageDetails> storageDetailsList;
		List<StorageDetailsEntity> responseEntities = storageDetailsRepository.fetchStorageDetails(applicationId);
		storageDetailsList = mapperUtils.convertToStorageDetailsList(responseEntities);
		return storageDetailsList;
	}

	@Override
	public List<SecurityCompliance> fetchSecurityComplianceDetails(Long applicationId) {
		List<SecurityCompliance> securityCompliancesList;
		List<SecurityComplianceEntity> responseEntities = securityComplianceRepository
				.fetchSecurityComplianceDetails(applicationId);
		securityCompliancesList = mapperUtils.convertToSecurityComplianceList(responseEntities);
		return securityCompliancesList;

	}

	@Override
	public List<ServerDetails> fetchServerDetails(Long applicationId) {
		List<ServerDetails> serverDetailsList;
		List<ServerDetailsEntity> responseEntities = serverDetailsRepository.fetchServerDetails(applicationId);
		serverDetailsList = mapperUtils.convertToServerDetailsList(responseEntities);
		return serverDetailsList;
	}

	@Override
	public List<Recommendations> fetchRecommendationDetails(Long applicationId) {
		List<Recommendations> recommendationsList;
		List<RecommendationsEntity> responseEntities = recommendationsRepository
				.fetchRecommendationDetails(applicationId);
		recommendationsList = mapperUtils.convertToRecommendationsList(responseEntities);
		return recommendationsList;
	}

	@Override
	public JsonNode fetchActivityPlanDetails(Long projectId) throws JsonProcessingException {
		JsonNode activityPlans = null;
		Optional<ProjectsEntity> projectEntity = projectsRepository
				.findById(projectId);
		if(projectEntity.isPresent()) {
			   return mapperUtils.convertToActivityPlanJson(projectEntity.get().getActivityPlans());         
		}
		return activityPlans;
	}

	@Override
	public JsonNode fetchResourcePlanDetails(Long projectId) throws JsonProcessingException {
		JsonNode resourcePlans = null;
		Optional<ProjectsEntity> projectEntity = projectsRepository
				.findById(projectId);
		if(projectEntity.isPresent()) {
			   return mapperUtils.convertToResourcePlanJson(projectEntity.get().getResourcePlans());         
		}
		return resourcePlans;
	}

}
