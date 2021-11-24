package com.wx.pojo;

public class Advice {
	private int id;
	private String mail;
	private String neirong;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNeirong() {
		return neirong;
	}

	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}

	@Override
	public String toString() {
		return "Advice [mail=" + mail + ", neirong=" + neirong + "]";
	}
	
}
