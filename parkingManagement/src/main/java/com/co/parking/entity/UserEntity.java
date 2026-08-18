package com.co.parking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class UserEntity {

	@Id
	@Column(name="userID", length=15)
	private String userID;
	
	@Column(name="userPWD", length=15)
	private String userPWD;
	
	@Column(name="userName", length=10)
	private String userName;
	
	@Column(name="userCarNum", length=10)
	private String userCarNum;
	
	@Column(name="userParkFlag", columnDefinition="TINYINT")
	private boolean userParkFlag;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPWD() {
		return userPWD;
	}

	public void setUserPWD(String userPWD) {
		this.userPWD = userPWD;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCarNum() {
		return userCarNum;
	}

	public void setUserCarNum(String userCarNum) {
		this.userCarNum = userCarNum;
	}

	public boolean isUserParkFlag() {
		return userParkFlag;
	}

	public void setUserParkFlag(boolean userParkFlag) {
		this.userParkFlag = userParkFlag;
	}
	
	
	
}
