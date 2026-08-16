package com.co.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.co.parking.service.ParkService;

@Controller
public class HomeController {

	@Autowired
	ParkService ps;
	
	
	@RequestMapping("/")
	public String Home( ) {
		
		System.out.println("home page requested.");
		return "home";
	}
	
	@RequestMapping("/getAllPark")
	public String getAllPark(Model m) {
		
		System.out.println("parkService 실행 결과 parkList : "+ps.getAllParkList());
		
		m.addAttribute("parkList", ps.getAllParkList());
		
		return "";
	}
	
	
	
	
	/*
	 * @RequestMapping(path="calc.do") public String add(@RequestParam("num1") int
	 * n1,@RequestParam("num2") int n2, ModelMap m) {
	 * 
	 * int res = n1+n2; m.addAttribute("result", res); return "result"; }
	 * 
	 * @RequestMapping("regAlien.do") public String
	 * regAlien(@ModelAttribute("alien") Alien a) {
	 * 
	 * 
	 * 
	 * return "result"; }
	 * 
	 * @ModelAttribute public void alienName(Model m) {
	 * 
	 * m.addAttribute("ALIEN", "영건"); }
	 */
	
	
	/* Model 사용
	 * @RequestMapping(path="calc.do") public String add(@RequestParam("num1") int
	 * n1,@RequestParam("num2") int n2, Model m) {
	 * 
	 * 
	 * int res = n1+n2; m.addAttribute("result", res); return "result"; }
	 */
	
	/* HttpSession 사용
	 * @RequestMapping(path="calc.do") public String add(@RequestParam("num1") int
	 * n1,@RequestParam("num2") int n2, HttpSession sess) {
	 * 
	 * 
	 * int res = n1+n2; sess.setAttribute("result", res); return "result"; }
	 */
	
	
	
	/* HttpServletRequest 와 ModelAndView 사용
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
