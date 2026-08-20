package com.co.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
