package com.acldigital.unaito.service.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acldigital.unaito.service.entity.CustomersEntity;

@Repository
public interface ICustomerRepository extends CrudRepository<CustomersEntity, Long> {

	@Query(value = "select * from customers c where c.customer_name=:customerName", nativeQuery = true)
	public CustomersEntity getCustomerDetails(@Param("customerName") String customerName);

	@Query(value = "select * from customers c where c.customer_id=:customerId and c.is_active=:isActive", nativeQuery = true)
	public CustomersEntity fetchCustomerDetails(@Param("customerId") Long customerId,
			@Param("isActive") Integer isActive);

	@Query(value = "select * from customers c where c.is_active=:isActive", nativeQuery = true)
	public Iterable<CustomersEntity> getAllCustomers(@Param("isActive") Integer isActive);
}
