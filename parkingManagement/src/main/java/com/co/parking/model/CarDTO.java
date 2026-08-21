package com.co.parking.model;

import java.sql.Timestamp;

public class CarDTO {
	
	private String carNum;
	private Timestamp carInTime;
	private Timestamp carOutTime;
	private String carSort;
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
	public String getCarSort() {
		return carSort;
	}
	public void setCarSort(String carSort) {
		this.carSort = carSort;
	}
	
	public CarDTO(String carNum, Timestamp carInTime, Timestamp carOutTime, String carSort) {
		super();
		this.carNum = carNum;
		this.carInTime = carInTime;
		this.carOutTime = carOutTime;
		this.carSort = carSort;
	}
	
	
}
