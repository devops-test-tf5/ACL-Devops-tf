package com.acldigital.unaito.db.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acldigital.unaito.db.IProjectTeamDataService;
import com.acldigital.unaito.service.repository.IProjectTeamRepository;

@Service
public class ProjectTeamServiceImpl implements IProjectTeamDataService{

	@Autowired
	private IProjectTeamRepository projectTeamRepository;
	
	@Override
	public Long checkIfOnboardingAvailable(Long projectId) {
		return projectTeamRepository.checkIfOnboardingAvailable(projectId);
	}

}
