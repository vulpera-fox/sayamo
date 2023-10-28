package com.vulfox.sayamo.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentVO {
	
	private Integer comment_id;
	private String comment_content;
	private String comment_regist_date;
	private String user_name;
	private Integer post_id;

}
