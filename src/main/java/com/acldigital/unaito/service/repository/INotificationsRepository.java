package com.acldigital.unaito.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.acldigital.unaito.service.entity.NotificationsEntity;

@Repository
public interface INotificationsRepository extends CrudRepository<NotificationsEntity, Long> {

}
