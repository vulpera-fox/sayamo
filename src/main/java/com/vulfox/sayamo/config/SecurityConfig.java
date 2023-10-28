package com.vulfox.sayamo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		
		http.authorizeHttpRequests( (authorize) -> authorize.antMatchers("/community/write", "/mypage", "/community/updatePost").authenticated() .
															 anyRequest().permitAll());
		
		http.formLogin().loginPage("/login").
						 loginProcessingUrl("/loginForm").
						 defaultSuccessUrl("/community/index").
						 failureUrl("/login?err=true").
						 and().logout().logoutUrl("/logout").logoutSuccessUrl("/");
		
		return http.build();
		
	}

}
