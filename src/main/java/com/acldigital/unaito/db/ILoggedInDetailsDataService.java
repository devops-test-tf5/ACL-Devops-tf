package com.acldigital.unaito.db;

import com.acldigital.unaito.service.user.dto.UserLoggedInDetails;

public interface ILoggedInDetailsDataService {

	public UserLoggedInDetails fetchUserLoggedInDetails(Long userId, String token);

	public boolean checkIfValidToken(Long userId, String token);
}
