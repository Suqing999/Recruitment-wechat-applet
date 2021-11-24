package com.wx.pojo;

public class Job {
	private int  jid;
	private String jname;
	private String jxs;
	private String jwz;
	private String jjy;
	private String jxl;
	private String jyh;
	private String jms;
	public int getJid() {
		return jid;
	}
	public void setJid(int jid) {
		this.jid = jid;
	}
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public String getJxs() {
		return jxs;
	}
	public void setJxs(String jxs) {
		this.jxs = jxs;
	}
	public String getJwz() {
		return jwz;
	}
	public void setJwz(String jwz) {
		this.jwz = jwz;
	}
	public String getJjy() {
		return jjy;
	}
	public void setJjy(String jjy) {
		this.jjy = jjy;
	}
	public String getJxl() {
		return jxl;
	}
	public void setJxl(String jxl) {
		this.jxl = jxl;
	}
	public String getJyh() {
		return jyh;
	}
	public void setJyh(String jyh) {
		this.jyh = jyh;
	}
	public String getJms() {
		return jms;
	}
	public void setJms(String jms) {
		this.jms = jms;
	}
	@Override
	public String toString() {
		return "Job [jid=" + jid + ", jname=" + jname + ", jxs=" + jxs + ", jwz=" + jwz + ", jjy=" + jjy + ", jxl="
				+ jxl + ", jyh=" + jyh + ", jms=" + jms + "]";
	}
	
	
}
