package com.wx.service;

import java.util.List;

import com.wx.pojo.Companypic;

public interface CompanypicService {
	int delbyid(int id);

	List<Companypic> showAll();
}
