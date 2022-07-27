package com.acldigital.unaito.service.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.acldigital.unaito.db.IUserDataService;
import com.acldigital.unaito.service.user.dto.UserDto;
import com.acldigital.unaito.service.user.exception.UserNotFoundException;

@Service
public class UnaitoUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserDataService userDataService;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserDto userProfileDetails = null;
		userProfileDetails = userDataService.getProfileDetailsByUserName(userName);
		if (!ObjectUtils.isEmpty(userProfileDetails)) {
			return new User(userProfileDetails.getUserName(), userProfileDetails.getPassword(), new ArrayList<>());
		} else {
			throw new UserNotFoundException("User not found", org.springframework.http.HttpStatus.NOT_FOUND.value());
		}
	}
}
