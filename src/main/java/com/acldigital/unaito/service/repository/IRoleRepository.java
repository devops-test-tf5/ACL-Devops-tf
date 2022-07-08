package com.acldigital.unaito.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acldigital.unaito.service.entity.RoleEntity;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {

	@Query(value = "SELECT * FROM ROLES R WHERE R.ROLE_ID=:roleId", nativeQuery = true)
	public RoleEntity getById(@Param("roleId") Long roleId);

	@Query(value = "SELECT ROLE_ID FROM ROLES R WHERE R.ROLE_NAME=:roleName", nativeQuery = true)
	public Long getRoleIdByRoleName(@Param("roleName") String roleName);
	
	@Query(value = "SELECT ROLE_NAME FROM ROLES R WHERE R.ROLE_ID=:roleId", nativeQuery = true)
	public String getRoleNameByRoleId(@Param("roleId") Long roleId);
	
	
}
