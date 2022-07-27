package com.acldigital.unaito.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.acldigital.unaito.service.entity.ApplicationOverviewEntity;

@Repository
public interface IApplicationOverviewRepository extends CrudRepository<ApplicationOverviewEntity, Long> {

}
