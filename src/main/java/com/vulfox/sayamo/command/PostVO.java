package com.vulfox.sayamo.command;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostVO {
	
	private Integer post_id;
	private String post_title;
	private String post_content;
	private String post_author;
	private LocalDateTime post_regist_date;
	private Integer post_views;
	private Integer post_likes;
	private Integer post_dislikes;
	private String board_id;

}
