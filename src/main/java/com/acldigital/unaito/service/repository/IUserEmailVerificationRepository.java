package com.acldigital.unaito.service.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acldigital.unaito.service.entity.UserEmailVerificationEntity;

@Repository
public interface IUserEmailVerificationRepository extends JpaRepository<UserEmailVerificationEntity, Long> {

	@Query(value = "select * from user_email_verification uev where uev.user_id=:userId and "
			+ "uev.sent_to_email_address=:email and uev.status_id=:statusId", nativeQuery = true)
	public UserEmailVerificationEntity fetchVerificationDetails(@Param("userId") Long userId,
			@Param("email") String email, @Param("statusId") Long statusId);

	@Modifying
	@Transactional
	@Query(value = "update user_email_verification uev set uev.status_id=:statusId where uev.user_id=:userId and "
			+ "uev.verification_code=:verifyCode", nativeQuery = true)
	public int activateAccount(@Param("statusId") Long statusId, @Param("userId") Long userId,
			@Param("verifyCode") String verifyCode);
}
