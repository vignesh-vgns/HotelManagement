package com.vgns.pojo;

public class LoginInfo {

	String userName;
	String password;
	

	public LoginInfo(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
//get username and password from users
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginInfo [userName=" + userName + ", password=" + password + "]";
	}
	
}
