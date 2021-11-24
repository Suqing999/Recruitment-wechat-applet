package com.wx.pojo;

public class Companypic {
	private int pid ;
	private String wxpic;
	private String companyname;
	private String pic;
	
	public String getWxpic() {
		return wxpic;
	}
	public void setWxpic(String wxpic) {
		this.wxpic = wxpic;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	@Override
	public String toString() {
		return "Companypic [pid=" + pid + ", wxpic=" + wxpic + ", companyname=" + companyname + ", pic=" + pic + "]";
	}
	
	
	
	
}
