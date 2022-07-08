package com.acldigital.unaito.service.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.acldigital.unaito.service.customer.CustomerDto;

public interface ICustomerService {

	public ResponseEntity<Object> createCustomer(String apiKey, CustomerDto request);
	
	public List<CustomerDto> getAllCustomers(String apiKey);
}
