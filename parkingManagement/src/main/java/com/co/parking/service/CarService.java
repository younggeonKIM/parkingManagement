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
		
		
		// userEntity의 주차 중 여부코드가 주차 중 (parkFlag=0) 일 때만 로직 실행.
		if(ur.findById(userId).get().isUserParkFlag() == false) {
			int earlyFee = 2000;
			int feeRate = 4000;
			int fee = 0;
			ZoneId zi = ZoneId.of("Asia/Seoul");
			
			LocalDateTime curTime = LocalDateTime.now(zi);
			
			CarEntity ce = new CarEntity();
			LocalDateTime carInTime = null;
			if(cr.existsById(carNum)) {
				
				ce = cr.findById(carNum).get();
				carInTime = ce.getCarInTime();
			}
			
			
			
			
			
			int curTimeHour = curTime.getHour();
			int carInTimeHour = carInTime.getHour();
			int curTimeMin = curTime.getMinute();
			int carInTimeMin = carInTime.getMinute();
			int diffHour = (curTimeHour*60 + curTimeMin) - (carInTimeHour*60 + carInTimeMin); 
			
			
			// 날짜가 다른 경우에는 날짜 차이까지 분으로 환산한 후 주차 요금 계산
			if(curTime.getDayOfYear()!=carInTime.getDayOfYear()) {
				
				int curTimeDay = curTime.getDayOfYear();
				int carInTimeDay = carInTime.getDayOfYear();
				diffHour = ((curTimeDay-carInTimeDay)*1440+curTimeHour*60 + curTimeMin) - (carInTimeHour*60 + carInTimeMin);
				fee= (diffHour/30) * feeRate;
				return fee;
			}
			// 날짜가 같은 경우, 시간 차이만 분으로 환산 후 주차 요금 계산
			else {
				
				if(diffHour < 30) {
					
					// 30분 전에 주차장에서 출차한 경우 조출 서비스 할인 적용
					fee = earlyFee;
				} else {
					
					// 30분 이후부터는 30분 단위 주차요금 계산
					fee= (diffHour/30) * feeRate;
				}
				
				return fee;
			}
			
			
		}
		// userEntity의 주차 중 여부코드가 주차 중이 아님(parkFlag=1) 일 때만 로직 실행.
		return 0;
	}
	public LocalDateTime getCarInTime(String carNum) {
		
		if(cr.findById(carNum).isPresent()) {
			
			LocalDateTime ldt = cr.findById(carNum).get().getCarInTime();
			return ldt;
		} else {
			
			return null;
		}
		
	}
	
	public void doCheckout(String carnum) {
		
		LocalDateTime carOutTime = LocalDateTime.now();
		if(cr.existsById(carnum)) {
			CarEntity ce = cr.findById(carnum).get();
			ce.setCarOutTime(carOutTime);
			cr.save(ce);
			
		}
		
		
	}
	
}
