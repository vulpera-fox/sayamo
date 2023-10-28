package com.vulfox.sayamo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vulfox.sayamo.command.CommentVO;
import com.vulfox.sayamo.command.PostVO;
import com.vulfox.sayamo.config.MyUserDetails;
import com.vulfox.sayamo.service.CommunityService;

@Controller
@RequestMapping("/community")
public class CommunityController {
	
	@Autowired
	private CommunityService communityService;
	
	@GetMapping("/index")
	public String communityMain(Model model,
								@RequestParam(required = false, value = "board_id") String board_id) {
		
		if(board_id != null) {
			if(board_id.equals("00")) {
				List<PostVO> postList = communityService.getPostList();
				model.addAttribute("pList", postList);
			} else {
				List<PostVO> postList = communityService.getPostListByCategory(board_id);
				model.addAttribute("pList", postList);
			}
		} else {
			List<PostVO> postList = communityService.getPostList();
			model.addAttribute("pList", postList);
		}
		
		
		return "/community/community-main";
	}
	
	
	@GetMapping("/post")
	public String moveToPost(Model model,
							 @RequestParam("post_id") Integer post_id) {
		
		communityService.updateViews(post_id);
		
		PostVO post = communityService.getPost(post_id);
		
		List<CommentVO> commentList = communityService.getCommentList(post_id);
		
		model.addAttribute("cList", commentList);
		
		model.addAttribute("post", post);
		
		
		
		return "/community/community-post";
	}
	
	
	@ResponseBody
	@PostMapping("/addComment")
	public ResponseEntity<List<CommentVO>> addComment(CommentVO cVO) {
		
		communityService.addComment(cVO);
		
		List<CommentVO> commentList = communityService.getCommentList(cVO.getPost_id());
		
		return ResponseEntity.ok(commentList);
	}
	
	
	@ResponseBody
	@DeleteMapping("/deleteComment")
	public ResponseEntity<List<CommentVO>> deleteComment(CommentVO cVO) {
		
		
		System.out.println("딜리버드딜리버드딜리버드딜리버드딜리버드딜리버드");
		
		System.out.println(cVO.toString());
		
		communityService.deleteComment(cVO);
		
		
		List<CommentVO> commentList = communityService.getCommentList(cVO.getPost_id());
		
		return ResponseEntity.ok(commentList);
		
	}
	
	@GetMapping("/write")
	public String write(Authentication auth, Model model) {
		
		if(auth != null) {
			MyUserDetails user = (MyUserDetails)auth.getPrincipal();
			System.out.println(user.getUsername());
			model.addAttribute("username", user.getUsername());
		}
		return "/community/community-write";
	}
	
	@PostMapping("/addPost")
	public String addPost(PostVO vo) {
		
		System.out.println(vo.toString());
		
		communityService.addPost(vo);
		
		
		return "redirect:/community/index";
	}
	
	@PostMapping("/deletePost/{post_id}")
	public String deletePost(@PathVariable ("post_id") Integer post_id) {
		
		System.out.println(post_id);
		
		communityService.deletePost(post_id);
		
		return "redirect:/community/index";
	}
	
	@GetMapping("/updatePost")
	public String updatePost(@RequestParam ("post_id") Integer post_id, Model model,
							 Authentication auth) {
		
		System.out.println(post_id);
		
		if(auth != null) {
			MyUserDetails user = (MyUserDetails)auth.getPrincipal();
			System.out.println(user.getUsername());
			model.addAttribute("username", user.getUsername());
		}
		
		PostVO postVO = communityService.getPost(post_id);
		
		
		model.addAttribute("postVO", postVO);
		
		return "/community/community-update";
	}
	
	@PostMapping("/updatePostForm")
	public String updatePostForm(PostVO vo) {
		
		System.out.println(vo.toString());

		communityService.updatePost(vo);
		
		
		
		return "redirect:/community/index";
	}

}
