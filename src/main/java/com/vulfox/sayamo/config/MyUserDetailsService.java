package com.vulfox.sayamo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vulfox.sayamo.command.UserVO;
import com.vulfox.sayamo.service.UserMapper;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println(username);
		
		UserVO vo = userMapper.login(username);
		
		if(vo != null) {
			System.out.println(vo.toString());
			return new MyUserDetails(vo);
		}
		
		
		return null;
	}

}
