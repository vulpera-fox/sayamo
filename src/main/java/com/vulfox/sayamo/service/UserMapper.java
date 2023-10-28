package com.vulfox.sayamo.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vulfox.sayamo.command.PostVO;
import com.vulfox.sayamo.command.TeamVO;
import com.vulfox.sayamo.command.UserVO;

@Mapper
public interface UserMapper {
	
	// 회원가입
	public void register(UserVO vo);
	
	// 로그인
	public UserVO login(String username);
	
	// 아이디 중복체크
	public String isDuplicatedId(String username);
	
	// 비밀번호 중복체크
	public String isDuplicatedEmail(String user_email);
	
	// 유저 정보 가져오기
	public UserVO getUserInfo(String username);
	
	// 내 팀 정보 가져오기
	public TeamVO getMyTeam(String username);
	
	// 내가 쓴 글 가져오기
	public List<PostVO> getMyPost(String username);

}
