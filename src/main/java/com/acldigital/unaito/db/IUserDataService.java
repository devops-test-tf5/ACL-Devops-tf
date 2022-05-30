package com.acldigital.unaito.db;

import com.acldigital.unaito.service.user.dto.User;
import com.acldigital.unaito.service.user.dto.UserLoggedInDetails;
import com.acldigital.unaito.service.user.dto.UserRequest;

public interface IUserDataService {

	public User registerUser(UserRequest userRequestDto);

	public User getProfileDetailsByUserName(String userName);

	public void updateUserDetails(UserRequest userRequest, User userProfileDetails);

	public boolean checkIfUserNameAlreadyPresent(String userName);

	public UserLoggedInDetails saveUserLoggedInDetails(UserLoggedInDetails userLoggedInDetails) throws Exception;

}
