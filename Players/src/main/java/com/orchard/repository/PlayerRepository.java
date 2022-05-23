package com.orchard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.orchard.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{

	
	
	Player findByPlayerName(String tempPlayer);

	List<Player> getByTeamName(String teamName);

	@Query(
			value= "SELECT sum(bidding_budget) FROM player WHERE player.team_name=?1 ",
			nativeQuery = true
			)
	Double getTotalBudgetByTeamName(String tempTeam);

	Player findByPlayerId(Long playerId);

	

	

	
}
