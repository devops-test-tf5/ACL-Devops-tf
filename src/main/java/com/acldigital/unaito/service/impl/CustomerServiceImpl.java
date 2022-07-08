package com.acldigital.unaito.service.impl;

import java.util.List;

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
import com.acldigital.unaito.service.user.dto.CustomerResponse;
import com.acldigital.unaito.service.user.exception.UserNotFoundException;
import com.acldigital.unaito.service.utils.SecurityUtils;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDataService customerDataService;

	@Autowired
	private SecurityUtils securityUtils;

	@Autowired
	private IUserDataService userDataService;

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

}
