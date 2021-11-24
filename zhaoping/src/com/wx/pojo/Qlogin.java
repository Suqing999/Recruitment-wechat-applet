package com.wx.pojo;

public class Qlogin {
	private int qid;
	private String username;
	private String password;
	private String name;
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
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
		return "Qlogin [qid=" + qid + ", username=" + username + ", password=" + password + ", name=" + name + "]";
	}
	
}
