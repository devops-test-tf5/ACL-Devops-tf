package com.acldigital.unaito.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acldigital.unaito.service.entity.ServerDetailsEntity;

@Repository
public interface IServerDetailsRepository extends CrudRepository<ServerDetailsEntity, Long> {

	@Query(value = "select * from server_details sds where sds.application_id=:applicationId", nativeQuery = true)
	public List<ServerDetailsEntity> fetchServerDetails(@Param("applicationId") Long applicationId);
}
