package com.vulfox.sayamo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vulfox.sayamo.command.LeagueVO;
import com.vulfox.sayamo.command.PlayerStatsVO;
import com.vulfox.sayamo.command.TeamVO;

@Service("LeagueService")
public class LeagueServiceImplements implements LeagueService {
	
	@Autowired
	private LeagueMapper leagueMapper;

	@Override
	public List<LeagueVO> getLeagueList() {
		return leagueMapper.getLeagueList();
	}

	@Override
	public List<LeagueVO> getLeagueListByLocation(String location_id) {
		return leagueMapper.getLeagueListByLocation(location_id);
	}

	@Override
	public List<TeamVO> getTeamList() {
		return leagueMapper.getTeamList();
	}

	@Override
	public List<PlayerStatsVO> getWinList(String league_id) {
		return leagueMapper.getWinList(league_id);
	}

	@Override
	public List<PlayerStatsVO> getEraList(String league_id) {
		return leagueMapper.getEraList(league_id);
	}

	@Override
	public List<PlayerStatsVO> getSoList(String league_id) {
		return leagueMapper.getSoList(league_id);
	}

	@Override
	public List<PlayerStatsVO> getBaList(String league_id) {
		return leagueMapper.getBaList(league_id);
	}

	@Override
	public List<PlayerStatsVO> getRbiList(String league_id) {
		return leagueMapper.getRbiList(league_id);
	}

	@Override
	public List<PlayerStatsVO> getHrList(String league_id) {
		return leagueMapper.getHrList(league_id);
	}


}
