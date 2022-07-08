package com.acldigital.unaito.service.user.controller;

import javax.validation.constraints.NotNull;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acldigital.unaito.service.customer.CustomerDto;
import com.acldigital.unaito.service.service.ICustomerService;

@RestController
@RequestMapping("/unaito/v1/customers")
public class CustomerController {
	Logger logger = Logger.getLogger(CustomerController.class);

	@Autowired
	private ICustomerService customerService;

	@GetMapping("/welcome")
	public String welcomeCustomer() {
		logger.info("Welcome to unaito project");
		return "Welcome to unaito";
	}

	@PostMapping("/create")
	public ResponseEntity<Object> createCustomer(@RequestHeader("API-KEY") String apiKey,
			@RequestBody @NotNull CustomerDto request) {
		return customerService.createCustomer(apiKey, request);
	}

	@PostMapping
	public ResponseEntity<Object> editCustomers() {
		return null;
	}
	
	@GetMapping(value = "/get-all-customers")
	public ResponseEntity<Object> getAllCustomers(@RequestHeader("API-KEY") String apiKey){
		customerService.getAllCustomers(apiKey);
		//return customerService.getAllCustomers(apiKey);
		return null;
	}
}
