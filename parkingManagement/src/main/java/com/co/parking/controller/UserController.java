package com.co.parking.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.co.parking.model.UserDTO;
import com.co.parking.service.UserService;
import com.co.parking.validator.UserValidator;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	
	private final UserService us;
	
	private final Validator uv;
	
	public UserController(UserService us, UserValidator uv) {
		
		this.us = us;
		this.uv = uv;
	}

	@RequestMapping("/userLogin")
	public String userLogin() {
		
		
		return "userLogin";
	}
	
	@RequestMapping(value="/userLogin/do", method=RequestMethod.POST)
	public String doUserLogin(@RequestParam(name="userID") String uid, @RequestParam(name="userPWD") String upwd, HttpSession sess) {
		
		
		String message = us.userLoginResult(uid, upwd);
		System.out.println(message);
		System.out.println("loginCheckToken 상태는 : "+us.isLoginCheckToken());
		if(us.isLoginCheckToken()) {
			
			sess.setAttribute("username", us.getUserName());
			sess.setAttribute("userID", uid);
			sess.setAttribute("usercarnum", us.getUserCarNum());
			return "userLoginResult";
		} else {
			
			sess=null;
			return "userLoginResult";
		}
	}
	
	@RequestMapping("/userLogout/do")
	public String doUserLogout(HttpSession ss) {
		
		ss.removeAttribute("username");
		return "userLogoutResult";
		
	}
	
	@RequestMapping("/userEntry")
	public String userEntry() {
		
		
		return "userEntry";
	}
	
	@RequestMapping(path="/userEntry/do", method=RequestMethod.POST)
	public String createUser(@Validated @ModelAttribute UserDTO udto, BindingResult br, Model m) {
		
		System.out.println(udto);
		System.out.println(udto.isUserParkFlag());
		
		uv.validate(udto, br);
		if(br.hasErrors()) {
			
			return "userEntry";
		} else {
			us.createUser(udto);
			m.addAttribute("user", udto);
			return "userEntryResult";
		}
		
		
	}
	
	
}
