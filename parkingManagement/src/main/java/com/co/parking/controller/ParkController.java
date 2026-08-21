package com.co.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.co.parking.entity.ParkId;
import com.co.parking.model.ParkDTO;
import com.co.parking.service.ParkService;


@Controller
public class ParkController {

	@Autowired
	ParkService ps;
	
	
	
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
		
		ParkDTO pdto;
		ParkId pi = new ParkId();
		pi.setParkFloor(fl);
		pi.setParkNum(num);
		pdto=ps.getParkById(pi);
		m.addAttribute("park", pdto);
		return "getParkById";
	}
}
