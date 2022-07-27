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
import com.acldigital.unaito.service.entity.UserCryptoEntity;
import com.acldigital.unaito.service.entity.UserEntity;
import com.acldigital.unaito.service.entity.UserLoggedInEntity;
import com.acldigital.unaito.service.repository.IRoleRepository;
import com.acldigital.unaito.service.repository.IUserCryptoRepository;
import com.acldigital.unaito.service.repository.IUserLoginDetailsRepository;
import com.acldigital.unaito.service.repository.IUserRepository;
import com.acldigital.unaito.service.user.constants.UserConstants;
import com.acldigital.unaito.service.user.dto.UserCryptoDetails;
import com.acldigital.unaito.service.user.dto.UserDto;
import com.acldigital.unaito.service.user.dto.UserLoggedInDetails;
import com.acldigital.unaito.service.user.dto.UserRegistrationDetails;
import com.acldigital.unaito.service.user.dto.UserRequest;
import com.acldigital.unaito.service.user.exception.UnaitoSQLException;
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
	private IUserLoginDetailsRepository userLoginDetailsRepository;

	@Autowired
	private IUserCryptoRepository userCryptoRepository;

	@Override
	public UserDto registerUser(UserRegistrationDetails userRegistrationDetails) {
		Iterable<RoleEntity> roleEntityIterable = roleRepository.findAll();
		List<RoleEntity> roleEntities = new ArrayList<>();
		roleEntityIterable.forEach(roleEntities::add);
		UserEntity userEntity = null;
		UserCryptoEntity userCryptoEntity = null;
		UserEntity responseEntity = null;
		userEntity = mapperUtils.convertToUserEntity(userRegistrationDetails);
		userEntity.setFirstTimeLogin(true);
		for (RoleEntity entity : roleEntities) {
			if (entity.getRoleName().equalsIgnoreCase(userRegistrationDetails.getRoleName())) {
				userEntity.setRoleId(entity.getRoleId());
			}
		}
		userCryptoEntity = mapperUtils.convertToUserCryptoEntity(userRegistrationDetails.getUserCryptoDetails());
		userCryptoEntity.setUserEntity(userEntity);
		userEntity.setUserCryptoEntity(userCryptoEntity);
		try {
			responseEntity = userRepository.save(userEntity);
		} catch (Exception e) {
			throw new UnaitoSQLException("Username or Email id is already registered.", HttpStatus.BAD_REQUEST.value());
		}

		return mapperUtils.convertToUserDto(responseEntity, userRegistrationDetails.getRoleName());
	}

	@Override
	public UserDto getProfileDetailsByUserName(String userName) {

		UserEntity userEntity = userRepository.getUserByUserName(userName);
		if (ObjectUtils.isEmpty(userEntity)) {
			throw new UserNotFoundException(UserConstants.NOT_FOUND, HttpStatus.NOT_FOUND.value());
		}
		RoleEntity roleEntity = roleRepository.getById(userEntity.getRoleId());

		return new UserDto(userEntity.getUserId(), userEntity.getUserName(), userEntity.getPassword(),
				userEntity.getFirstName(), userEntity.getLastName(), userEntity.getEmail(), roleEntity.getRoleName(),
				userEntity.getContactNumber(), userEntity.getIsActive(), userEntity.getLocation(),
				userEntity.getUserCryptoEntity().getSaltKey(), userEntity.getUserCryptoEntity().getCryptoAlgoName());
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
	public void updateUserDetails(UserRequest userRequest, UserDto userProfileDetails) {
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

	@Override
	public boolean checkIfValidEmail(String email) {
		List<String> emailList = userRepository.getEmailList();
		if (emailList.contains(email)) {
			return true;
		}
		return false;
	}

	@Override
	public UserDto fetchUserByEmail(String email) {
		UserEntity userEntity = null;
		UserDto user = null;
		userEntity = userRepository.getUserByEmail(email);
		if (!ObjectUtils.isEmpty(userEntity)) {
			return mapperUtils.convertToUserDto(userEntity);
		}
		return user;
	}

	@Override
	public void updateNewPassword(String userName, UserCryptoDetails userCryptoDetails) {
		userRepository.updateNewPassword(userName, userCryptoDetails.getEncodedPassword());
	}

	@Override
	public String verifyCode(String code) {
		return userRepository.verifyCode(code);
	}

	/*
	 * @Override public boolean checkIfFirstTimeLogin(Long userId) { Integer
	 * loginCount = userLoginDetailsRepository.checkIfFirstTimeLogin(userId); if
	 * (loginCount == 1) { return true; } return false; }
	 */
	@Override
	public boolean checkIfFirstTimeLogin(Long userId) {
		return userRepository.checkIfFirstTimeLogin(userId);
	}

	@Override
	public void incrementWrongPasswordCount(Long userId) {
		userRepository.incrementWrongPasswordCount(userId);

	}

	@Override
	public Integer retrieveWrongPasswordCount(Long userId) {
		return userRepository.retrieveWrongPasswordCount(userId);
	}

	@Override
	public void activateUser(Long userId) {
		userRepository.activateUser(userId, UserConstants.ACTIVE_STATUS);
	}

	@Override
	public void updateUserCryptoDetails(UserCryptoDetails userCryptoDetails, Long userId) {
		userCryptoRepository.updateNewUserCryptoDetails(userCryptoDetails.getSalt(),
				userCryptoDetails.getCryptoAlgoName(), userId);
	}

	@Override
	public void resetWrongPasswordCountToZero(Long userId) {
		userRepository.resetWrongPasswordCountToZero(UserConstants.DEFAULT_WRONG_PASSWORD_COUNT, userId);

	}

	@Override
	public void inActivateUser(Long userId) {
		userRepository.inActivateUser(UserConstants.INACTIVE_STATUS, userId);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<UserEntity> userEntities = new ArrayList<>();
		List<UserDto> userList = null;
		userEntities = userRepository.getAllActiveUsers(UserConstants.ACTIVE_STATUS);
		if (!ObjectUtils.isEmpty(userEntities)) {
			userList = mapperUtils.convertToUsersList(userEntities);
		}
		return userList;
	}

	@Override
	public void updateUserLoggedInDetails(UserLoggedInDetails userLoggedInDetails) throws Exception {
		UserLoggedInEntity userLoggedInEntity = null;
		if (!ObjectUtils.isEmpty(userLoggedInDetails)) {
			userLoggedInEntity = mapperUtils.convertToLoginDetailsEntity(userLoggedInDetails);
			if (!ObjectUtils.isEmpty(userLoggedInEntity)) {
				userLoginDetailsRepository.updateUserLoggedOutDetails(userLoggedInEntity.getJwtType(),
						userLoggedInEntity.getLoggedIn(), userLoggedInEntity.getLoggedOut(),
						userLoggedInEntity.getLoggedOutTime(), userLoggedInEntity.getUserId(),
						userLoggedInEntity.getPreviousJwt(), userLoggedInEntity.getLoginId());
			}
		}

	}

	@Override
	public Long fetchUserDetails(String customerFirstName, String customerLastName, String email, Long roleId) {
		return userRepository.fetchUserDetails(customerFirstName, customerLastName, email, roleId);
	}

	@Override
	public int updateUserPassword(UserDto userDto) {
		return userRepository.updateUserPassword(userDto.getUserName(), userDto.getPassword(),userDto.isFirstTimeLogin());
	}

}
