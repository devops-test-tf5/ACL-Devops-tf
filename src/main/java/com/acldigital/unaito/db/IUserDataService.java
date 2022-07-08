package com.acldigital.unaito.db;

import java.util.List;

import com.acldigital.unaito.service.user.dto.UserDto;
import com.acldigital.unaito.service.user.dto.UserCryptoDetails;
import com.acldigital.unaito.service.user.dto.UserLoggedInDetails;
import com.acldigital.unaito.service.user.dto.UserRegistrationDetails;
import com.acldigital.unaito.service.user.dto.UserRequest;

public interface IUserDataService {

	public UserDto registerUser(UserRegistrationDetails userRegistrationRequest);

	public UserDto getProfileDetailsByUserName(String userName);

	public void updateUserDetails(UserRequest userRequest, UserDto userProfileDetails);

	public boolean checkIfUserNameAlreadyPresent(String userName);

	public UserLoggedInDetails saveUserLoggedInDetails(UserLoggedInDetails userLoggedInDetails) throws Exception;

	public boolean checkIfValidEmail(String email);

	public UserDto fetchUserByEmail(String email);

	public void updateNewPassword(String userName, UserCryptoDetails userCryptoDetails);

	public String verifyCode(String code);

	public boolean checkIfFirstTimeLogin(Long userId);

	public void incrementWrongPasswordCount(Long userId);

	public Integer retrieveWrongPasswordCount(Long userId);

	public void activateUser(Long userId);

	public void updateUserCryptoDetails(UserCryptoDetails userCryptoDetails, Long userId);

	public void resetWrongPasswordCountToZero(Long userId);

	public void inActivateUser(Long userId);

	public List<UserDto> getAllUsers();

	public void updateUserLoggedInDetails(UserLoggedInDetails userLoggedInDetails) throws Exception;

	public Long fetchUserDetails(String customerFirstName, String customerLastName, String email, Long roleId);
}
