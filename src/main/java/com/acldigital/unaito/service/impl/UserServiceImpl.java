package com.acldigital.unaito.service.impl;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.acldigital.unaito.db.IUserDataService;
import com.acldigital.unaito.service.repository.IRoleRepository;
import com.acldigital.unaito.service.repository.IUserRepository;
import com.acldigital.unaito.service.service.IUserService;
import com.acldigital.unaito.service.user.constants.UserConstants;
import com.acldigital.unaito.service.user.dto.AuthorizationRequest;
import com.acldigital.unaito.service.user.dto.JwtLoggedInDetails;
import com.acldigital.unaito.service.user.dto.User;
import com.acldigital.unaito.service.user.dto.UserLoggedInDetails;
import com.acldigital.unaito.service.user.dto.UserRequest;
import com.acldigital.unaito.service.user.dto.UserResponse;
import com.acldigital.unaito.service.utils.JwtUtils;
import com.acldigital.unaito.service.utils.SecurityUtils;
import com.acldigital.unaito.service.utils.UserUtils;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserUtils userUtils;

	@Autowired
	private IUserDataService userDataService;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IRoleRepository roleRepository;

	@Autowired
	private SecurityUtils securityUtils;

	@Autowired
	private JwtUtils jwtUtils;

	@Override
	public ResponseEntity<Object> createUser(UserRequest request) {
		boolean isDuplicateUsername = userUtils.checkIfDuplicateUsername(request.getUserName());
		if (isDuplicateUsername) {
			return userUtils.duplicateUserNameResponse();
		}
		User user = userDataService.registerUser(request);
		UserResponse resp = new UserResponse();
		resp.setResponseCode(HttpStatus.CREATED.value());
		resp.setResponseObject(user);
		return new ResponseEntity<>(resp, org.springframework.http.HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Object> userSignIn(String apiKey, AuthorizationRequest request) {
		User userProfileDetails = null;
		securityUtils.validateApiKey(apiKey);
		userProfileDetails = userDataService.getProfileDetailsByUserName(request.getUserName());
		UserRequest userRequest = new UserRequest();
		userRequest.setUserName(request.getUserName());
		userRequest.setPassword(request.getPassword());
		userUtils.checkIfValidUser(userRequest, userProfileDetails);
		JwtLoggedInDetails loggedInDetails = jwtUtils.generateToken(request.getUserName());
		Instant loggedInTime = Instant.now();
		try {
			UserLoggedInDetails details = new UserLoggedInDetails();
			details.setJwt(loggedInDetails.getJwt());
			details.setJwtCreatedTime(loggedInDetails.getJwtCreatedTime());
			details.setJwtType(loggedInDetails.getJwtType());
			details.setLoggedIn(UserConstants.YES);
			details.setLoggedInTime(loggedInTime);
			details.setUserId(userProfileDetails.getUserId());
			details.setJwtExpiryTime(loggedInDetails.getJwtExpiryTime());
			details.setJwtCreatedTime(loggedInDetails.getJwtCreatedTime());
			details.setSessionId(loggedInDetails.getSessionId());
			userDataService.saveUserLoggedInDetails(details);
		} catch (Exception e) {
			System.out.println("Exception occurred while trying to save user logged in details to db");
		}

		return userUtils.signInResponse(HttpStatus.OK.value(), loggedInDetails);
	}

	@Override
	public ResponseEntity<Object> editUser(UserRequest request) {
		User userProfileDetails = null;
		userProfileDetails = userDataService.getProfileDetailsByUserName(request.getUserName());
		userUtils.checkIfValidUser(request, userProfileDetails);
		userDataService.updateUserDetails(request, userProfileDetails);
		return userUtils.successResponse();
	}

	@Override
	public ResponseEntity<Object> deleteUser(String userName) {
		User userProfileDetails = null;
		userProfileDetails = userDataService.getProfileDetailsByUserName(userName);
		userUtils.checkIfValidUserByUserName(userName, userProfileDetails);
		userRepository.deleteById(userProfileDetails.getUserId());
		return userUtils.successResponse();
	}

}