package com.acldigital.unaito.service.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "communication_template_master")
public class CommunicationTemplateMasterEntity implements Serializable {

	private static final long serialVersionUID = 6363497972062196167L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comm_template_id")
	private Long communicationTemplateId;

	@Column(name = "comm_template_type")
	private String communicationTemplateType;

	@Column(name = "template_name")
	private String templateName;

	@Column(name = "subject_line")
	private String subjectLine;

	@Column(name = "template_body")
	private String templateBody;

	@Column(name = "is_active")
	private char isActive;

	public CommunicationTemplateMasterEntity() {

	}

	public CommunicationTemplateMasterEntity(Long communicationTemplateId, String communicationTemplateType,
			String templateName, String subjectLine, String templateBody, char isActive) {
		super();
		this.communicationTemplateId = communicationTemplateId;
		this.communicationTemplateType = communicationTemplateType;
		this.templateName = templateName;
		this.subjectLine = subjectLine;
		this.templateBody = templateBody;
		this.isActive = isActive;
	}

	public Long getCommunicationTemplateId() {
		return communicationTemplateId;
	}

	public void setCommunicationTemplateId(Long communicationTemplateId) {
		this.communicationTemplateId = communicationTemplateId;
	}

	public String getCommunicationTemplateType() {
		return communicationTemplateType;
	}

	public void setCommunicationTemplateType(String communicationTemplateType) {
		this.communicationTemplateType = communicationTemplateType;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getSubjectLine() {
		return subjectLine;
	}

	public void setSubjectLine(String subjectLine) {
		this.subjectLine = subjectLine;
	}

	public String getTemplateBody() {
		return templateBody;
	}

	public void setTemplateBody(String templateBody) {
		this.templateBody = templateBody;
	}

	public char getIsActive() {
		return isActive;
	}

	public void setIsActive(char isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "CommunicationTemplateMasterEntity [communicationTemplateId=" + communicationTemplateId
				+ ", communicationTemplateType=" + communicationTemplateType + ", templateName=" + templateName
				+ ", subjectLine=" + subjectLine + ", templateBody=" + templateBody + ", isActive=" + isActive + "]";
	}

}
