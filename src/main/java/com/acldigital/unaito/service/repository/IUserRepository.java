package com.acldigital.unaito.service.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.acldigital.unaito.service.entity.UserEntity;

@Repository
public interface IUserRepository extends CrudRepository<UserEntity, Long> {

	@Query(value = "SELECT * FROM USERS U WHERE U.USER_NAME = :userName", nativeQuery = true)
	public UserEntity getUserByUserName(String userName);

	/*
	 * @Procedure(procedureName="GET_USER_BY_USERNAME") UserEntity
	 * getUserByUserName(String userName);
	 */

	@Query(value = "SELECT * FROM USERS U WHERE U.USER_ID = :userId", nativeQuery = true)
	public UserEntity getUserDetailsByUserId(Long userId);

	/*
	 * @Procedure(procedureName="GET_USER_BY_USERID") UserEntity
	 * getUserDetailsByUserId(Long userId);
	 */

	@Query(value = "SELECT USER_NAME FROM USERS U WHERE IS_ACTIVE > 0", nativeQuery = true)
	public List<String> checkIfUserNameAlreadyAvailable();

	@Modifying
	@Transactional
	@Query(value = "update USERS u set u.first_name=:firstName,u.last_name=:lastName,u.contact_number=:contactNumber,u.email=:email,u.location=:location where u.user_name=:userName", nativeQuery = true)
	void updateUserDetails(String userName, String firstName, String lastName, Long contactNumber, String email,
			String location);

}
