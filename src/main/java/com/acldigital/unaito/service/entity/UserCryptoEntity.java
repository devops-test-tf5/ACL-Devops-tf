package com.acldigital.unaito.service.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_CRYPTO_DETAILS")
public class UserCryptoEntity implements Serializable {

	private static final long serialVersionUID = 8041848164970351339L;

	@Id
	@Column(name = "crypto_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cryptoId;

	@Column(name = "salt_key")
	private String saltKey;

	@Column(name = "crypto_algo_name")
	private String cryptoAlgoName;

	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private UserEntity userEntity;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "updated_date")
	private Date updatedDate;

	public UserCryptoEntity(Long cryptoId, String saltKey, String cryptoAlgoName, Date createdDate, Date updatedDate) {
		super();
		this.cryptoId = cryptoId;
		this.saltKey = saltKey;
		this.cryptoAlgoName = cryptoAlgoName;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public UserCryptoEntity() {

	}

	public UserCryptoEntity(String saltKey, String cryptoAlgoName) {
		super();
		this.saltKey = saltKey;
		this.cryptoAlgoName = cryptoAlgoName;
	}

	public Long getCryptoId() {
		return cryptoId;
	}

	public void setCryptoId(Long cryptoId) {
		this.cryptoId = cryptoId;
	}

	public String getSaltKey() {
		return saltKey;
	}

	public void setSaltKey(String saltKey) {
		this.saltKey = saltKey;
	}

	public String getCryptoAlgoName() {
		return cryptoAlgoName;
	}

	public void setCryptoAlgoName(String cryptoAlgoName) {
		this.cryptoAlgoName = cryptoAlgoName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Override
	public String toString() {
		return "UserCryptoEntity [cryptoId=" + cryptoId + ", saltKey=" + saltKey + ", cryptoAlgoName=" + cryptoAlgoName
				+ ", " + "userEntity=" + userEntity + "," + " createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + "]";
	}

}
