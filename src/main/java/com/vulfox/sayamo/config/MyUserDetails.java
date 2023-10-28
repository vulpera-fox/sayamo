package com.vulfox.sayamo.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vulfox.sayamo.command.UserVO;

public class MyUserDetails implements UserDetails {
	
	
	private UserVO userVO;
	
	public MyUserDetails(UserVO userVO) {
		this.userVO = userVO;
	}
	
	public String getRole() {
		return userVO.getRole();
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> list = new ArrayList<>();
		
		list.add(new SimpleGrantedAuthority(userVO.getRole()));
		
		return list;
	}

	@Override
	public String getPassword() {
		return userVO.getPassword();
	}

	@Override
	public String getUsername() {
		return userVO.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	

}
