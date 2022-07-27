package com.acldigital.unaito.service.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.acldigital.unaito.service.user.dto.AuthorizationRequest;
import com.acldigital.unaito.service.user.dto.UserDto;
import com.acldigital.unaito.service.user.dto.UserRegistrationDetails;
import com.acldigital.unaito.service.user.dto.UserRequest;

@Component
public interface IUserService {

	public ResponseEntity<Object> createUser(String apiKey, UserRegistrationDetails userRegistrationRequest);

	public ResponseEntity<Object> userSignIn(String apiKey, AuthorizationRequest request);

	public ResponseEntity<Object> editUser(String apiKey, String jwtToken, UserRequest request);

	public ResponseEntity<Object> deleteUser(String apiKey, String jwtToken, String userName);

	public ResponseEntity<Object> forgotPassword(String apiKey, String email);

	public ResponseEntity<Object> verifyCode(Long userId, String verifyId);

	public ResponseEntity<Object> getAllUsers(String apiKey);

	public ResponseEntity<Object> getUserDetails(String apiKey, String userName);

	public ResponseEntity<Object> logout(String apiKey, String token, String userName);

	public int passwordReset(String apiKey, UserDto userDto);
}
