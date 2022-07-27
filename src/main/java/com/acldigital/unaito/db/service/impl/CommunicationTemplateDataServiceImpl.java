package com.acldigital.unaito.db.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acldigital.unaito.db.ICommunicationTemplateDataService;
import com.acldigital.unaito.db.mapper.MapperUtils;
import com.acldigital.unaito.service.entity.CommunicationTemplateMasterEntity;
import com.acldigital.unaito.service.repository.ICommunicationTemplateRepository;
import com.acldigital.unaito.service.security.constants.CommunicationTemplateTypeEnum;
import com.acldigital.unaito.service.user.dto.CommunicationTemplateDetails;

@Service
public class CommunicationTemplateDataServiceImpl implements ICommunicationTemplateDataService {

	@Autowired
	private ICommunicationTemplateRepository communicationTemplateRepository;

	@Autowired
	private MapperUtils mapperUtils;

	@Override
	public CommunicationTemplateDetails getEmailTemplateDetails(CommunicationTemplateTypeEnum templateTypeEnum) {
		CommunicationTemplateMasterEntity entity = communicationTemplateRepository
				.findByCommunicationTemplateType(templateTypeEnum.getValue());
		return mapperUtils.convertToCommunicationTemplateDetails(entity);
	}

}
