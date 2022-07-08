/*
 * package com.acldigital.unaito.service.listener;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.ApplicationListener; //import
 * org.springframework.mail.javamail.JavaMailSender; import
 * org.springframework.stereotype.Component;
 * 
 * import com.acldigital.unaito.service.event.OnUserRegistrationCompleteEvent;
 * import com.acldigital.unaito.service.user.dto.User;
 * 
 * @Component public class UserRegistrationListener implements
 * ApplicationListener<OnUserRegistrationCompleteEvent> {
 * 
 * 
 * @Autowired private JavaMailSender mailSender;
 * 
 * 
 * 
 * @Override public void onApplicationEvent(OnUserRegistrationCompleteEvent
 * event) { this.confirmRegistration(event); }
 * 
 * private void confirmRegistration(OnUserRegistrationCompleteEvent event) {
 * User user = event.getUser();
 * 
 * }
 * 
 * }
 */