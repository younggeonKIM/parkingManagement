package com.co.parking.service;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.parking.entity.CarEntity;
import com.co.parking.model.UserDTO;
import com.co.parking.repository.CarRepository;
import com.co.parking.repository.UserRepository;



@Service
public class CarService {

	
	@Autowired
	UserRepository ur;
	
	@Autowired
	CarRepository cr;
	
	public void reservCar(String carNum) {
		
		ZoneId zi = ZoneId.of("Asia/Seoul");
		if(cr.existsById(carNum)) {
			CarEntity ce = cr.findById(carNum).get();
			ce.setCarInTime(LocalDateTime.now(zi));
			System.out.println("예약 시 현재 시각은 : "+LocalDateTime.now(zi));
			cr.save(ce);
			
		}
		
		
	}
	
	public void createCar(UserDTO udto) {
		
		CarEntity ce = new CarEntity();
		if(! cr.existsById(udto.getUserCarNum())) {
			
			ce = new CarEntity(udto.getUserCarNum(), null, null, udto.getUserID());
			cr.save(ce);
		}
	}
	
	public int getParkFee(String carNum, String userId) {
		
		
		// userEntity의 주차 중 여부코드가 0 (주차 중) 일 때만 로직 실행.
		if(ur.findById(userId).get().isUserParkFlag() == false) {
			int feeRate = 8000;
			
			ZoneId zi = ZoneId.of("Asia/Seoul");
			LocalDateTime curTime = LocalDateTime.now(zi);
			
			CarEntity ce = new CarEntity();
			
			if(cr.existsById(carNum)) {
				ce = cr.findById(carNum).get();
				
			}
			int diffHour= curTime.getHour() - ce.getCarInTime().getHour();
			int fee = feeRate * diffHour;
			return fee;
			
		}
		return 0;
	}
}
