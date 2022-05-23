package com.orchard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.orchard.entity.Player;
import com.orchard.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Player fetchByPlayerName(String tempPlayer) {
		// TODO Auto-generated method stub
		return playerRepository.findByPlayerName(tempPlayer);
	}

	public Player savePlayer(Player player) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(player.getTeamName());
		System.out.println(player.getBiddingBudget());
		System.out.println(player.getPlayerName());
		String tempTeam=(String)player.getTeamName();
		
		//maximum budget from team microservice
		if(!tempTeam.equals("NA")) {
			
		    Double maximunBudget=restTemplate.getForObject("http://localhost:8082/getBudget/"+tempTeam, Double.class);
		
		   Double teamBudget;
		
		   if(playerRepository.getByTeamName(tempTeam).isEmpty()) {//to avoid nullpointer error 
			   teamBudget=0.0;
		    }else {
		 teamBudget=getTotalBudgetByTeamName(tempTeam);//if i use this directly during first player its give null;
		}
		
		 System.out.println(teamBudget);
		
		double remainingBudget=maximunBudget-teamBudget;
		
		       if(remainingBudget < player.getBiddingBudget()) {
			    throw new Exception("player can't be tagged to this team as it excceds team budgets ");
		     }
	  }
		return playerRepository.save(player);
	}

	public List<Player> getPlayers(String teamName) {
		// TODO Auto-generated method stub
		return playerRepository.getByTeamName(teamName);
	}

	public Double getTotalBudgetByTeamName(String tempTeam) {
		// TODO Auto-generated method stub
		return playerRepository.getTotalBudgetByTeamName(tempTeam);
	}

	public Player getByPlayerId(Long playerId) {
		// TODO Auto-generated method stub
		return playerRepository.findByPlayerId(playerId);
	}

	

	
}
