package com.acldigital.unaito.service.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.acldigital.unaito.service.user.dto.AuthorizationRequest;
import com.acldigital.unaito.service.user.dto.JwtWithProfileDetails;
import com.acldigital.unaito.service.user.dto.UserRequest;

@Component
public interface IUserService {

	public ResponseEntity<Object> createUser(UserRequest request);

	public ResponseEntity<Object> userSignIn(String apiKey, AuthorizationRequest request);

	public ResponseEntity<Object> editUser(UserRequest request);

	public ResponseEntity<Object> deleteUser(String userName);

}
