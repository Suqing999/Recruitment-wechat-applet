package com.wx.pojo;

public class Company {
	private int cid;
	private String companyname;
	private String companyxiangxi;
	private String companyfuli;
	private String companyyewu;
	private String companyjianjie;
	
	
	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getCompanyyewu() {
		return companyyewu;
	}


	public void setCompanyyewu(String companyyewu) {
		this.companyyewu = companyyewu;
	}


	public String getCompanyjianjie() {
		return companyjianjie;
	}


	public void setCompanyjianjie(String companyjianjie) {
		this.companyjianjie = companyjianjie;
	}


	


	public String getCompanyname() {
		return companyname;
	}


	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}


	public String getCompanyxiangxi() {
		return companyxiangxi;
	}


	public void setCompanyxiangxi(String companyxiangxi) {
		this.companyxiangxi = companyxiangxi;
	}


	public String getCompanyfuli() {
		return companyfuli;
	}


	public void setCompanyfuli(String companyfuli) {
		this.companyfuli = companyfuli;
	}


	@Override
	public String toString() {
		return "Company [cid=" + cid + ", companyname=" + companyname + ", companyxiangxi=" + companyxiangxi
				+ ", companyfuli=" + companyfuli + ", companyyewu=" + companyyewu + ", companyjianjie=" + companyjianjie
				+ "]";
	}


}
