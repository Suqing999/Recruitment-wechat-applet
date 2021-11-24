package com.wx.service;

import java.util.List;

import com.wx.pojo.Companyloc;

public interface CompanylocService {

	int delbyid(int id);

	List<Companyloc> showAll();

	int add(String name, String loc);

}
