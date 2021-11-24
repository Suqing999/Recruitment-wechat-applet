package com.wx.pojo;

public class Companyloc {
	private int id ;
	private String companyname;
	private String loc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "Companyloc [id=" + id + ", companyname=" + companyname + ", loc=" + loc + "]";
	}
	
}
