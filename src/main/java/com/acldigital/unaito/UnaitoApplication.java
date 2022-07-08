package com.acldigital.unaito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class UnaitoApplication {
	public static void main(String[] args) {
		SpringApplication.run(UnaitoApplication.class, args);
	}

}
