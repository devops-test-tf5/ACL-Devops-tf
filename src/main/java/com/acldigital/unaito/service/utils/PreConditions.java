package com.acldigital.unaito.service.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.acldigital.unaito.service.user.dto.ErrorResponse;
import com.acldigital.unaito.service.user.dto.UserRequest;
import com.acldigital.unaito.service.user.exception.UserException;

public class PreConditions {

	public ResponseEntity<ErrorResponse>  checkPreConditions(UserRequest request) throws UserException {
		if (request == null) {
			throw new UserException("This is a bad request", HttpStatus.BAD_REQUEST.value());
		}
		return null;
	}

}
