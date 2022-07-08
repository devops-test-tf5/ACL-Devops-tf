package com.acldigital.unaito.service.user.dto;

import java.io.Serializable;
import java.util.List;

public class Drivers implements Serializable {

	private static final long serialVersionUID = 243276472878115769L;

	private List<BusinessDrivers> businessDrivers;

	private List<ItDrivers> itDrivers;

	public Drivers(List<BusinessDrivers> businessDrivers, List<ItDrivers> itDrivers) {
		super();
		this.businessDrivers = businessDrivers;
		this.itDrivers = itDrivers;
	}

	public List<BusinessDrivers> getBusinessDrivers() {
		return businessDrivers;
	}

	public void setBusinessDrivers(List<BusinessDrivers> businessDrivers) {
		this.businessDrivers = businessDrivers;
	}

	public List<ItDrivers> getItDrivers() {
		return itDrivers;
	}

	public void setItDrivers(List<ItDrivers> itDrivers) {
		this.itDrivers = itDrivers;
	}

	@Override
	public String toString() {
		return "Drivers [businessDrivers=" + businessDrivers + ", itDrivers=" + itDrivers + "]";
	}

}
