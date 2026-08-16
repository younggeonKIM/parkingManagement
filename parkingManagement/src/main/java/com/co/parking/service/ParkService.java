package com.co.parking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.parking.entity.ParkEntity;
import com.co.parking.model.ParkDTO;
import com.co.parking.repository.ParkRepository;

@Service
public class ParkService {

	@Autowired
	ParkRepository prepo;
	
	public List<ParkDTO> getAllParkList(){
		
		List<ParkEntity> li = new ArrayList();
		List<ParkDTO> list = new ArrayList();
		li = prepo.findAll();
		for(li)
		
	}
	
}
