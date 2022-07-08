/*
 * package com.acldigital.unaito.service.entity;
 * 
 * import java.io.Serializable;
 * 
 * import javax.persistence.Entity; import javax.persistence.GeneratedValue;
 * import javax.persistence.GenerationType; import javax.persistence.Id;
 * 
 * @Entity public class DriverEntity implements Serializable {
 * 
 * private static final long serialVersionUID = 3473464431377770132L;
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long driverId;
 * 
 * private BusinessDriversEntity businessDriversEntity;
 * 
 * private ItDriversEntity itDriversEntity;
 * 
 * public DriverEntity() {
 * 
 * }
 * 
 * public DriverEntity(BusinessDriversEntity businessDriversEntity,
 * ItDriversEntity itDriversEntity) { super(); this.businessDriversEntity =
 * businessDriversEntity; this.itDriversEntity = itDriversEntity; }
 * 
 * public Long getDriverId() { return driverId; }
 * 
 * public BusinessDriversEntity getBusinessDriversEntity() { return
 * businessDriversEntity; }
 * 
 * public void setBusinessDriversEntity(BusinessDriversEntity
 * businessDriversEntity) { this.businessDriversEntity = businessDriversEntity;
 * }
 * 
 * public ItDriversEntity getItDriversEntity() { return itDriversEntity; }
 * 
 * public void setItDriversEntity(ItDriversEntity itDriversEntity) {
 * this.itDriversEntity = itDriversEntity; }
 * 
 * @Override public String toString() { return "DriverEntity [driverId=" +
 * driverId + ", businessDriversEntity=" + businessDriversEntity +
 * ", itDriversEntity=" + itDriversEntity + "]"; }
 * 
 * }
 */