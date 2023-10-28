package com.vulfox.sayamo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vulfox.sayamo.command.PostVO;
import com.vulfox.sayamo.command.UserVO;
import com.vulfox.sayamo.config.MyUserDetails;
import com.vulfox.sayamo.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/")
	public String toMain(Authentication auth) {
		
		if(auth != null) {
			MyUserDetails user = (MyUserDetails)auth.getPrincipal();
			System.out.println(user.getUsername());
		}
		
		// 2nd - 시큐리티 세션을 직접 사용
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			System.out.println(authentication.getPrincipal() instanceof MyUserDetails);
			
			if(authentication.getPrincipal() instanceof MyUserDetails) {
				MyUserDetails details = (MyUserDetails)authentication.getPrincipal();
				System.out.println(details);
				
				
			}
		
		return "/main-page";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "/login";
	}
	
	@GetMapping("/register")
	public String register() {
		
		return "/register";
	}
	
	@PostMapping("/registForm")
	public String registForm(@Valid UserVO vo, Errors errors, RedirectAttributes ra) {
		
		if(!errors.hasErrors()) {
			
			String user_pw = passwordEncoder.encode(vo.getPassword());
			
			UserVO uVO = UserVO.builder().username(vo.getUsername()).password(user_pw).user_email(vo.getUser_email()).user_code(vo.getUser_code()).build();
			
			System.out.println(uVO.toString());
			
			userService.register(uVO);
			
			return "redirect:/login";
			
		} else {
			
			List<FieldError> errList =  errors.getFieldErrors();
			
			for(FieldError err : errList) {
				System.out.println(err.getField());
			}
			
			System.out.println("에러발생");
			
			return "redirect:/register";
		}
		
		
	}
	
	
	@ResponseBody
	@PostMapping("/idDuplicateTest")
	public String idDuplicateTest(@RequestBody String username) {
		System.out.println(username);
		String result = userService.isDuplicatedId(username);
		return result;
	}
	
	@ResponseBody
	@PostMapping("/emailDuplicateTest")
	public String emailDuplicateTest(@RequestBody String user_email) {
		String result = userService.isDuplicatedEmail(user_email);
		return result;
	}
	
	
	@GetMapping("/mypage")
	public String mypage(Authentication auth, Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
		    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		    
		    String username = userDetails.getUsername();
		    
		    UserVO userVO = userService.getUserInfo(username);
		    model.addAttribute("userVO", userVO);
		    
		    List<PostVO> postList = userService.getMyPost(username);
		    model.addAttribute("postList", postList);
		}

		
		return "/mypage";
	}
	
	
	
	
	
	
	
	
	
	

}
