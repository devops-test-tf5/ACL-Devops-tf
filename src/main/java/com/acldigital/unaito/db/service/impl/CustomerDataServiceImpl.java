package com.acldigital.unaito.db.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		CustomersEntity custEntity = customerRepository.fetchCustomerDetails(customerId, UserConstants.ACTIVE_STATUS);
		if (!ObjectUtils.isEmpty(custEntity)) {
			return mapperUtils.convertToCustomerDto(custEntity);
		} else {
			throw new CustomerNotFoundException("Customer not found", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

	}

	@Override
	public List<CustomerDto> getAllCustomers() {
		List<CustomerDto> customersDtoList = new ArrayList<>();
		Iterable<CustomersEntity> customersEntityList = customerRepository.getAllCustomers(UserConstants.ACTIVE_STATUS);
		if (!ObjectUtils.isEmpty(customersEntityList)) {
			return mapperUtils.convertToCustomerDtoList(customersEntityList);
		}
		return customersDtoList;
	}

	@Override
	public CustomerDto editCustomer(CustomerDto request,Long customerId) {
		Optional<CustomersEntity> entity = customerRepository.findById(customerId);
		if (entity.isPresent()) {
			CustomersEntity saveEntity = mapperUtils.updateCustomerDetails(request, entity.get());
			CustomersEntity responseEntity = customerRepository.save(saveEntity);
			return mapperUtils.convertToCustomerDto(responseEntity);
		} else {
			throw new CustomerNotFoundException("Customer not found.", HttpStatus.NOT_FOUND.value());
		}

	}

	@Override
	public int deleteCustomer(Long customerId) {
		Optional<CustomersEntity> entity = customerRepository.findById(customerId);
		if(entity.isPresent()) {
			customerRepository.deleteById(customerId);
			return UserConstants.ACTIVE_STATUS;
		}
		//return customer not found exception instead of bad response
		return UserConstants.INACTIVE_STATUS;
	}

}
