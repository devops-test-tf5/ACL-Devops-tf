package com.acldigital.unaito.db.mapper;

import org.springframework.stereotype.Component;

import com.acldigital.unaito.service.entity.UserEntity;
import com.acldigital.unaito.service.entity.UserLoggedInEntity;
import com.acldigital.unaito.service.user.constants.UserConstants;
import com.acldigital.unaito.service.user.dto.User;
import com.acldigital.unaito.service.user.dto.UserLoggedInDetails;

@Component
public class MapperUtils {

	public User convertToUserDto(UserEntity userEntity, String roleName) {

		return new User(userEntity.getUserId(), userEntity.getUserName(), userEntity.getPassword(),
				userEntity.getFirstName(), userEntity.getLastName(), userEntity.getEmail(), roleName,
				userEntity.getContactNumber(), UserConstants.ACTIVE_STATUS, userEntity.getLocation());
	}

	public UserLoggedInEntity convertToUserLoginDetailsEntity(UserLoggedInDetails userLoggedInDetails) {
		UserLoggedInEntity entity = new UserLoggedInEntity();
		entity.setUserId(userLoggedInDetails.getUserId());
		entity.setSessionId(userLoggedInDetails.getSessionId());
		entity.setJwtType(userLoggedInDetails.getJwtType());
		entity.setJwt(userLoggedInDetails.getJwt());
		entity.setJwtCreatedTime(userLoggedInDetails.getJwtCreatedTime());
		entity.setJwtExpiryTime(userLoggedInDetails.getJwtExpiryTime());
		entity.setLoggedIn(UserConstants.YES);
		entity.setLoggedInTime(userLoggedInDetails.getLoggedInTime());
		return entity;
	}

	public UserLoggedInDetails convertToUserLoginDetailsDto(UserLoggedInEntity entity) {
		UserLoggedInDetails loginDetails = new UserLoggedInDetails();
		loginDetails.setLoginId(entity.getLoginId());
		loginDetails.setUserId(entity.getUserId());
		loginDetails.setSessionId(entity.getSessionId());
		loginDetails.setJwt(entity.getJwt());
		loginDetails.setJwtType(entity.getJwtType());
		loginDetails.setJwtCreatedTime(entity.getJwtCreatedTime());
		loginDetails.setJwtExpiryTime(entity.getJwtExpiryTime());
		loginDetails.setLoggedIn(entity.getLoggedIn());
		return loginDetails;
	}
}
