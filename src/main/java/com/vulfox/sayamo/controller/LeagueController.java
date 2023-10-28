package com.vulfox.sayamo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vulfox.sayamo.command.LeagueVO;
import com.vulfox.sayamo.command.PlayerStatsVO;
import com.vulfox.sayamo.command.TeamVO;
import com.vulfox.sayamo.config.MyUserDetails;
import com.vulfox.sayamo.service.LeagueService;

@Controller
@RequestMapping("/league")
public class LeagueController {
	
	@Autowired
	@Qualifier("LeagueService")
	private LeagueService leagueService;
	
	
	
	
	
	@GetMapping("/index")
	public String reagueMain(Model model,
							 @RequestParam(required = false, value = "location_id") String location_id,
							 Authentication authentication) {
		
		if(authentication != null) {
			MyUserDetails user = (MyUserDetails)authentication.getPrincipal();
			System.out.println(user.getUsername());
		}
		
		if(location_id != null) {
			System.out.println(location_id.equals("00"));
			if(location_id.equals("00")) {
				List<LeagueVO> leagueList = leagueService.getLeagueList();
				model.addAttribute("lList", leagueList);
			} else {
				List<LeagueVO> leagueList = leagueService.getLeagueListByLocation(location_id);
				model.addAttribute("lList", leagueList);
			}
		} else {
			List<LeagueVO> leagueList = leagueService.getLeagueList();
			model.addAttribute("lList", leagueList);
		}
		
		List<TeamVO> teamList = leagueService.getTeamList();
		model.addAttribute("tList", teamList);
		
		
		return "/league/league-main";
	}
	
	
	@GetMapping("/stats")
	public String stats(Model model,
			 @RequestParam(required = false, value = "location_id") String location_id,
			 @RequestParam(required = false, value = "league_id") String league_id,
			 Authentication authentication) {
		
		model.addAttribute("league_id", league_id);
		
		if(authentication != null) {
			MyUserDetails user = (MyUserDetails)authentication.getPrincipal();
			System.out.println(user.getUsername());
		}
		
		if(location_id != null) {
			System.out.println(location_id.equals("00"));
			if(location_id.equals("00")) {
				List<LeagueVO> leagueList = leagueService.getLeagueList();
				model.addAttribute("lList", leagueList);
			} else {
				List<LeagueVO> leagueList = leagueService.getLeagueListByLocation(location_id);
				model.addAttribute("lList", leagueList);
			}
			
			
		} else {
			List<LeagueVO> leagueList = leagueService.getLeagueList();
			model.addAttribute("lList", leagueList);
		}
		
		if(league_id != null) {
			
			
			
			List<PlayerStatsVO> winList = leagueService.getWinList(league_id);
			List<PlayerStatsVO> eraList = leagueService.getEraList(league_id);
			List<PlayerStatsVO> soList = leagueService.getSoList(league_id);
			List<PlayerStatsVO> baList = leagueService.getBaList(league_id);
			List<PlayerStatsVO> rbiList = leagueService.getRbiList(league_id);
			List<PlayerStatsVO> hrList = leagueService.getHrList(league_id);
			
			model.addAttribute("winList", winList);
			model.addAttribute("eraList", eraList);
			model.addAttribute("soList", soList);
			model.addAttribute("baList", baList);
			model.addAttribute("rbiList", rbiList);
			model.addAttribute("hrList", hrList);
			
		}
		
		
		
		return "/league/league-stats";
	}
	

}
