package com.acldigital.unaito.service.repository;

import java.time.Instant;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acldigital.unaito.service.entity.UserLoggedInEntity;

@Repository
public interface IUserLoginDetailsRepository extends CrudRepository<UserLoggedInEntity, Long> {

	@Query(value = "select count(user_id) from user_login_details where user_id=:userId", nativeQuery = true)
	public Integer checkIfFirstTimeLogin(@Param("userId") Long userId);

	@Modifying
	@Transactional
	@Query(value = "update user_login_details uld set uld.jwt_expiry_time=:expiryTime,uld.is_logged_out=:isLoggedOut,"
			+ "uld.logged_out_time=:loggedOutTime", nativeQuery = true)
	public void updateJwtExpirationTime(@Param("isLoggedOut") String isLoggedOut,
			@Param("expiryTime") Instant expiryTime, @Param("loggedOutTime") Instant loggedOutTime);

	@Query(value = "select * from user_login_details uld where uld.user_id=:userId and uld.jwt=:token and uld.jwt_type=:jwtType", nativeQuery = true)
	public UserLoggedInEntity fetchUserLoggedInDetails(@Param("userId") Long userId, @Param("token") String token,
			@Param("jwtType") String jwtType);
	
	@Query(value = "select * from user_login_details uld where uld.user_id=:userId and uld.jwt=:token", nativeQuery = true)
	public UserLoggedInEntity fetchUserLoggedInDetails(@Param("userId") Long userId, @Param("token") String token);

	@Modifying
	@Transactional
	@Query(value = "update user_login_details uld set uld.jwt_type=:jwtType,uld.is_logged_in=:loggedIn,uld.is_logged_out=:loggedOut,uld.logged_out_time=:loggedOutTime where uld.user_id=:userId and uld.jwt=:previousJwtToken and uld.login_id=:loginId", nativeQuery = true)
	public void updateUserLoggedOutDetails(@Param("jwtType") String jwtType, @Param("loggedIn") char loggedIn,
			@Param("loggedOut") char loggedOut, @Param("loggedOutTime") Instant loggedOutTime,
			@Param("userId") Long userId, @Param("previousJwtToken") String previousJwtToken,
			@Param("loginId") Long loginId);
}
