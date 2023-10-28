package com.vulfox.sayamo.command;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVO {
	
	@Pattern(regexp = "^(?=.*[a-zA-Z])[a-zA-Z0-9]{4,16}$")
	private String username;
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,25}$")
	private String password;
	@Email
	private String user_email;
	
	private String user_code;
	
	private String role;

}
