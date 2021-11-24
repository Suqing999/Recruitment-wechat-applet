package com.wx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wx.mapper.CompanyMapper;
import com.wx.mapper.CompanypicMapper;
import com.wx.pojo.Companypic;
import com.wx.service.CompanypicService;

@Service
public class CompanypicServiceImpl implements CompanypicService {
	@Resource
	private CompanypicMapper companypicMapper;

	@Override
	public int delbyid(int id) {
		
		return companypicMapper.del(id);
	}

	@Override
	public List<Companypic> showAll() {
		// TODO Auto-generated method stub
		return companypicMapper.showAll();
	}
	
}
