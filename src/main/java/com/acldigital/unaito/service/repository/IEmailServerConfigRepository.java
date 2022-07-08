package com.acldigital.unaito.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acldigital.unaito.service.entity.EmailServerConfigEntity;

@Repository
public interface IEmailServerConfigRepository extends JpaRepository<EmailServerConfigEntity, Long> {

}
