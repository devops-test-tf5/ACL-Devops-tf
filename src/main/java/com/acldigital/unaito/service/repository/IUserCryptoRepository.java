package com.acldigital.unaito.service.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acldigital.unaito.service.entity.UserCryptoEntity;

@Repository
public interface IUserCryptoRepository extends CrudRepository<UserCryptoEntity, Long> {

	@Modifying
	@Transactional
	@Query(value = "update user_crypto_details uc set uc.salt_key=:salt, uc.crypto_algo_name=:cryptoAlgoName where uc.user_id=:userId", nativeQuery = true)
	public void updateNewUserCryptoDetails(@Param("salt") String salt, @Param("cryptoAlgoName") String cryptoAlgoName,
			@Param("userId") Long userId);
}
