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
			int earlyFee = 2000;
			int feeRate = 4000;
			int fee = 0;
			ZoneId zi = ZoneId.of("Asia/Seoul");
			LocalDateTime curTime = LocalDateTime.now(zi);
			
			CarEntity ce = new CarEntity();
			
			if(cr.existsById(carNum)) {
				ce = cr.findById(carNum).get();
				
			}
			
			int curTimeHour = curTime.getHour();
			int carInTimeHour = ce.getCarInTime().getHour();
			int curTimeMin = curTime.getMinute();
			int carInTimeMin = ce.getCarInTime().getMinute();
			int diffHour = (curTimeHour*60 + curTimeMin) - (carInTimeHour*60 + carInTimeMin); 
			
			if(diffHour < 30) {
				
				// 30분 전에 주차장에서 출차한 경우 조출 서비스 할인 적용
				fee = earlyFee;
			} else {
				
				// 30분 이후부터는 30분 단위 주차요금 계산
				fee= (diffHour/30) * feeRate;
			}
			
			return fee;
			
		}
		return 0;
	}
}
