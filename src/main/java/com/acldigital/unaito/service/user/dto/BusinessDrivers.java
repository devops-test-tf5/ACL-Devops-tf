package com.acldigital.unaito.service.user.dto;

public class BusinessDrivers {

	private String driverName;

	public BusinessDrivers(String driverName) {
		super();
		this.driverName = driverName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	@Override
	public String toString() {
		return "BusinessDrivers [driverName=" + driverName + "]";
	}

}
