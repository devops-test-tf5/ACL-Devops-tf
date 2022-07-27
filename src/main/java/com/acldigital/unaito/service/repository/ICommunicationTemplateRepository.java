package com.acldigital.unaito.service.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acldigital.unaito.service.entity.CommunicationTemplateMasterEntity;

@Repository
public interface ICommunicationTemplateRepository extends CrudRepository<CommunicationTemplateMasterEntity, Long> {

	@Query(value = "select * from communication_template_master ctm where ctm.comm_template_type=:templateType", nativeQuery = true)
	public CommunicationTemplateMasterEntity findByCommunicationTemplateType(@Param("templateType") String templateType);
}
