package com.acldigital.unaito.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acldigital.unaito.service.entity.CommunicationTemplateMasterEntity;

@Repository
public interface ICommunicationTemplateMasterRepository extends JpaRepository<CommunicationTemplateMasterEntity, Long> {

	@Query(value = "select * from communication_template_master ctm where ctm.comm_template_type=:templateType", nativeQuery = true)
	CommunicationTemplateMasterEntity findByCommunicationTemplateType(@Param("templateType") String templateType);

}
