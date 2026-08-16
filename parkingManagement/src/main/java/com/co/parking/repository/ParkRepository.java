package com.co.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.parking.entity.ParkEntity;
import com.co.parking.entity.ParkId;

@Repository
public interface ParkRepository extends JpaRepository<ParkEntity, ParkId> {

	
}
