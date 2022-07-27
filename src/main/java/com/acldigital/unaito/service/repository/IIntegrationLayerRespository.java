package com.acldigital.unaito.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acldigital.unaito.service.entity.IntegrationLayerEntity;

@Repository
public interface IIntegrationLayerRespository extends CrudRepository<IntegrationLayerEntity, Long> {

	@Query(value = "select * from integration_layer_details ild where ild.application_id=:applicationId", nativeQuery = true)
	public List<IntegrationLayerEntity> fetchIntegrationLayerDetails(@Param("applicationId") Long applicationId);
}
