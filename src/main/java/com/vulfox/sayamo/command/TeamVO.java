package com.vulfox.sayamo.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamVO {
	
	private String team_id;
	private String team_name;
	private String league_id;
	private String team_win;
	private String team_draw;
	private String team_lose;

}
