package com.acldigital.unaito.service.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.acldigital.unaito.service.customer.CustomerDto;

public interface ICustomerService {

	public ResponseEntity<Object> createCustomer(String apiKey, CustomerDto request);

	public List<CustomerDto> getAllCustomers(String apiKey);

	public CustomerDto getCustomerById(String apiKey, Long customerId);

	public CustomerDto editCustomer(String apiKey, String token, CustomerDto request, Long customerId);

	public int deleteCustomer(String apiKey, String token, Long customerId);
}
