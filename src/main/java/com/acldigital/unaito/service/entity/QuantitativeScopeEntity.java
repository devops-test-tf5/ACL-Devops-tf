/*
 * package com.acldigital.unaito.service.entity;
 * 
 * import java.io.Serializable; import java.util.Map;
 * 
 * import javax.persistence.Entity; import javax.persistence.GeneratedValue;
 * import javax.persistence.GenerationType; import javax.persistence.Id;
 * 
 * @Entity public class QuantitativeScopeEntity implements Serializable {
 * 
 * private static final long serialVersionUID = 5274671476113170827L;
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long qScopeId;
 * 
 * private Map<String, Integer> qScopeName;
 * 
 * public QuantitativeScopeEntity() {
 * 
 * }
 * 
 * public QuantitativeScopeEntity(Map<String, Integer> qScopeName) { super();
 * this.qScopeName = qScopeName; }
 * 
 * public Long getqScopeId() { return qScopeId; }
 * 
 * public Map<String, Integer> getqScopeName() { return qScopeName; }
 * 
 * public void setqScopeName(Map<String, Integer> qScopeName) { this.qScopeName
 * = qScopeName; }
 * 
 * @Override public String toString() { return
 * "QuantitativeScopeEntity [qScopeId=" + qScopeId + ", qScopeName=" +
 * qScopeName + "]"; }
 * 
 * }
 */