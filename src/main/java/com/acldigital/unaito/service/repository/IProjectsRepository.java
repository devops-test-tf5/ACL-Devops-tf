package com.acldigital.unaito.service.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acldigital.unaito.service.entity.ProjectsEntity;
import com.acldigital.unaito.service.user.dto.Drivers;

@Repository
public interface IProjectsRepository extends CrudRepository<ProjectsEntity, Long> {

	@Query(value = "update projects p set p.drivers=:drivers where p.project_id=:projectId", nativeQuery = true)
	public ProjectsEntity saveDrivers(@Param("drivers") Drivers drivers, @Param("projectId") Long projectId);

}
