package com.co.parking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(ParkId.class)
public class ParkEntity {

	@Id
	private int parkFloor;
	
	@Id
	@Column(length=3)
	private String parkNum;
	
	private boolean parkFlag;

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
	
	
	
}
