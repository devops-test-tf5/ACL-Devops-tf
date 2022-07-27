package com.acldigital.unaito.db;

import java.util.List;

import com.acldigital.unaito.service.customer.CustomerDto;

public interface ICustomerDataService {

	public CustomerDto createCustomer(CustomerDto customerDto, Long userId);

	public CustomerDto getCustomerDetails(String customerName);

	public CustomerDto getCustomerDetails(Long customerId);

	public List<CustomerDto> getAllCustomers();

	public CustomerDto editCustomer(CustomerDto request, Long customerId);

	public int deleteCustomer(Long customerId);
}
