package com.acldigital.unaito.service.impl;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.acldigital.unaito.db.ICommunicationTemplateDataService;
import com.acldigital.unaito.db.ILoggedInDetailsDataService;
import com.acldigital.unaito.db.IUserDataService;
import com.acldigital.unaito.db.IUserEmailVerificationDataService;
import com.acldigital.unaito.service.encoder.UnaitoPasswordEncoder;
import com.acldigital.unaito.service.event.OnUserRegistrationCompleteEvent;
import com.acldigital.unaito.service.mail.IMailService;
import com.acldigital.unaito.service.security.constants.CommunicationTemplateTypeEnum;
import com.acldigital.unaito.service.security.constants.SecurityConstantsEnum;
import com.acldigital.unaito.service.service.IUserService;
import com.acldigital.unaito.service.user.constants.ConfigProperties;
import com.acldigital.unaito.service.user.constants.UserConstants;
import com.acldigital.unaito.service.user.dto.AuthorizationRequest;
import com.acldigital.unaito.service.user.dto.CommunicationTemplateDetails;
import com.acldigital.unaito.service.user.dto.JwtLoggedInDetails;
import com.acldigital.unaito.service.user.dto.JwtToken;
import com.acldigital.unaito.service.user.dto.UserCryptoDetails;
import com.acldigital.unaito.service.user.dto.UserDto;
import com.acldigital.unaito.service.user.dto.UserLoggedInDetails;
import com.acldigital.unaito.service.user.dto.UserRegistrationDetails;
import com.acldigital.unaito.service.user.dto.UserRequest;
import com.acldigital.unaito.service.user.dto.UserResponse;
import com.acldigital.unaito.service.user.exception.InvalidJwtTokenException;
import com.acldigital.unaito.service.user.exception.InvalidOrExpiredVerificationLinkException;
import com.acldigital.unaito.service.user.exception.TokenExpiredException;
import com.acldigital.unaito.service.user.exception.UserLoggedInException;
import com.acldigital.unaito.service.user.exception.UserNotFoundException;
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
	private SecurityUtils securityUtils;

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private UnaitoPasswordEncoder unaitoPasswordEncoder;

	@Autowired
	private ConfigProperties configProperties;

	@Autowired
	private IMailService mailService;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@Autowired
	private IUserEmailVerificationDataService emailVerificationDataService;

	@Autowired
	private ILoggedInDetailsDataService loggedInDetailsDataService;

	@Autowired
	private ICommunicationTemplateDataService commTemplateDataService;

	@Override
	public ResponseEntity<Object> createUser(String apiKey, UserRegistrationDetails userRegistrationRequest) {
		securityUtils.validateApiKey(apiKey);
		// write code to validate user registration details
		userUtils.validateUserRegistrationDetails(userRegistrationRequest);
		String newPassword = userUtils.generateNewPassword(UserConstants.RANDOM_STRING_LENGTH_TEN);
		UserRegistrationDetails encodedUserRegistrationDetails = getEncodedUserRegistrationDetails(
				userRegistrationRequest, newPassword);
		encodedUserRegistrationDetails
				.setPassword(encodedUserRegistrationDetails.getUserCryptoDetails().getEncodedPassword());

		StringBuilder textStrBuffer = new StringBuilder();
		textStrBuffer.append(UserConstants.LOGIN_PASSWORD + " : " + newPassword);
		mailService.sendNewPassword(userRegistrationRequest.getEmail(), UserConstants.LOGIN_PASSWORD,
				textStrBuffer.toString());
		UserDto user = userDataService.registerUser(encodedUserRegistrationDetails);
		eventPublisher
				.publishEvent(new OnUserRegistrationCompleteEvent(encodedUserRegistrationDetails, user.getUserId()));
		UserResponse resp = new UserResponse(HttpStatus.CREATED.value(), user);
		return new ResponseEntity<>(resp, org.springframework.http.HttpStatus.CREATED);
	}

	private UserRegistrationDetails getEncodedUserRegistrationDetails(UserRegistrationDetails userRegistrationRequest,
			String newPassword) {
		return new UserRegistrationDetails(userRegistrationRequest.getUserName(), userRegistrationRequest.getPassword(),
				userRegistrationRequest.getFirstName(), userRegistrationRequest.getLastName(),
				userRegistrationRequest.getEmail(), userRegistrationRequest.getContactNumber(),
				userRegistrationRequest.getLocation(), userRegistrationRequest.getRoleName(),
				new UserCryptoDetails(unaitoPasswordEncoder.encoderPassword(newPassword),
						unaitoPasswordEncoder.getSalt(), unaitoPasswordEncoder.getEncoder().getValue()),
				UserConstants.MAX_WRONG_PASSWORD_COUNT, UserConstants.DEFAULT_WRONG_PASSWORD_COUNT);
	}

	private UserCryptoDetails getEncodedPassword(String newPassword) {
		return new UserCryptoDetails(unaitoPasswordEncoder.encoderPassword(newPassword),
				unaitoPasswordEncoder.getSalt(), unaitoPasswordEncoder.getEncoder().getValue());
	}

	@Override
	public ResponseEntity<Object> userSignIn(String apiKey, AuthorizationRequest request) {
		UserDto userProfileDetails = null;
		securityUtils.validateApiKey(apiKey);
		userProfileDetails = userDataService.getProfileDetailsByUserName(request.getUserName());
		UserRequest userRequest = new UserRequest();
		userRequest.setUserName(request.getUserName());
		userRequest.setPassword(request.getPassword());
		userUtils.checkIfValidUser(userRequest, userProfileDetails);
		userDataService.resetWrongPasswordCountToZero(userProfileDetails.getUserId());
		JwtLoggedInDetails loggedInDetails = jwtUtils.generateToken(request.getUserName());
		try {
			userDataService
					.saveUserLoggedInDetails(getUserLoggedInDetails(userProfileDetails.getUserId(), loggedInDetails));
		} catch (UserLoggedInException ue) {
			throw new UserLoggedInException("Exception occured", HttpStatus.INTERNAL_SERVER_ERROR.value());
		} catch (Exception e) {
			e.printStackTrace();
		}
		loggedInDetails.setFirstTimeLogin(userUtils.checkIfFirstTimeLogin(userProfileDetails.getUserId()));
		return userUtils.signInResponse(HttpStatus.OK.value(), loggedInDetails);
	}

	private UserLoggedInDetails getUserLoggedInDetails(Long userId, JwtLoggedInDetails loggedInDetails) {
		Instant loggedInTime = Instant.now();
		UserLoggedInDetails details = new UserLoggedInDetails();
		details.setJwt(loggedInDetails.getJwt());
		details.setJwtCreatedTime(loggedInDetails.getJwtCreatedTime());
		details.setJwtType(loggedInDetails.getJwtType());
		details.setLoggedIn(UserConstants.YES);
		details.setLoggedInTime(loggedInTime);
		details.setUserId(userId);
		details.setJwtExpiryTime(loggedInDetails.getJwtExpiryTime());
		details.setJwtCreatedTime(loggedInDetails.getJwtCreatedTime());
		details.setSessionId(loggedInDetails.getSessionId());
		return details;
	}

	private UserLoggedInDetails updateUserTokenDetails(Long userId, UserLoggedInDetails loggedInDetails,
			String previousToken) {
		UserLoggedInDetails details = new UserLoggedInDetails();
		details.setJwtType(SecurityConstantsEnum.INVALID.getValue());
		details.setLoggedIn(UserConstants.NO);
		details.setLoggedOut(UserConstants.YES);
		details.setLoggedOutTime(Instant.now());
		details.setUserId(userId);
		details.setPreviousJwt(previousToken);
		details.setLoginId(loggedInDetails.getLoginId());
		return details;
	}

	@Override
	public ResponseEntity<Object> editUser(String apiKey, String jwtToken, UserRequest request) {
		UserDto userProfileDetails = null;
		securityUtils.validateApiKey(apiKey);
		boolean isValidToken = checkIfValidToken("Bearer " + jwtToken, request.getUserName());
		if (isValidToken) {
			validateJwtToken(jwtToken, request.getUserName());
			userProfileDetails = userDataService.getProfileDetailsByUserName(request.getUserName());
			if (!ObjectUtils.isEmpty(userProfileDetails)) {
				// validate the user entered data, especially duplicate mail id
				userDataService.updateUserDetails(request, userProfileDetails);
				return userUtils.successResponse();
			} else {
				// return or handle exception like No matching user found.
				throw new UserNotFoundException("User not found", HttpStatus.NOT_FOUND.value());
			}
		} else {
			throw new InvalidJwtTokenException("Invalid token", HttpStatus.FORBIDDEN.value());
		}

	}

	@Override
	public ResponseEntity<Object> deleteUser(String apiKey, String jwtToken, String userName) {
		UserDto userProfileDetails = null;
		securityUtils.validateApiKey(apiKey);
		// write code to check if user is admin and then allow him to delete the user
		boolean isValidToken = checkIfValidToken("Bearer " + jwtToken, userName);
		if (isValidToken) {
			validateJwtToken(jwtToken, userName);
			userProfileDetails = userDataService.getProfileDetailsByUserName(userName);
			userUtils.checkIfValidUserByUserName(userName, userProfileDetails);
			// after inactivating the user, add is_deleted flag as true.
			userDataService.inActivateUser(userProfileDetails.getUserId());
			return userUtils.successResponse();
		} else {
			throw new InvalidJwtTokenException("Invalid token", HttpStatus.FORBIDDEN.value());
		}
	}

	private void validateJwtToken(String jwtToken, String userName) {
		JwtToken tokenDetails = new JwtToken(jwtToken, configProperties.getUserServiceSecretKey());
		tokenDetails.validateUser(userName);
		boolean isTokenExpired = jwtUtils.isTokenExpired(jwtToken);
		if (isTokenExpired) {
			throw new TokenExpiredException("Token expired", HttpStatus.UNAUTHORIZED.value());
		}

	}

	@Override
	public ResponseEntity<Object> forgotPassword(String apiKey, String email) {
		securityUtils.validateApiKey(apiKey);
		UserDto user = userDataService.fetchUserByEmail(email);
		if (!ObjectUtils.isEmpty(user)) {
			String newPassword = userUtils.generateNewPassword(UserConstants.RANDOM_STRING_LENGTH_TEN);
			UserCryptoDetails userCryptoDetails = getEncodedPassword(newPassword);
			userDataService.updateNewPassword(user.getUserName(), userCryptoDetails);
			userDataService.updateUserCryptoDetails(userCryptoDetails, user.getUserId());
			mailService.sendNewPassword(email, UserConstants.NEWLY_GENERATED_PASSWORD, newPassword);
		} else {
			UserResponse userResponse = new UserResponse();
			userResponse.setResponseCode(HttpStatus.NOT_FOUND.value());
			userResponse.setResponseObject(UserConstants.NO_EMAIL_ID);
			return new ResponseEntity<>(userResponse, HttpStatus.BAD_REQUEST);
		}
		return userUtils.successResponse();
	}

	@Override
	public ResponseEntity<Object> verifyCode(Long userId, String verifyCode) {
		int verifyCount = emailVerificationDataService.verifyCode(userId, verifyCode);
		if (verifyCount > 0) {
			userDataService.activateUser(userId);
			CommunicationTemplateDetails templateDetails = commTemplateDataService
					.getEmailTemplateDetails(CommunicationTemplateTypeEnum.VERIFICATION_RESPONSE);
			return new ResponseEntity<>(templateDetails.getTemplateBody(), HttpStatus.OK);
		} else {
			throw new InvalidOrExpiredVerificationLinkException("invalid", HttpStatus.FORBIDDEN.value());
		}
	}

	@Override
	public ResponseEntity<Object> getAllUsers(String apiKey) {
		securityUtils.validateApiKey(apiKey);
		// check if token parameter is required.
		// get the username details from Userdetails object . compare if its token is
		// valid .
		// then retrieve data from db and send response.
		UserResponse resp = new UserResponse();
		resp.setResponseCode(HttpStatus.OK.value());
		List<UserDto> listOfUsers = null;
		listOfUsers = userDataService.getAllUsers();
		if (!ObjectUtils.isEmpty(listOfUsers)) {
			resp.setResponseObject(listOfUsers);
		} else
			resp.setResponseObject("");

		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getUserDetails(String apiKey, String userName) {
		securityUtils.validateApiKey(apiKey);
		UserResponse resp = new UserResponse();
		resp.setResponseCode(HttpStatus.OK.value());
		UserDto user = userDataService.getProfileDetailsByUserName(userName);
		if (!ObjectUtils.isEmpty(user)) {
			resp.setResponseObject(user);
		} else
			resp.setResponseObject("");
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> logout(String apiKey, String token, String userName) {
		UserDto userProfileDetails = null;
		securityUtils.validateApiKey(apiKey);
		userProfileDetails = userDataService.getProfileDetailsByUserName(userName);
		UserLoggedInDetails loggedInDetails = loggedInDetailsDataService
				.fetchUserLoggedInDetails(userProfileDetails.getUserId(), token);
		try {
			userDataService.updateUserLoggedInDetails(
					updateUserTokenDetails(userProfileDetails.getUserId(), loggedInDetails, token));
		} catch (UserLoggedInException ue) {
			throw new UserLoggedInException("Exception occured", HttpStatus.INTERNAL_SERVER_ERROR.value());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userUtils.logoutResponse();
	}

	private boolean checkIfValidToken(String token, String userName) {
		UserDto profileDetails = userDataService.getProfileDetailsByUserName(userName);
		return loggedInDetailsDataService.checkIfValidToken(profileDetails.getUserId(), token);

	}

	@Override
	public int passwordReset(String apiKey, UserDto userDto) {
		securityUtils.validateApiKey(apiKey);
		UserCryptoDetails userCryptoDetails = new UserCryptoDetails(
				unaitoPasswordEncoder.encoderPassword(userDto.getPassword()), unaitoPasswordEncoder.getSalt(),
				unaitoPasswordEncoder.getEncoder().getValue());
		UserDto userProfile = userDataService.getProfileDetailsByUserName(userDto.getUserName());
		userDto.setPassword(userCryptoDetails.getEncodedPassword());
		userDto.setFirstTimeLogin(false);
		userDataService.updateUserCryptoDetails(userCryptoDetails, userProfile.getUserId());
		return userDataService.updateUserPassword(userDto);
	}

}