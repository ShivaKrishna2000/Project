package com.orchard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchard.entity.Team;
import com.orchard.repository.TeamRepository;

@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	public Team saveTeam(Team team) {
		// TODO Auto-generated method stub
		return teamRepository.save(team);
	}

	public Team fetchByTeamName(String tempTeam) {
		// TODO Auto-generated method stub
		return teamRepository.findByTeamName(tempTeam);
	}

	public double getMaximumBudgetByTeamName(String teamName) {
		// TODO Auto-generated method stub
		return teamRepository.getMaximumBudgetByTeamName(teamName);
	}

	public List<String> getAllTeamName() {
		// TODO Auto-generated method stub
		return teamRepository.getAllTeamName();
	}

}
