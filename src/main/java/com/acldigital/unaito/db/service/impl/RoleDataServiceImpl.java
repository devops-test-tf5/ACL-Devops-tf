package com.acldigital.unaito.db.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.acldigital.unaito.db.IRoleDataService;
import com.acldigital.unaito.db.mapper.MapperUtils;
import com.acldigital.unaito.service.entity.RoleEntity;
import com.acldigital.unaito.service.repository.IRoleRepository;
import com.acldigital.unaito.service.user.dto.Roles;

public class RoleDataServiceImpl implements IRoleDataService {

	@Autowired
	private IRoleRepository roleRepository;
	
	@Autowired
	private MapperUtils mapperUtils;
	
	@Override
	public List<Roles> getAllRoles() {
		
		List<RoleEntity> roleEntities=roleRepository.findAll();
		List<Roles> listOfRoles = new ArrayList<>();
		listOfRoles = mapperUtils.convertToRolesList(roleEntities);
		return listOfRoles;
	}

}
