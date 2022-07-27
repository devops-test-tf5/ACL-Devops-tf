package com.acldigital.unaito.service.impl;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.acldigital.unaito.db.ICustomerDataService;
import com.acldigital.unaito.db.IUserDataService;
import com.acldigital.unaito.service.customer.CustomerDto;
import com.acldigital.unaito.service.security.constants.RoleConstantsEnum;
import com.acldigital.unaito.service.service.ICustomerService;
import com.acldigital.unaito.service.user.constants.UserConstants;
import com.acldigital.unaito.service.user.controller.CustomerController;
import com.acldigital.unaito.service.user.dto.CustomerResponse;
import com.acldigital.unaito.service.user.exception.UserNotFoundException;
import com.acldigital.unaito.service.utils.CommonUtils;
import com.acldigital.unaito.service.utils.SecurityUtils;

@Service
public class CustomerServiceImpl implements ICustomerService {

	Logger logger = Logger.getLogger(CustomerController.class);
	
	@Autowired
	private ICustomerDataService customerDataService;

	@Autowired
	private SecurityUtils securityUtils;

	@Autowired
	private IUserDataService userDataService;

	@Autowired
	private CommonUtils commonUtils;

	@Override
	public ResponseEntity<Object> createCustomer(String apiKey, CustomerDto request) {
		securityUtils.validateCustomerApiKey(apiKey);
		Long userId = userDataService.fetchUserDetails(request.getSpocFirstName(), request.getSpocLastName(),
				request.getEmailId(), RoleConstantsEnum.CUSTOMER.getValue().longValue());// get role from
		if (ObjectUtils.isEmpty(userId)) {
			throw new UserNotFoundException("User not found", HttpStatus.NOT_FOUND.value());
		}
		CustomerDto customerDto = customerDataService.createCustomer(request, userId);
		CustomerResponse response = new CustomerResponse(HttpStatus.CREATED.value(), customerDto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@Override
	public List<CustomerDto> getAllCustomers(String apiKey) {
		securityUtils.validateCustomerApiKey(apiKey);
		return customerDataService.getAllCustomers();
	}

	@Override
	public CustomerDto getCustomerById(String apiKey, Long customerId) {
		securityUtils.validateCustomerApiKey(apiKey);
		return customerDataService.getCustomerDetails(customerId);
	}

	@Override
	public CustomerDto editCustomer(String apiKey, String token, CustomerDto request, Long customerId) {
		securityUtils.validateCustomerApiKey(apiKey);
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			return customerDataService.editCustomer(request, customerId);
		}
		return null;
	}

	@Override
	public int deleteCustomer(String apiKey, String token, Long customerId) {
		securityUtils.validateCustomerApiKey(apiKey);
		boolean isTokenValid = commonUtils.validateToken(token);
		if (isTokenValid) {
			return customerDataService.deleteCustomer(customerId);
		}
		//write code to send invalid token as response in all negative cases.
		return UserConstants.INACTIVE_STATUS;
	}

}
