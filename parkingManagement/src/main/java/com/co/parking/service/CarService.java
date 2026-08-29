package com.co.parking.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.parking.entity.CarEntity;
import com.co.parking.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	CarRepository cr;
	
	public void reservCar(String carNum) {
		
		if(cr.existsById(carNum)) {
			CarEntity ce = cr.findById(carNum).get();
			ce.setCarInTime(LocalDateTime.now());
			cr.save(ce);
			
		}
		
		
	}
	
}
