package com.wx.pojo;

public class User {
	private int id;
	private String username;
	private String password;
	private String name;
	private String stateuser;
	private String phone;
	private String gender;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStateuser() {
		return stateuser;
	}
	public void setStateuser(String stateuser) {
		this.stateuser = stateuser;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", stateuser=" + stateuser + ", phone=" + phone + ", gender=" + gender + "]";
	}
	
	
	
}
