package com.orchard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orchard.entity.Team;

import com.orchard.service.TeamService;

@RestController
@CrossOrigin(origins="*")
public class teamController {
 
	@Autowired
	private TeamService teamService;
	
	@PostMapping("/createTeam")
	
	public Team saveTeam(@RequestBody Team team) throws Exception {
		 
		String tempTeam=team.getTeamName();
		
		if(tempTeam!=null && !"".equals(tempTeam)) {
		 Team userobj=teamService.fetchByTeamName(tempTeam);
		 if(userobj!=null) {
			 throw new Exception("user with "+team.getTeamName()+ " is already exist"); 
		 }
		}
		return teamService.saveTeam(team);
	}
	@GetMapping("/getBudget/{name}")
	public Double getMaximumBudgetByTeamName(@PathVariable ("name") String teamName) {
		return teamService.getMaximumBudgetByTeamName(teamName);
	}
	@GetMapping("/getTeam")
	
	public List<String> getAllTeamName(){
		return teamService.getAllTeamName();
	}
	
}
