package com.acldigital.unaito.db.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.acldigital.unaito.db.ILoggedInDetailsDataService;
import com.acldigital.unaito.db.mapper.MapperUtils;
import com.acldigital.unaito.service.repository.IUserLoginDetailsRepository;
import com.acldigital.unaito.service.security.constants.SecurityConstantsEnum;
import com.acldigital.unaito.service.user.dto.UserLoggedInDetails;

@Service
public class LoggedInDataServiceImpl implements ILoggedInDetailsDataService {

	@Autowired
	private IUserLoginDetailsRepository loggedInDetailsRepository;

	@Autowired
	private MapperUtils mapperUtils;

	@Override
	public UserLoggedInDetails fetchUserLoggedInDetails(Long userId, String token) {
		return mapperUtils.convertToUserLoginDetailsDto(loggedInDetailsRepository.fetchUserLoggedInDetails(userId,
				token, SecurityConstantsEnum.NEW.getValue()));
	}

	private UserLoggedInDetails getUserLoggedInDetails(Long userId, String token) {
		return mapperUtils.convertToUserLoginDetailsDto(loggedInDetailsRepository.fetchUserLoggedInDetails(userId,
				token));
	}
	
	
	@Override
	public boolean checkIfValidToken(Long userId, String token) {
		UserLoggedInDetails loginDetails = getUserLoggedInDetails(userId, token);
		boolean isTokenInvalid = true;
		if (!ObjectUtils.isEmpty(loginDetails)) {
			if (loginDetails.getJwtType().equals(SecurityConstantsEnum.INVALID.getValue())) {
				return false;
			}
		}
		return isTokenInvalid;
	}

}
