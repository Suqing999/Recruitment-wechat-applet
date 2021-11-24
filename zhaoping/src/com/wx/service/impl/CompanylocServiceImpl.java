package com.wx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wx.mapper.CompanylocMapper;
import com.wx.mapper.CompanypicMapper;
import com.wx.pojo.Companyloc;
import com.wx.service.CompanylocService;
@Service
public class CompanylocServiceImpl implements CompanylocService {
	@Resource
	private CompanylocMapper companylocMapper;

	@Override
	public int delbyid(int id) {
		
		return companylocMapper.del(id);
	}

	@Override
	public List<Companyloc> showAll() {
		return companylocMapper.showAll();
	}

	@Override
	public int add(String name, String loc) {
		return companylocMapper.add(name,loc);
	}
}
