package com.wx.service;

import java.util.List;

import com.wx.pojo.Company;
import com.wx.pojo.Companypic;


public interface CompanyService {
	List<Company> showXX();

	List<Company> showFL();

	int  up1(String xiangxi);

	Company showAll();

	int up2(String fuli);

	List<Companypic> selPic();

	List<Company> showYW();

	int upYW(String companyyewu);

	List<Company> showJL();

	int upJJ(String jianjie);
}
