package com.acldigital.unaito.service.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
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
import com.acldigital.unaito.service.user.constants.HttpConstantsEnum;
import com.acldigital.unaito.service.user.dto.AuthorizationRequest;
import com.acldigital.unaito.service.user.dto.UserDto;
import com.acldigital.unaito.service.user.dto.UserRegistrationDetails;
import com.acldigital.unaito.service.user.dto.UserRequest;
import com.acldigital.unaito.service.user.dto.UserResponse;
import com.acldigital.unaito.service.user.exception.UnaitoSecurityException;
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

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> registerUser(@RequestHeader("API-KEY") String apiKey,
			@Valid @RequestBody @NotNull UserRegistrationDetails userRegistrationRequest,
			HttpServletRequest servRequest) throws UserConstraintValidationException {
		logger.info(String.format("BEGIN::/create POST %s", userRegistrationRequest.getUserName()));
		ResponseEntity<Object> registeredUser = userService.createUser(apiKey, userRegistrationRequest);
		UserResponse response = (UserResponse) registeredUser.getBody();
		UserDto user = (UserDto) response.getResponseObject();
		return registeredUser;
	}

	@PostMapping("/sign-in")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> userSignIn(@RequestHeader("API-KEY") String apiKey,
			@RequestBody AuthorizationRequest request) {
		return userService.userSignIn(apiKey, request);
	}

	@PutMapping("/edit")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> edit(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken, @RequestBody UserRequest request) {
		String token = resolveToken(jwtToken);
		return userService.editUser(apiKey, token, request);
	}

	@DeleteMapping("/delete/{userName}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> deleteUser(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken, @PathVariable String userName) {
		String token = resolveToken(jwtToken);
		return userService.deleteUser(apiKey, token, userName);
	}

	private String resolveToken(String jwtToken) throws UnaitoSecurityException {
		if (jwtToken != null && jwtToken.startsWith(HttpConstantsEnum.HEADER_BEARER.getValue() + " ")) {
			return jwtToken.substring(7);
		} else {
			throw new UnaitoSecurityException("Invalid JWT Token", HttpStatus.FORBIDDEN.value());
		}
	}

	@PutMapping("/forgot-password/email/{email}")
	public ResponseEntity<Object> forgotPassword(@RequestHeader("API-KEY") String apiKey, @PathVariable String email) {
		return userService.forgotPassword(apiKey, email);
	}

	@GetMapping(value = "/email-verify/userId/{userId}/verifyId/{verifyId}", produces = org.springframework.http.MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<Object> verifyCodeAndActivateUser(@PathVariable("userId") Long userId,
			@PathVariable("verifyId") String verifyId) {
		return userService.verifyCode(userId, verifyId);

	}

	@GetMapping("/all-users")
	public ResponseEntity<Object> getAllUsers(@RequestHeader("API-KEY") String apiKey) {
		return userService.getAllUsers(apiKey);
	}

	@GetMapping("/get-user/{userName}")
	public ResponseEntity<Object> getUserDetailsByUserName(@RequestHeader("API-KEY") String apiKey,
			@PathVariable String userName) {
		return userService.getUserDetails(apiKey, userName);
	}

	@GetMapping("/logout/{userName}")
	public ResponseEntity<Object> userLogout(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken, @PathVariable("userName") String userName) {

		return userService.logout(apiKey, jwtToken, userName);
	}

	@PostMapping(value = "/password-reset")
	public ResponseEntity<Object> passwordReset(@RequestHeader("API-KEY") String apiKey,
			@RequestBody @NotNull UserDto userDto) {
		int updateStatus = userService.passwordReset(apiKey, userDto);
		if (updateStatus > 0) {
			return userUtils.successResponse();
		}
		return userUtils.badResponse();
	}

}
