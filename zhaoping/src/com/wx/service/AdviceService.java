package com.wx.service;

import java.util.List;

import com.wx.pojo.Advice;

public interface AdviceService {
	
	List<Advice> showAll();

	int del(int id);

	int add(String lxfs, String yj);

	
}
