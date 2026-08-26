package com.co.parking.model;

public class ParkDTO {

	private int parkFloor;
	private String parkNum;
	private boolean parkFlag;
	private String parkCarNum;
	public int getParkFloor() {
		return parkFloor;
	}
	public void setParkFloor(int parkFloor) {
		this.parkFloor = parkFloor;
	}
	public String getParkNum() {
		return parkNum;
	}
	public void setParkNum(String parkNum) {
		this.parkNum = parkNum;
	}
	public boolean isParkFlag() {
		return parkFlag;
	}
	public void setParkFlag(boolean parkFlag) {
		this.parkFlag = parkFlag;
	}
	
	
	public String getParkCarNum() {
		return parkCarNum;
	}
	public void setParkCarNum(String parkCarNum) {
		this.parkCarNum = parkCarNum;
	}
	@Override
	public String toString() {
		return "ParkDTO [parkFloor=" + parkFloor + ", parkNum=" + parkNum + ", parkFlag=" + parkFlag + ", parkCarNum="
				+ parkCarNum + "]";
	}
	public ParkDTO(int parkFloor, String parkNum, boolean parkFlag, String parkCarNum) {
		super();
		this.parkFloor = parkFloor;
		this.parkNum = parkNum;
		this.parkFlag = parkFlag;
		this.parkCarNum = parkCarNum;
	}
	public ParkDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
