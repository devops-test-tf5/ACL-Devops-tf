package com.acldigital.unaito.db.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.acldigital.unaito.db.ICustomerDataService;
import com.acldigital.unaito.db.mapper.MapperUtils;
import com.acldigital.unaito.service.customer.CustomerDto;
import com.acldigital.unaito.service.entity.CustomersEntity;
import com.acldigital.unaito.service.repository.ICustomerRepository;
import com.acldigital.unaito.service.user.constants.UserConstants;
import com.acldigital.unaito.service.user.exception.CustomerCreationException;
import com.acldigital.unaito.service.user.exception.CustomerNotFoundException;

@Service
public class CustomerDataServiceImpl implements ICustomerDataService {

	@Autowired
	private ICustomerRepository customerRepository;

	@Autowired
	private MapperUtils mapperUtils;

	@Override
	public CustomerDto createCustomer(CustomerDto customerDto, Long userId) {
		CustomersEntity entity = mapperUtils.convertToCustomerEntity(customerDto);
		entity.setUserId(userId);
		CustomersEntity responseEntity = customerRepository.save(entity);
		if (!ObjectUtils.isEmpty(responseEntity)) {
			return mapperUtils.convertToCustomerDto(responseEntity);
		} else {
			throw new CustomerCreationException("Exception occurred.", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

	}

	@Override
	public CustomerDto getCustomerDetails(String customerName) {
		CustomersEntity entity = customerRepository.getCustomerDetails(customerName);
		if (!ObjectUtils.isEmpty(entity)) {
			return mapperUtils.convertToCustomerDto(entity);
		} else {
			throw new CustomerNotFoundException("Customer not found", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	@Override
	public CustomerDto getCustomerDetails(Long customerId) {
		CustomersEntity custEntity = customerRepository.fetchCustomerDetails(customerId);
		if (!ObjectUtils.isEmpty(custEntity)) {
			return mapperUtils.convertToCustomerDto(custEntity);
		} else {
			throw new CustomerNotFoundException("Customer not found", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

	}

	@Override
	public List<CustomerDto> getAllCustomers() {
		Iterable<CustomersEntity> customersList= customerRepository.getAllCustomers(UserConstants.ACTIVE_STATUS);
		if(!ObjectUtils.isEmpty(customersList)) {
			return mapperUtils.convertToCustomerDtoList(customersList);
		}else {
			throw new CustomerNotFoundException("Customers not found.", HttpStatus.NOT_FOUND.value());
		}
		
		
		
	}

}
