package com.vulfox.sayamo.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerStatsVO {
	
	private String username;
	private String team_id;
	private String position;
	private Integer batter_game;
	private Integer batter_pa;
	private Integer batter_hit;
	private Integer batter_2b;
	private Integer batter_3b;
	private Integer batter_hr;
	private Integer batter_rbi;
	private Integer batter_run;
	private Integer batter_sb;
	private Integer batter_bb;
	private Integer batter_so;
	private Integer pitcher_game;
	private Integer pitcher_ip;
	private Integer pitcher_win;
	private Integer pitcher_lose;
	private Integer pitcher_save;
	private Integer pitcher_so;
	private Integer pitcher_hit;
	private Integer pitcher_hr;
	private Integer pitcher_run;
	private Integer pitcher_bb;
	private Integer pitcher_hbp;
	
	private float pitcher_era;
	private float batter_ba;

}
