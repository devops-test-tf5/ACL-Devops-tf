package com.acldigital.unaito.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acldigital.unaito.service.entity.SecurityComplianceEntity;

@Repository
public interface ISecurityComplianceRepository extends CrudRepository<SecurityComplianceEntity, Long> {

	@Query(value = "select * from security_compliance sc where sc.application_id=:applicationId", nativeQuery = true)
	public List<SecurityComplianceEntity> fetchSecurityComplianceDetails(@Param("applicationId") Long applicationId);
}
