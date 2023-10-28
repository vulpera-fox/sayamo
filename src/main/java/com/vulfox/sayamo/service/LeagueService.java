package com.vulfox.sayamo.service;

import java.util.List;


import com.vulfox.sayamo.command.LeagueVO;
import com.vulfox.sayamo.command.PlayerStatsVO;
import com.vulfox.sayamo.command.TeamVO;

public interface LeagueService {
	
	// 전체 리그 리스트
	public List<LeagueVO> getLeagueList();

	// 지역별 리그 리스트
	public List<LeagueVO> getLeagueListByLocation(String location_id);
	
	// 리그별 팀 리스트
	public List<TeamVO> getTeamList();
	
	// 리그별 기록 가져오기
	public List<PlayerStatsVO> getWinList(String league_id);
	public List<PlayerStatsVO> getEraList(String league_id);
	public List<PlayerStatsVO> getSoList(String league_id);
	public List<PlayerStatsVO> getBaList(String league_id);
	public List<PlayerStatsVO> getRbiList(String league_id);
	public List<PlayerStatsVO> getHrList(String league_id);
	
}
