package com.acldigital.unaito.service.user.dto;

public class CommunicationTemplateDetails {

	private Long communicationTemplateId;
	private String communicationTemplateType;
	private String templateName;
	private String subjectLine;
	private String templateBody;
	private char isActive;

	public CommunicationTemplateDetails() {

	}

	public CommunicationTemplateDetails(Long communicationTemplateId, String communicationTemplateType,
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
		return "CommunicationTemplateDetails [communicationTemplateId=" + communicationTemplateId
				+ ", communicationTemplateType=" + communicationTemplateType + ", templateName=" + templateName
				+ ", subjectLine=" + subjectLine + ", templateBody=" + templateBody + ", isActive=" + isActive + "]";
	}

}
