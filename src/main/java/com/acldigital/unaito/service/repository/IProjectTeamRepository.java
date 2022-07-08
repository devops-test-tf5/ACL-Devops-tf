package com.acldigital.unaito.service.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acldigital.unaito.service.entity.ProjectTeamEntity;

@Repository
public interface IProjectTeamRepository extends CrudRepository<ProjectTeamEntity, Long> {

	@Query(value = "select onboarding_id from project_team pt where pt.project_id=:projectId",nativeQuery = true)
	public Long checkIfOnboardingAvailable(@Param("projectId") Long projectId);
}
