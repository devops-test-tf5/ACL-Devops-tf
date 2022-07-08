package com.acldigital.unaito.service.user.dto;

public class ItDrivers {

	private String driverName;

	public ItDrivers(String driverName) {
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
		return "ItDrivers [driverName=" + driverName + "]";
	}

}
