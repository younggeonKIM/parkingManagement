package com.co.parking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;


@Controller
public class HomeController {

	
	
	@RequestMapping("/")
	public String Home( ) {
		
		System.out.println("home page requested.");
		return "home";
	}
	
	@RequestMapping(path="calc.do")
	public String add(@RequestParam("num1") int n1,@RequestParam("num2") int n2, HttpSession sess) {
		
		
		int res = n1+n2;
		sess.setAttribute("result", res);
		return "result";
	}
	
	/*
	 * @RequestMapping(path="calc.do") public ModelAndView add(HttpServletRequest
	 * req) {
	 * 
	 * 
	 * int n1 = Integer.parseInt(req.getParameter("num1"));
	 * 
	 * int n2 = Integer.parseInt(req.getParameter("num2")); int res = n1+n2;
	 * ModelAndView mav= new ModelAndView() {}; mav.addObject("result", res);
	 * mav.setViewName("result.jsp"); return mav; }
	 */
}
