package com.orchard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.orchard.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

	Team findByTeamName(String tempTeam);

	@Query(
			value="SELECT maximum_budget FROM team WHERE team.team_name=?1",
			nativeQuery = true
			)
	double getMaximumBudgetByTeamName(String teamName);

	@Query(
			value="SELECT team_name From team",
			nativeQuery = true
			)
	List<String> getAllTeamName();

	
}
