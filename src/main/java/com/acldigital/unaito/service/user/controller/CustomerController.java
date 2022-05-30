package com.acldigital.unaito.service.user.controller;

import org.jboss.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unaito/v1/customers")
public class CustomerController {
	Logger logger = Logger.getLogger(CustomerController.class);
	@GetMapping("/welcome")
	public String welcomeCustomer() {
		logger.info("Welcome to unaito project");
		return "Welcome to unaito";
	}
	
	@PostMapping
	public ResponseEntity<Object> editCustomers(){
		return null;
	}
}
