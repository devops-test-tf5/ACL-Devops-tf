package com.acldigital.unaito.service.user.controller;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.ObjectUtils;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acldigital.unaito.service.customer.CustomerDto;
import com.acldigital.unaito.service.service.ICustomerService;
import com.acldigital.unaito.service.user.dto.CustomerResponse;
import com.acldigital.unaito.service.utils.CommonUtils;
import com.acldigital.unaito.service.utils.UserUtils;

@RestController
@RequestMapping("/unaito/v1/customers")
public class CustomerController {
	Logger logger = Logger.getLogger(CustomerController.class);

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private UserUtils userUtils;

	@PostMapping("/create")
	public ResponseEntity<Object> createCustomer(@RequestHeader("API-KEY") String apiKey,
			@RequestBody @NotNull CustomerDto request) {
		return customerService.createCustomer(apiKey, request);
	}

	@PutMapping(value = "/edit-customer/{customerId}")
	public ResponseEntity<CustomerResponse> editCustomers(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken, @RequestBody @NotNull CustomerDto request,
			@PathVariable("customerId") Long customerId) {
		logger.info(String.format("BEGIN::/edit-customer PUT %s", request.getEmailId()));
		String token = CommonUtils.resolveToken(jwtToken);
		CustomerDto response = null;
		if (!ObjectUtils.isEmpty(request)) {
			response = customerService.editCustomer(apiKey, token, request, customerId);
		}
		ResponseEntity<CustomerResponse> editCustomerResponse = new ResponseEntity<>(
				new CustomerResponse(HttpStatus.OK.value(), response), HttpStatus.OK);
		logger.info(String.format("RETURN::/edit-customer PUT %s", HttpStatus.OK.value()));
		return editCustomerResponse;
	}

	@GetMapping(value = "/get-all-customers")
	public ResponseEntity<Object> getAllCustomers(@RequestHeader("API-KEY") String apiKey) {
		logger.info(String.format("BEGIN::/get-all-customers GET %s","Get all customers"));
		logger.info(String.format("RETURN::/get-all-customers GET %s", HttpStatus.OK.value()));
		return new ResponseEntity<>(new CustomerResponse(org.springframework.http.HttpStatus.OK.value(),
				customerService.getAllCustomers(apiKey)), org.springframework.http.HttpStatus.OK);
	}

	@GetMapping(value = "/{customerId}")
	public ResponseEntity<Object> getCustomerById(@RequestHeader("API-KEY") String apiKey,
			@PathVariable("customerId") Long customerId) {
		logger.info(String.format("BEGIN::/{customerId} GET %s", customerId));
		logger.info(String.format("RETURN::/{customerId} GET %s", HttpStatus.OK.value()));
		return new ResponseEntity<>(new CustomerResponse(org.springframework.http.HttpStatus.OK.value(),
				customerService.getCustomerById(apiKey, customerId)), org.springframework.http.HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete-customer/{customerId}")
	public ResponseEntity<Object> deleteCustomer(@RequestHeader("API-KEY") String apiKey,
			@RequestHeader("Authorization") String jwtToken,
			@PathVariable("customerId") @NotNull @NotEmpty Long customerId) {
		logger.info(String.format("BEGIN::/delete-customer/{customerId} DELETE %s", customerId));
		int responseStatus = 0;
		String token = CommonUtils.resolveToken(jwtToken);
		responseStatus = customerService.deleteCustomer(apiKey, token, customerId);
		logger.info(String.format("RETURN::/delete-customer/{customerId} DELETE %s", responseStatus));
		return (responseStatus != 0) && (responseStatus > 0) ? userUtils.successResponse()
				: userUtils.customerNotFoundResponse();
	}
}
