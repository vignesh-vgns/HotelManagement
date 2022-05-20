package com.vgns.pojo;

public class LoginInfo {

	String userName;
	String mail;
	String mobile;
	String address;
	String password;
	

	public LoginInfo(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public LoginInfo(String userName, String mail, String mobile, String address, String password) {
		super();
		this.userName = userName;
		this.mail = mail;
		this.mobile = mobile;
		this.address = address;
		this.password = password;
	}
//get username and password from users
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMail() {
		return mail;
	}
	public String getMobile(){
		return mobile;
	}
	public String getAddress() {
		return address;
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
