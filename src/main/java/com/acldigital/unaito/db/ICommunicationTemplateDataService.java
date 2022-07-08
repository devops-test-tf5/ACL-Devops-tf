package com.acldigital.unaito.db;

import com.acldigital.unaito.service.security.constants.CommunicationTemplateTypeEnum;
import com.acldigital.unaito.service.user.dto.CommunicationTemplateDetails;

public interface ICommunicationTemplateDataService {

	CommunicationTemplateDetails getEmailTemplateDetails(CommunicationTemplateTypeEnum templateTypeEnum);
}
