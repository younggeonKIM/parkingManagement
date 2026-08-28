package com.co.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.parking.entity.CarEntity;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, String> {

}
