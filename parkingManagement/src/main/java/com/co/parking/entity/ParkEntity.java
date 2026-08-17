package com.co.parking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@IdClass(ParkId.class)
@Table(name="Park")
public class ParkEntity {

	@Id
	@Column(name = "parkFloor")
	private int parkFloor;
	
	@Id
	@Column(name = "parkNum", length=3)
	private String parkNum;
	
	@Column(name = "parkFlag", columnDefinition="TINYINT")
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
