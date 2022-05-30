package com.acldigital.unaito.service.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.acldigital.unaito.db.IUserDataService;
import com.acldigital.unaito.service.user.constants.UserConstants;
import com.acldigital.unaito.service.user.dto.ErrorResponse;
import com.acldigital.unaito.service.user.dto.User;
import com.acldigital.unaito.service.user.dto.UserRequest;
import com.acldigital.unaito.service.user.dto.UserResponse;
import com.acldigital.unaito.service.user.exception.EmptyInputException;
import com.acldigital.unaito.service.user.exception.InvalidUserException;
import com.acldigital.unaito.service.user.exception.UserException;

@Component
public class UserUtils {

	@Autowired
	private IUserDataService userDataService;

	public boolean checkIfDuplicateUsername(String username) {
		return userDataService.checkIfUserNameAlreadyPresent(username);
	}

	public void checkIfValidUser(UserRequest request, User userProfileDetails) {
		checkIfValidUserProfileDetails(userProfileDetails);
		if (request.getUserName().equals(userProfileDetails.getUserName())) {
			if (!request.getPassword().equals(userProfileDetails.getPassword())) {
				throw new InvalidUserException(UserConstants.INVALID_USER, HttpStatus.FORBIDDEN.value());
			}
		}

	}

	public void checkIfValidUserProfileDetails(User userProfileDetails) {
		if (userProfileDetails == null) {
			throw new EmptyInputException(UserConstants.CHECK_INPUT, HttpStatus.NO_CONTENT.value());
		}

		if (userProfileDetails.getIsActive() <= 0) {
			throw new UserException(UserConstants.USER_NOT_ACTIVE, HttpStatus.FORBIDDEN.value());
		}
	}

	public void checkIfValidUserByUserId(Long userId, User userProfileDetails) {
		checkIfValidUserProfileDetails(userProfileDetails);

		if (!userId.equals(userProfileDetails.getUserId())) {
			throw new InvalidUserException(UserConstants.INVALID_USER, HttpStatus.BAD_REQUEST.value());
		}

	}

	public void checkIfValidUserByUserName(String userName, User userProfileDetails) {
		checkIfValidUserProfileDetails(userProfileDetails);
		if (!userName.equals(userProfileDetails.getUserName())) {
			throw new InvalidUserException(UserConstants.INVALID_USER, HttpStatus.BAD_REQUEST.value());
		}
	}

	public ResponseEntity<ErrorResponse> checkPreConditions(UserRequest request) {
		if (request == null) {
			throw new EmptyInputException("This is a bad request", HttpStatus.FORBIDDEN.value());
		}
		return null;
	}

	public ResponseEntity<Object> successResponse() {
		UserResponse resp = new UserResponse();
		resp.setResponseCode(HttpStatus.OK.value());
		resp.setResponseObject(UserConstants.SUCCESS);
		return new ResponseEntity<>(resp, org.springframework.http.HttpStatus.OK);
	}

	public ResponseEntity<Object> badResponse() {
		UserResponse resp = new UserResponse();
		resp.setResponseCode(HttpStatus.BAD_REQUEST.value());
		resp.setResponseObject(UserConstants.BAD_REQUEST);
		return new ResponseEntity<>(resp, org.springframework.http.HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Object> duplicateUserNameResponse() {
		// UserConstants.DUPLICATE_USERNAME, HttpStatus.CONFLICT

		UserResponse resp = new UserResponse();
		resp.setResponseCode(HttpStatus.CONFLICT.value());
		resp.setResponseObject(UserConstants.DUPLICATE_USERNAME);
		return new ResponseEntity<>(resp, org.springframework.http.HttpStatus.CONFLICT);
	}

	public ResponseEntity<Object> signInResponse(Integer responseCode, Object responseObject) {
		UserResponse resp = new UserResponse();
		resp.setResponseCode(responseCode);
		resp.setResponseObject(responseObject);
		return new ResponseEntity<Object>(resp, HttpStatus.OK);
	}

}