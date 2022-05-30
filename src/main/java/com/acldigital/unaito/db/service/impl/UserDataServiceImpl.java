package com.acldigital.unaito.db.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.acldigital.unaito.db.IUserDataService;
import com.acldigital.unaito.db.mapper.MapperUtils;
import com.acldigital.unaito.service.entity.RoleEntity;
import com.acldigital.unaito.service.entity.UserEntity;
import com.acldigital.unaito.service.entity.UserLoggedInEntity;
import com.acldigital.unaito.service.repository.IRoleRepository;
import com.acldigital.unaito.service.repository.IUserRepository;
import com.acldigital.unaito.service.repository.UserLoginDetailsRepository;
import com.acldigital.unaito.service.user.constants.UserConstants;
import com.acldigital.unaito.service.user.dto.AuthorizationRequest;
import com.acldigital.unaito.service.user.dto.User;
import com.acldigital.unaito.service.user.dto.UserLoggedInDetails;
import com.acldigital.unaito.service.user.dto.UserRequest;
import com.acldigital.unaito.service.user.exception.UserNotFoundException;

@Service
public class UserDataServiceImpl implements IUserDataService {

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IRoleRepository roleRepository;

	@Autowired
	private MapperUtils mapperUtils;

	@Autowired
	private UserLoginDetailsRepository userLoginDetailsRepository;

	@Override
	public User registerUser(UserRequest request) {

		Iterable<RoleEntity> roleEntityIterable = roleRepository.findAll();
		List<RoleEntity> roleEntities = new ArrayList<>();
		roleEntityIterable.forEach(roleEntities::add);
		UserEntity userEntity = new UserEntity();
		for (RoleEntity entity : roleEntities) {
			if (entity.getRoleName().equalsIgnoreCase(request.getRoleName())) {
				userEntity.setRoleId(entity.getRoleId());
			}
		}

		userEntity.setUserName(request.getUserName());
		userEntity.setFirstName(request.getFirstName());
		userEntity.setPassword(request.getPassword());
		userEntity.setLastName(request.getLastName());
		userEntity.setEmail(request.getEmail());
		userEntity.setContactNumber(request.getContactNumber());
		userEntity.setLocation(request.getLocation());
		userEntity.setActive(UserConstants.ACTIVE_STATUS);

		UserEntity responseEntity = userRepository.save(userEntity);
		return mapperUtils.convertToUserDto(responseEntity, request.getRoleName());
	}

	@Override
	public User getProfileDetailsByUserName(String userName) {

		UserEntity userEntity = userRepository.getUserByUserName(userName);
		if (ObjectUtils.isEmpty(userEntity)) {
			throw new UserNotFoundException(UserConstants.NOT_FOUND, HttpStatus.NOT_FOUND.value());
		}
		RoleEntity roleEntity = roleRepository.getById(userEntity.getRoleId());

		return new User(userEntity.getUserId(), userEntity.getUserName(), userEntity.getPassword(),
				userEntity.getFirstName(), userEntity.getLastName(), userEntity.getEmail(), roleEntity.getRoleName(),
				userEntity.getContactNumber(), userEntity.getIsActive(), userEntity.getLocation());
	}

	/*
	 * @Override public Integer updateUserDetails(UserRequest userRequest) { Long
	 * roleId = roleRepository.getRoleIdByRoleName(userRequest.getRoleName());
	 * Integer responseStatus =
	 * userRepository.updateUserDetails(userRequest.getPassword(),userRequest.
	 * getFirstName(),
	 * userRequest.getLastName(),userRequest.getContactNumber(),userRequest.getEmail
	 * (),userRequest.getLocation(), userRequest.getRoleName()); return
	 * responseStatus; //return mapperUtils.convertToUserDto(responseStatus,
	 * userRequest.getRoleName()); }
	 */

	@Override
	public boolean checkIfUserNameAlreadyPresent(String userName) {
		List<String> userNamesList = userRepository.checkIfUserNameAlreadyAvailable();
		if (userNamesList.contains(userName)) {
			return true;
		}
		return false;
	}

	@Override
	public void updateUserDetails(UserRequest userRequest, User userProfileDetails) {
		UserEntity userEntity = new UserEntity();
		if (!userRequest.getFirstName().equals(userProfileDetails.getFirstName())) {
			userEntity.setFirstName(userRequest.getFirstName());
		}
		/*
		 * userEntity.setFirstName(userRequest.getFirstName());
		 * userEntity.setLastName(userRequest.getLastName());
		 * userEntity.setEmail(userRequest.getEmail());
		 * userEntity.setContactNumber(userRequest.getContactNumber());
		 * userEntity.setLocation(userRequest.getLocation());
		 */
		userRepository.updateUserDetails(userRequest.getUserName(), userRequest.getFirstName(),
				userRequest.getLastName(), userRequest.getContactNumber(), userRequest.getEmail(),
				userRequest.getLocation());
	}

	@Override
	public UserLoggedInDetails saveUserLoggedInDetails(UserLoggedInDetails userLoggedInDetails) throws Exception {
		UserLoggedInEntity entity = mapperUtils.convertToUserLoginDetailsEntity(userLoggedInDetails);
		UserLoggedInEntity responseEntity = userLoginDetailsRepository.save(entity);
		return mapperUtils.convertToUserLoginDetailsDto(responseEntity);
	}

}
