package com.co.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("/userLogin.do")
	public String doUserLogin(@ModelAttribute UserDTO udto, HttpSession sess) {
		
		String message = us.userLoginResult(udto);
		System.out.println(message);
		
		if(us.isLoginCheckToken()) {
			
			sess.setAttribute("username", us.getUserName());
			return "userLoginResult";
		} else {
			
			sess=null;
			return "userLoginResult";
		}
	}
}
