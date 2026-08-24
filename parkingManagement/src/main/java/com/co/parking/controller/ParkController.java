package com.co.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.co.parking.entity.ParkId;
import com.co.parking.model.ParkDTO;
import com.co.parking.service.ParkService;
import com.co.parking.service.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
public class ParkController {

	@Autowired
	ParkService ps;
	
	@Autowired
	UserService us;
	
	@RequestMapping("/parkEntry")
	public String goParkEntry() {
		
		return "parkEntry";
	}
	
	@RequestMapping("/parkEntry/do")
	public String createPark(@RequestParam("parkFloor") int pf, @RequestParam("parkNum") String pn, Model m) {
		
		ps.createPark(pf, pn);
		m.addAttribute("parkFloor", pf);
		m.addAttribute("parkNum", pn);
		return "parkEntryResult";
	}
	
	@RequestMapping("/park/id/{floor}/{num}")
	public String getParkById(@PathVariable("floor")int fl, @PathVariable("num")String num, Model m) {
		
		// 생성자를 사용해 한줄로 축약
		ParkId pi = new ParkId(fl, num);
		
		// 선언 시 바로 값 대입
		ParkDTO pdto = ps.getParkById(pi);
		
		m.addAttribute("park", pdto);
		return "getParkById";
	}
	
	@RequestMapping(value="/reserv/do", method=RequestMethod.POST)
	public String doReserve(@RequestParam("parkFloor") int pf, @RequestParam("parkNum") String pn, HttpSession ss, Model m) {
		
		ParkId pi = new ParkId();
		pi.setParkFloor(pf);
		pi.setParkNum(pn);
		ps.doReservePark(pi);
		us.doReserveUser(ss.getAttribute("userID").toString());
		m.addAttribute("parkFloor", pf);
		m.addAttribute("parkNum", pn);
		
		return "reservResult";
	}
}
