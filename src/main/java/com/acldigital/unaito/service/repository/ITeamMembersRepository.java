package com.acldigital.unaito.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acldigital.unaito.service.entity.TeamMemberEntity;

@Repository
public interface ITeamMembersRepository extends CrudRepository<TeamMemberEntity, Long> {

	@Query(value = "select * from team_members t where t.onboarding_id=:onboardingId",nativeQuery = true)
	public List<TeamMemberEntity> fetchTeamMembersByOnboardingId(@Param("onboardingId") Long onboardingId);

}
