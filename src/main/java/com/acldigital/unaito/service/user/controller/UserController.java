package com.acldigital.unaito.service.user.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acldigital.unaito.service.service.IUserService;
import com.acldigital.unaito.service.user.dto.AuthorizationRequest;
import com.acldigital.unaito.service.user.dto.UserRequest;
import com.acldigital.unaito.service.user.exception.UserConstraintValidationException;
import com.acldigital.unaito.service.utils.JwtUtils;
import com.acldigital.unaito.service.utils.UserUtils;

@RestController
@Validated
@RequestMapping("/unaito/v1/users")
public class UserController {

	Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private IUserService userService;

	@Autowired
	private UserUtils userUtils;
	
	@Autowired
	private JwtUtils jwtUtils;

	@GetMapping("/welcome")
	public String welcomeUser() {
		logger.info("Welcome to unaito project");
		return "Welcome to unaito";
	}

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> registerUser(@Valid @RequestBody @NotNull UserRequest request)
			throws UserConstraintValidationException {
		return userService.createUser(request);

	}

	@PostMapping("/sign-in")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> userSignIn(
			@RequestHeader("API-KEY") String apiKey, 
			@RequestBody AuthorizationRequest request) {
		
		return userService.userSignIn(apiKey,request);
	}

	@PutMapping("/edit")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> edit(@RequestBody UserRequest request) {
		return userService.editUser(request);
	}

	@DeleteMapping("/delete/{userName}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> deleteUser(@PathVariable String userName) {
		return userService.deleteUser(userName);

	}
	//Forgot password
	// logout api

}
