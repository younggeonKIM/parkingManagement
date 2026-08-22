package com.co.parking.model;

public class UserDTO {

	private String userID;
	private String userPWD;
	private String userName;
	private String userCarNum;
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
	
	public UserDTO(String userID, String userPWD, String userName, boolean userParkFlag) {
		super();
		this.userID = userID;
		this.userPWD = userPWD;
		this.userName = userName;
		this.userParkFlag = userParkFlag;
	}
	
	
}
