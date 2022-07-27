package com.acldigital.unaito.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acldigital.unaito.service.entity.RecommendationsEntity;

@Repository
public interface IRecommendationsRepository extends CrudRepository<RecommendationsEntity, Long> {

	@Query(value = "select * from recommendations rs where rs.application_id=:applicationId", nativeQuery = true)
	public List<RecommendationsEntity> fetchRecommendationDetails(@Param("applicationId") Long applicationId);
}
