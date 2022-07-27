package com.acldigital.unaito.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acldigital.unaito.service.entity.ApplicationLayerEntity;

@Repository
public interface IApplicationLayerRepository extends CrudRepository<ApplicationLayerEntity, Long> {

	@Query(value = "select * from application_layer_details ald where ald.application_id=:applicationId", nativeQuery = true)
	public List<ApplicationLayerEntity> fetchApplicationLayerDetails(@Param("applicationId") Long applicationId);
}
