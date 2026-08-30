package com.co.parking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.parking.entity.ParkEntity;
import com.co.parking.entity.ParkId;
import com.co.parking.model.ParkDTO;
import com.co.parking.repository.ParkRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class ParkService {

	@Autowired
	ParkRepository prepo;
	
	public List<ParkDTO> getAllParkList(){
		
		List<ParkEntity> li = new ArrayList<ParkEntity>();
		List<ParkDTO> list = new ArrayList<ParkDTO>();
		li = prepo.findAll();
		
		System.out.println("ParkRepository findAll method 실행 결과 : " + li);
		
		for(ParkEntity i : li) {
			
			ParkDTO j = new ParkDTO(i.getParkFloor(), i.getParkNum(), i.isParkFlag(), i.getParkCarNum());
			list.add(j);
		}
		
		return list;
	}
	
	public void createPark(int pf, String pn) {
		
		ParkEntity pe = new ParkEntity();
		pe.setParkFloor(pf);
		pe.setParkNum(pn);
		
		
		pe.setParkFlag(true);
		pe.setParkCarNum("주차 차량 없음");
		prepo.save(pe);
	}
	
	public ParkDTO getParkById(ParkId pi) {
		
		
		ParkEntity pe = new ParkEntity();
		pe=prepo.findById(pi).get();
		ParkDTO pdto = new ParkDTO(pe.getParkFloor(), pe.getParkNum(), pe.isParkFlag(), pe.getParkCarNum());
		return pdto;
	}
	
	public void doReservePark(ParkId pi, HttpSession ss) {
		
		ParkEntity pe = new ParkEntity();
		pe = prepo.findById(pi).get();
		pe.setParkFlag(false);
		pe.setParkCarNum(ss.getAttribute("usercarnum").toString());
		prepo.save(pe);
		
	}
	public ParkDTO getMyParkNum(String pcn) {
		
		List<ParkDTO> list = getAllParkList();
		ParkDTO park = new ParkDTO();
		for(ParkDTO pdto : list) {
			
			if(pdto.getParkCarNum()==null || pdto.getParkCarNum()=="") {
				
				continue;
			}
			if(pdto.getParkCarNum().equals(pcn)) {
				
				park.setParkFloor(pdto.getParkFloor());
				park.setParkNum(pdto.getParkNum());
				park.setParkFlag(pdto.isParkFlag());
				park.setParkCarNum(pdto.getParkCarNum());
			}
		}
		return park;
	}
	
	public void doCheckout(String carnum) {
		List<ParkEntity> li = prepo.findAll();
		for(ParkEntity pe : li) {
			
			if(pe.getParkCarNum().equals(carnum)) {
				
				// 주차장 테이블 전 리스트 요소를 순회하며 만약 현재 로그인 유저의 차량 번호와 해당 차량 번호가 일치하면
				// 주차 가능 여부를 주차가능 (parkflag=1) 로, 주차 중 차량 번호는 null 로 변경
				pe.setParkFlag(true);
				pe.setParkCarNum(null);
				
				prepo.save(pe);
				break;
			}
		}
	}
}
