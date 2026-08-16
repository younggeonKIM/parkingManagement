package com.co.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.parking.entity.ParkEntity;
import com.co.parking.entity.ParkId;

public interface ParkRepository extends JpaRepository<ParkEntity, ParkId> {

	
}
