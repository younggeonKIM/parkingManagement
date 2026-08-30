package com.co.parking.controller;


import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.co.parking.entity.ParkId;
import com.co.parking.model.ParkDTO;
import com.co.parking.service.CarService;
import com.co.parking.service.ParkService;
import com.co.parking.service.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
public class ParkController {

	
	private final ParkService ps;
	
	
	private final UserService us;
	
	private final CarService cs;
	
	
	
	public ParkController(ParkService ps, UserService us, CarService cs) {
		super();
		this.ps = ps;
		this.us = us;
		this.cs = cs;
	}



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
		
		// 생성자를 사용해 한 줄로 축약
		ParkId pi = new ParkId(fl, num);
		
		// 선언 시 바로 값 대입
		ParkDTO pdto = ps.getParkById(pi);
		
		m.addAttribute("park", pdto);
		return "getParkById";
	}
	
	@RequestMapping(value="/reserv/do", method=RequestMethod.POST)
	public String doReserve(@RequestParam("parkFloor") String pf, @RequestParam("parkNum") String pn, HttpSession ss, Model m) {
		
		
			
		String pfNum = pf.substring(0, 1);
		// 생성자를 사용해 한 줄로 축약
		ParkId pi = new ParkId(Integer.parseInt(pfNum) , pn);
		
		ps.doReservePark(pi, ss);
		
		us.doReserveUser(ss.getAttribute("userID").toString());
		
		cs.reservCar(ss.getAttribute("usercarnum").toString());
		m.addAttribute("parkFloor", pf);
		m.addAttribute("parkNum", pn);
		
		return "reservResult";
		
		
	}
	
	@RequestMapping("/getMyParkNum")
	public String getMyParkNum(HttpSession ss, Model m) {
		if(ss.getAttribute("usercarnum") == null) {
			
			return "getMyParkNum";
		} else {
			
			ParkDTO pdto = ps.getMyParkNum(ss.getAttribute("usercarnum").toString());
			m.addAttribute("parkFloor", pdto.getParkFloor());
			m.addAttribute("parkNum", pdto.getParkNum());
			return "getMyParkNum";
		}
	}
	
	@RequestMapping("/calcParkFee")
	public String getParkFee(HttpSession ss, Model m) {
		
		if(ss.getAttribute("usercarnum") == null) {
			
			return "getParkFee";
		} else {
			
			String userCarNum = ss.getAttribute("usercarnum").toString();
			int fee = cs.getParkFee(userCarNum, ss.getAttribute("userID").toString());
			LocalDateTime ldt = LocalDateTime.now();
			m.addAttribute("fee", fee);
			m.addAttribute("carInTime", cs.getCarInTime(userCarNum));
			m.addAttribute("nowTime", ldt);
			return "getParkFee";
		}
		
	}
	
	@RequestMapping("/doCheckout")
	public String parkCheckOut(HttpSession ss) {
		
		String carnum = ss.getAttribute("usercarnum").toString();
		ps.doCheckout(carnum);
		cs.doCheckout(carnum);
		us.doCheckout(ss.getAttribute("userID").toString());
		return "redirect:/getParkFee";
	}
}
