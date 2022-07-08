INSERT INTO unaito.communication_template_master (`comm_template_id`,`comm_template_type`,`template_name`,`subject_line`,`template_body`,`is_active`,`created_by`,`created_date`,`updated_by`,`updated_date`) VALUES (1,'EMAIL_VERIFICATION','EMAIL VERIFICATION','USER EMAIL VERIFICATION','<html>\n   <body>\n      Dear ${USER_NAME},<br/> \n      <h4>Welcome!!</h4>\n      <br/>Please click on link <a href=\"${EMAIL_LINK}\">${EMAIL_LINK}</a> for the verification of your e-mail address and activation of your user account of BK Poker. <br/>\n      <h3>Regards, <br/>BK Poker Team.</h3>\n   </body>\n</html>','Y','ADMIN','2022-06-14 19:53:24','ADMIN','2022-06-14 19:53:24');

INSERT INTO unaito.status_master (`status_id`,`status_name`,`active`,`created_by`,`created_date`,`updated_by`,`updated_date`) VALUES (1,'NEW','Y','ADMIN','2022-06-15 10:03:09','ADMIN','2022-06-15 10:03:09');
INSERT INTO unaito.status_master (`status_id`,`status_name`,`active`,`created_by`,`created_date`,`updated_by`,`updated_date`) VALUES (2,'RETRY','Y','ADMIN','2022-06-15 10:03:09','ADMIN','2022-06-15 10:03:09');
INSERT INTO unaito.status_master (`status_id`,`status_name`,`active`,`created_by`,`created_date`,`updated_by`,`updated_date`) VALUES (3,'MAX_RETRY_CONSUMED','Y','ADMIN','2022-06-15 10:03:09','ADMIN','2022-06-15 10:03:09');
INSERT INTO unaito.status_master (`status_id`,`status_name`,`active`,`created_by`,`created_date`,`updated_by`,`updated_date`) VALUES (4,'SENT','Y','ADMIN','2022-06-15 10:03:09','ADMIN','2022-06-15 10:03:09');
INSERT INTO unaito.status_master (`status_id`,`status_name`,`active`,`created_by`,`created_date`,`updated_by`,`updated_date`) VALUES (5,'VERIFIED','Y','ADMIN','2022-06-15 10:03:09','ADMIN','2022-06-15 10:03:09');
INSERT INTO unaito.status_master (`status_id`,`status_name`,`active`,`created_by`,`created_date`,`updated_by`,`updated_date`) VALUES (6,'FAILED','Y','ADMIN','2022-06-15 10:03:09','ADMIN','2022-06-15 10:03:09');
INSERT INTO unaito.status_master (`status_id`,`status_name`,`active`,`created_by`,`created_date`,`updated_by`,`updated_date`) VALUES (7,'IN_REVIEW','Y','ADMIN','2022-06-15 10:03:09','ADMIN','2022-06-15 10:03:09');
INSERT INTO unaito.status_master (`status_id`,`status_name`,`active`,`created_by`,`created_date`,`updated_by`,`updated_date`) VALUES (8,'REVIEWED','Y','ADMIN','2022-06-15 10:03:09','ADMIN','2022-06-15 10:03:09');
INSERT INTO unaito.status_master (`status_id`,`status_name`,`active`,`created_by`,`created_date`,`updated_by`,`updated_date`) VALUES (9,'APPROVED','Y','ADMIN','2022-06-15 10:11:27','ADMIN','2022-06-15 10:11:27');



INSERT INTO unaito.email_server_config (`email_config_id`,`config_name`,`config_value`,`config_desc`,`created_by`,`created_date`,`updated_by`,`updated_date`) VALUES (1,'MAX_EMAIL_VERIFICATION_COUNT','1','Maximum email verification count','ADMIN','2022-06-15 12:35:18','ADMIN','2022-06-15 12:35:18');
INSERT INTO unaito.email_server_config (`email_config_id`,`config_name`,`config_value`,`config_desc`,`created_by`,`created_date`,`updated_by`,`updated_date`) VALUES (2,'SCHEDULER_EMAILJOB_INITIALDELAY','1000','Scheduler will run after application startup','ADMIN','2022-06-15 12:36:56','ADMIN','2022-06-15 12:36:56');
INSERT INTO unaito.email_server_config (`email_config_id`,`config_name`,`config_value`,`config_desc`,`created_by`,`created_date`,`updated_by`,`updated_date`) VALUES (3,'SCHEDULER_EMAILJOB_DELAY','5000','Time delay in execution of Job','ADMIN','2022-06-15 12:37:36','ADMIN','2022-06-15 12:37:36');
INSERT INTO unaito.email_server_config (`email_config_id`,`config_name`,`config_value`,`config_desc`,`created_by`,`created_date`,`updated_by`,`updated_date`) VALUES (4,'SCHEDULER_EMAILJOB_FROMEMAIL','info@unaito.com','Send email from','ADMIN','2022-06-15 12:38:18','ADMIN','2022-06-15 12:38:18');


INSERT INTO unaito.roles (`role_id`,`role_name`,`is_active`,`created_by`,`created_date`,`updated_by`,`updated_date`) VALUES (1,'project_manager',1,'ADMIN','2022-05-19 12:35:41','ADMIN','2022-05-19 12:35:41');
INSERT INTO unaito.roles (`role_id`,`role_name`,`is_active`,`created_by`,`created_date`,`updated_by`,`updated_date`) VALUES (2,'acl_staff',1,'ADMIN','2022-05-19 12:35:41','ADMIN','2022-05-19 12:35:41');
INSERT INTO unaito.roles (`role_id`,`role_name`,`is_active`,`created_by`,`created_date`,`updated_by`,`updated_date`) VALUES (3,'customer',1,'ADMIN','2022-05-19 12:35:41','ADMIN','2022-05-19 12:35:41');
INSERT INTO unaito.roles (`role_id`,`role_name`,`is_active`,`created_by`,`created_date`,`updated_by`,`updated_date`) VALUES (4,'team_member',1,'ADMIN','2022-07-05 15:55:58','ADMIN','2022-07-05 15:55:58');
