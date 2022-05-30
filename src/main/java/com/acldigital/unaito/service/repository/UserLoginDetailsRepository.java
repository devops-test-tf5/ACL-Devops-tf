package com.acldigital.unaito.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.acldigital.unaito.service.entity.UserLoggedInEntity;

@Repository
public interface UserLoginDetailsRepository extends CrudRepository<UserLoggedInEntity, Long> {

	
}
