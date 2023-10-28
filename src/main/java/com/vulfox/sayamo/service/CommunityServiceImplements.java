package com.vulfox.sayamo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vulfox.sayamo.command.CommentVO;
import com.vulfox.sayamo.command.PostVO;

@Service("CommunityService")
public class CommunityServiceImplements implements CommunityService {
	
	@Autowired
	private CommunityMapper communityMapper;

	@Override
	public List<PostVO> getPostList() {
		return communityMapper.getPostList();
	}
	
	@Override
	public List<PostVO> getPostListByCategory(String board_id) {
		return communityMapper.getPostListByCategory(board_id);
	}

	@Override
	public PostVO getPost(Integer post_id) {
		return communityMapper.getPost(post_id);
	}

	@Override
	public PostVO getPreviousPost(Integer post_id) {
		return communityMapper.getPreviousPost(post_id);
	}

	@Override
	public PostVO getNextPost(Integer post_id) {
		return communityMapper.getNextPost(post_id);
	}
	

	@Override
	public List<CommentVO> getCommentList(Integer post_id) {
		return communityMapper.getCommentList(post_id);
	}

	@Override
	public void addComment(CommentVO vo) {
		communityMapper.addComment(vo);
	}


	@Override
	public void deleteComment(CommentVO vo) {
		communityMapper.deleteComment(vo);
	}

	@Override
	public void updateViews(Integer post_id) {
		communityMapper.updateViews(post_id);
	}

	@Override
	public void addPost(PostVO vo) {
		communityMapper.addPost(vo);
	}

	@Override
	public void deletePost(Integer post_id) {
		communityMapper.deletePost(post_id);
	}

	@Override
	public void updatePost(PostVO vo) {
		communityMapper.updatePost(vo);
	}	

	
}
