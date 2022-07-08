/*
 * package com.acldigital.unaito.service.entity;
 * 
 * import java.io.Serializable;
 * 
 * import javax.persistence.Entity; import javax.persistence.GeneratedValue;
 * import javax.persistence.GenerationType; import javax.persistence.Id;
 * 
 * @Entity public class ScopeEntity implements Serializable {
 * 
 * private static final long serialVersionUID = 3439177022513200965L;
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long scopeId;
 * 
 * private FunctionalScopeEntity funScopeEntity;
 * 
 * private QuantitativeScopeEntity qScopeEntity;
 * 
 * public ScopeEntity() {
 * 
 * }
 * 
 * public ScopeEntity(FunctionalScopeEntity funScopeEntity,
 * QuantitativeScopeEntity qScopeEntity) { super(); this.funScopeEntity =
 * funScopeEntity; this.qScopeEntity = qScopeEntity; }
 * 
 * public Long getScopeId() { return scopeId; }
 * 
 * public FunctionalScopeEntity getFunScopeEntity() { return funScopeEntity; }
 * 
 * public void setFunScopeEntity(FunctionalScopeEntity funScopeEntity) {
 * this.funScopeEntity = funScopeEntity; }
 * 
 * public QuantitativeScopeEntity getqScopeEntity() { return qScopeEntity; }
 * 
 * public void setqScopeEntity(QuantitativeScopeEntity qScopeEntity) {
 * this.qScopeEntity = qScopeEntity; }
 * 
 * @Override public String toString() { return "ScopeEntity [scopeId=" + scopeId
 * + ", funScopeEntity=" + funScopeEntity + ", qScopeEntity=" + qScopeEntity +
 * "]"; }
 * 
 * }
 */