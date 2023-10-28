package com.vulfox.sayamo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vulfox.sayamo.command.PostVO;
import com.vulfox.sayamo.command.TeamVO;
import com.vulfox.sayamo.command.UserVO;

@Service("UserService")
public class UserServiceImplements implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void register(UserVO vo) {
		userMapper.register(vo);
	}

	@Override
	public String isDuplicatedId(String username) {
		if(userMapper.isDuplicatedId(username) == null) {
			return "avaliable";
		} else {
			return "duplicated";
		}
	}

	@Override
	public String isDuplicatedEmail(String user_email) {
		if(userMapper.isDuplicatedEmail(user_email) == null) {
			return "avaliable";
		} else {
			return "duplicated";
		}
	}

	@Override
	public UserVO getUserInfo(String username) {
		return userMapper.getUserInfo(username);
	}

	@Override
	public TeamVO getMyTeam(String username) {
		return userMapper.getMyTeam(username);
	}

	@Override
	public List<PostVO> getMyPost(String username) {
		return userMapper.getMyPost(username);
	}

	
	
}
