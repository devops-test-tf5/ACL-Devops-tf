package com.acldigital.unaito.service.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 2318243786277056274L;

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(name = "role_id")
	private Long roleId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "is_active")
	private Integer isActive;

	@Column(name = "contact_number")
	private Long contactNumber;

	@Column(name = "location")
	private String location;

	@OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL)
	private UserCryptoEntity userCryptoEntity;

	@Column(name = "max_wrong_password_count")
	private Integer maxWrongPasswordCount;

	@Column(name = "wrong_password_count")
	private Integer wrongPasswordCount;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_date")
	private Date updatedDate;

	public UserEntity(Long roleId, String userName, String firstName, String lastName, String password, String email,
			Integer isActive, Long contactNumber, String location) {
		super();
		this.roleId = roleId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.isActive = isActive;
		this.contactNumber = contactNumber;
		this.location = location;
	}

	public UserEntity(String userName, String firstName, String lastName, String password, String email,
			Integer isActive, Long contactNumber, String location, Integer maxWrongPasswordCount,
			Integer wrongPasswordCount) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.isActive = isActive;
		this.contactNumber = contactNumber;
		this.location = location;
		this.maxWrongPasswordCount = maxWrongPasswordCount;
		this.wrongPasswordCount = wrongPasswordCount;
	}
	
	public UserEntity(String userName, String firstName, String lastName, String password, String email,
			Integer isActive, Long contactNumber, String location) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.isActive = isActive;
		this.contactNumber = contactNumber;
		this.location = location;
	}

	public UserEntity(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public UserEntity(Long roleId, String firstName, String lastName, String password, String email, Integer isActive,
			Long contactNumber, String location) {
		super();
		this.roleId = roleId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.isActive = isActive;
		this.contactNumber = contactNumber;
		this.location = location;
	}

	public UserEntity(String userName) {
		super();
		this.userName = userName;
	}

	public UserEntity() {

	}

	public Long getUserId() {
		return userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setActive(Integer isActive) {
		this.isActive = isActive;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public UserCryptoEntity getUserCryptoEntity() {
		return userCryptoEntity;
	}

	public void setUserCryptoEntity(UserCryptoEntity userCryptoEntity) {
		this.userCryptoEntity = userCryptoEntity;
	}

	public Integer getMaxWrongPasswordCount() {
		return maxWrongPasswordCount;
	}

	public void setMaxWrongPasswordCount(Integer maxWrongPasswordCount) {
		this.maxWrongPasswordCount = maxWrongPasswordCount;
	}

	public Integer getWrongPasswordCount() {
		return wrongPasswordCount;
	}

	public void setWrongPasswordCount(Integer wrongPasswordCount) {
		this.wrongPasswordCount = wrongPasswordCount;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", roleId=" + roleId + ", userName=" + userName + ", firstName="
				+ firstName + ", lastName=" + lastName + ", password=" + password + ", email=" + email + ", isActive="
				+ isActive + ", contactNumber=" + contactNumber + ", location=" + location + ", userCryptoEntity="
				+ userCryptoEntity + ", maxWrongPasswordCount=" + maxWrongPasswordCount + ", wrongPasswordCount="
				+ wrongPasswordCount + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + "]";
	}

}
