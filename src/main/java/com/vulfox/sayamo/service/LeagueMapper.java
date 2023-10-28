package com.vulfox.sayamo.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vulfox.sayamo.command.LeagueVO;
import com.vulfox.sayamo.command.PlayerStatsVO;
import com.vulfox.sayamo.command.TeamVO;

@Mapper
public interface LeagueMapper {
	
	public List<LeagueVO> getLeagueList();
	
	public List<LeagueVO> getLeagueListByLocation(String location_id);
	
	public List<TeamVO> getTeamList();
	
	// 리그별 기록 가져오기
	public List<PlayerStatsVO> getWinList(String league_id);
	public List<PlayerStatsVO> getEraList(String league_id);
	public List<PlayerStatsVO> getSoList(String league_id);
	public List<PlayerStatsVO> getBaList(String league_id);
	public List<PlayerStatsVO> getRbiList(String league_id);
	public List<PlayerStatsVO> getHrList(String league_id);

}
