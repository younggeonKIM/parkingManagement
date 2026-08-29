package com.co.parking.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Car")
public class CarEntity {

	@Id
	@Column(name="carNum")
	private String carNum;
	
	@Column(name="carInTime")
	private LocalDateTime carInTime;
	
	@Column(name="carOutTime")
	private LocalDateTime carOutTime;
	
	@Column(name="carUserId", length=15)
	private String carUserId;

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	

	public LocalDateTime getCarInTime() {
		return carInTime;
	}

	public void setCarInTime(LocalDateTime carInTime) {
		this.carInTime = carInTime;
	}

	public LocalDateTime getCarOutTime() {
		return carOutTime;
	}

	public void setCarOutTime(LocalDateTime carOutTime) {
		this.carOutTime = carOutTime;
	}

	public String getCarUserId() {
		return carUserId;
	}

	public void setCarUserId(String carUserId) {
		this.carUserId = carUserId;
	}

	
	
	public CarEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarEntity(String carNum, LocalDateTime carInTime, LocalDateTime carOutTime, String carUserId) {
		super();
		this.carNum = carNum;
		this.carInTime = carInTime;
		this.carOutTime = carOutTime;
		this.carUserId = carUserId;
	}
	
	
}
