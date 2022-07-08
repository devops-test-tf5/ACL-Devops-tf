package com.acldigital.unaito.service.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.acldigital.unaito.db.IUserDataService;
import com.acldigital.unaito.service.user.dto.UserDto;

@Service
public class UnaitoUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserDataService userDataService;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserDto userProfileDetails = null;
		userProfileDetails = userDataService.getProfileDetailsByUserName(userName);
		return new User(userProfileDetails.getUserName(), userProfileDetails.getPassword(), new ArrayList<>());
	}

}
