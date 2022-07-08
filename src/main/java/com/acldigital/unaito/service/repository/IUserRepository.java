package com.acldigital.unaito.service.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acldigital.unaito.service.entity.UserEntity;

@Repository
public interface IUserRepository extends CrudRepository<UserEntity, Long> {

	@Query(value = "SELECT * FROM USERS U WHERE U.USER_NAME = :userName", nativeQuery = true)
	public UserEntity getUserByUserName(@Param("userName") String userName);

	/*
	 * @Procedure(procedureName="GET_USER_BY_USERNAME") UserEntity
	 * getUserByUserName(String userName);
	 */

	@Query(value = "SELECT * FROM USERS U WHERE U.USER_ID = :userId", nativeQuery = true)
	public UserEntity getUserDetailsByUserId(@Param("userId") Long userId);

	/*
	 * @Procedure(procedureName="GET_USER_BY_USERID") UserEntity
	 * getUserDetailsByUserId(Long userId);
	 */

	@Query(value = "SELECT USER_NAME FROM USERS U WHERE IS_ACTIVE > 0", nativeQuery = true)
	public List<String> checkIfUserNameAlreadyAvailable();

	@Modifying
	@Transactional
	@Query(value = "update USERS u set u.first_name=:firstName,u.last_name=:lastName,u.contact_number=:contactNumber,u.email=:email,u.location=:location where u.user_name=:userName", nativeQuery = true)
	void updateUserDetails(@Param("userName") String userName, @Param("firstName") String firstName,
			@Param("lastName") String lastName, @Param("contactNumber") Long contactNumber,
			@Param("email") String email, @Param("location") String location);

	@Query(value = "select email from users u", nativeQuery = true)
	public List<String> getEmailList();

	@Query(value = "select * from users u where u.email=:email", nativeQuery = true)
	public UserEntity getUserByEmail(@Param("email") String email);

	@Modifying
	@Transactional
	@Query(value = "update users u set u.password=:password where u.user_name=:userName", nativeQuery = true)
	public void updateNewPassword(@Param("userName") String userName, @Param("password") String password);

	@Query(value = "select u.user_name from users u where u.verfication_code=:code", nativeQuery = true)
	public String verifyCode(@Param("code") String code);

	@Modifying
	@Transactional
	@Query(value = "update users u set u.wrong_password_count = u.wrong_password_count+1 where u.user_id=:userId", nativeQuery = true)
	public void incrementWrongPasswordCount(@Param("userId") Long userId);

	@Query(value = "select wrong_password_count from users u where u.user_id=:userId", nativeQuery = true)
	public Integer retrieveWrongPasswordCount(@Param("userId") Long userId);

	@Modifying
	@Transactional
	@Query(value = "update users u set u.is_active=:status where u.user_id=:userId", nativeQuery = true)
	public void activateUser(@Param("userId") Long userId, @Param("status") Integer status);

	@Modifying
	@Transactional
	@Query(value = "update users u set u.wrong_password_count=:defaultCount where u.user_id=:userId", nativeQuery = true)
	public void resetWrongPasswordCountToZero(@Param("defaultCount") int defaultCount, @Param("userId") Long userId);

	@Modifying
	@Transactional
	@Query(value = "update users u set u.is_active=:inActive where u.user_id=:userId", nativeQuery = true)
	public void inActivateUser(@Param("inActive") int inActive, @Param("userId") Long userId);

	@Query(value = "select * from users u where u.is_active=:active", nativeQuery = true)
	public List<UserEntity> getAllActiveUsers(@Param("active") int active);

	@Query(value = "select u.user_id from users u where u.first_name=:customerFirstName and u.last_name=:customerLastName and u.email=:email and u.role_id=:roleId", nativeQuery = true)
	public Long fetchUserDetails(@Param("customerFirstName") String customerFirstName,
			@Param("customerLastName") String customerLastName, @Param("email") String email,
			@Param("roleId") Long roleId);
}
