package com.acldigital.unaito.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acldigital.unaito.service.entity.StorageDetailsEntity;

@Repository
public interface IStorageDetailsRepository extends CrudRepository<StorageDetailsEntity, Long> {

	@Query(value = "select * from storage_details sd where sd.application_id=:applicationId", nativeQuery = true)
	public List<StorageDetailsEntity> fetchStorageDetails(@Param("applicationId") Long applicationId);
}
