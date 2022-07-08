package com.acldigital.unaito.service.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_verification_token")
public class VerificationTokenEntity implements Serializable {

	private static final long serialVersionUID = 2059723750871969956L;

	private static final int EXPIRATION = 60 * 24;

	@Id
	@Column(name = "verify_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long verifyId;

	@Column(name = "token")
	private String token;

	@OneToOne(targetEntity = UserEntity.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "user_id", foreignKey = @ForeignKey(name = "FK_VERIFY_USER"))
	private UserEntity userEntity;

	@Column(name = "expiry_date")
	private Date expiryDate;

	public VerificationTokenEntity() {
		super();
	}

	public VerificationTokenEntity(final String token) {
		super();
		this.token = token;
		this.expiryDate = calculateExpiryDate(EXPIRATION);
	}

	public VerificationTokenEntity(final String token, final UserEntity user) {
		super();
		this.token = token;
		this.userEntity = user;
		this.expiryDate = calculateExpiryDate(EXPIRATION);
	}

	public Long getVerifyId() {
		return verifyId;
	}

	public void setVerifyId(Long verifyId) {
		this.verifyId = verifyId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public void updateToken(final String token) {
		this.token = token;
		this.expiryDate = calculateExpiryDate(EXPIRATION);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getExpiryDate() == null) ? 0 : getExpiryDate().hashCode());
		result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
		result = prime * result + ((getUserEntity() == null) ? 0 : getUserEntity().hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final VerificationTokenEntity other = (VerificationTokenEntity) obj;
		if (getExpiryDate() == null) {
			if (other.getExpiryDate() != null) {
				return false;
			}
		} else if (!getExpiryDate().equals(other.getExpiryDate())) {
			return false;
		}
		if (getToken() == null) {
			if (other.getToken() != null) {
				return false;
			}
		} else if (!getToken().equals(other.getToken())) {
			return false;
		}
		if (getUserEntity() == null) {
			if (other.getUserEntity() != null) {
				return false;
			}
		} else if (!getUserEntity().equals(other.getUserEntity())) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "VerificationTokenEntity [verifyId=" + verifyId + ", token=" + token + ", userEntity=" + userEntity
				+ ", expiryDate=" + expiryDate + "]";
	}

	private Date calculateExpiryDate(int expiryTimeInMinutes) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Timestamp(cal.getTime().getTime()));
		cal.add(Calendar.MINUTE, expiryTimeInMinutes);
		return new Date(cal.getTime().getTime());
	}

}
