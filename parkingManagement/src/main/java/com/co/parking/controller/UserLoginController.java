package com.co.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.co.parking.model.UserDTO;
import com.co.parking.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserLoginController {

	@Autowired
	UserService us;
	
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
			return "userLoginResult";
		} else {
			
			sess=null;
			return "userLoginResult";
		}
	}
}
