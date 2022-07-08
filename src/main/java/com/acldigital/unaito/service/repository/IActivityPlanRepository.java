package com.acldigital.unaito.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.acldigital.unaito.service.entity.ActivityPlanEntity;

@Repository
public interface IActivityPlanRepository extends CrudRepository<ActivityPlanEntity, Long> {

	
}
