package com.vulfox.sayamo.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
public class LeagueVO {
	
	private String league_id;
	private String league_name;
	private String league_start_date;
	private String league_end_date;
	private String location_id;

}
