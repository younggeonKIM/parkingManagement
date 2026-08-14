package com.co.parking.model;

public class User {

	private String userID;
	private String userPWD;
	private String userName;
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
	public boolean isUserParkFlag() {
		return userParkFlag;
	}
	public void setUserParkFlag(boolean userParkFlag) {
		this.userParkFlag = userParkFlag;
	}
	
	public User(String userID, String userPWD, String userName, boolean userParkFlag) {
		super();
		this.userID = userID;
		this.userPWD = userPWD;
		this.userName = userName;
		this.userParkFlag = userParkFlag;
	}
	
	
}
