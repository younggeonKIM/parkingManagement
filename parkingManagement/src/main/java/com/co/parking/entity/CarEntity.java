package com.co.parking.entity;

import java.sql.Timestamp;

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
	private Timestamp carInTime;
	
	@Column(name="carOutTime")
	private Timestamp carOutTime;
	
	@Column(name="carUserId", length=15)
	private String carUserId;

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public Timestamp getCarInTime() {
		return carInTime;
	}

	public void setCarInTime(Timestamp carInTime) {
		this.carInTime = carInTime;
	}

	public Timestamp getCarOutTime() {
		return carOutTime;
	}

	public void setCarOutTime(Timestamp carOutTime) {
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

	public CarEntity(String carNum, Timestamp carInTime, Timestamp carOutTime, String carUserId) {
		super();
		this.carNum = carNum;
		this.carInTime = carInTime;
		this.carOutTime = carOutTime;
		this.carUserId = carUserId;
	}
	
	
}
