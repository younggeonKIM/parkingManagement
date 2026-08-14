package com.co.parking.model;


public class Car {
	
	private String carNum;
	private String carInTime;
	private String carOutTime;
	private String carSort;
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getCarInTime() {
		return carInTime;
	}
	public void setCarInTime(String carInTime) {
		this.carInTime = carInTime;
	}
	public String getCarOutTime() {
		return carOutTime;
	}
	public void setCarOutTime(String carOutTime) {
		this.carOutTime = carOutTime;
	}
	public String getCarSort() {
		return carSort;
	}
	public void setCarSort(String carSort) {
		this.carSort = carSort;
	}
	
	public Car(String carNum, String carInTime, String carOutTime, String carSort) {
		super();
		this.carNum = carNum;
		this.carInTime = carInTime;
		this.carOutTime = carOutTime;
		this.carSort = carSort;
	}
	
	
}
