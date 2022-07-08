package com.acldigital.unaito.service.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "email_server_config")
public class EmailServerConfigEntity implements Serializable {

	private static final long serialVersionUID = 5554795648465954915L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "email_config_id")
	private Long emailConfigId;

	@Column(name = "config_name")
	private String configName;

	@Column(name = "config_value")
	private String configValue;

	@Column(name = "config_desc")
	private String configDescription;

	public EmailServerConfigEntity() {

	}

	public EmailServerConfigEntity(Long emailConfigId, String configName, String configValue,
			String configDescription) {
		super();
		this.emailConfigId = emailConfigId;
		this.configName = configName;
		this.configValue = configValue;
		this.configDescription = configDescription;
	}

	public Long getEmailConfigId() {
		return emailConfigId;
	}

	public void setEmailConfigId(Long emailConfigId) {
		this.emailConfigId = emailConfigId;
	}

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public String getConfigDescription() {
		return configDescription;
	}

	public void setConfigDescription(String configDescription) {
		this.configDescription = configDescription;
	}

	@Override
	public String toString() {
		return "EmailServerConfigEntity [emailConfigId=" + emailConfigId + ", configName=" + configName
				+ ", configValue=" + configValue + ", configDescription=" + configDescription + "]";
	}

}
