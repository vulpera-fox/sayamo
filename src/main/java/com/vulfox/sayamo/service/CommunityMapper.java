package com.vulfox.sayamo.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.vulfox.sayamo.command.CommentVO;
import com.vulfox.sayamo.command.PostVO;

@Mapper
public interface CommunityMapper {
	
	// 전체 게시글 불러오기
	public List<PostVO> getPostList();
	
	// 카테고리 별 게시글 불러오기
	public List<PostVO> getPostListByCategory(String board_id);
	
	// 게시글 정보 불러오기
	public PostVO getPost(Integer post_id);
	
	// 이전 게시글 정보 불러오기
	public PostVO getPreviousPost(Integer post_id);
	
	// 다음 게시글 정보 불러오기
	public PostVO getNextPost(Integer post_id);
	
	// 댓글 목록 불러오기
	public List<CommentVO> getCommentList(Integer post_id);
	
	// 댓글 업데이트 (비동기)
	public void addComment(CommentVO vo);
	
	// 댓글 삭제 (비동기)
	public void deleteComment(CommentVO vo);
	
	// 조회수 늘리기
	public void updateViews(Integer post_id);
	
	// 게시글 등록
	public void addPost(PostVO vo);
	
	// 게시글 삭제
	public void deletePost(Integer post_id);
	
	// 게시글 수정
	public void updatePost(PostVO vo);
	

}
