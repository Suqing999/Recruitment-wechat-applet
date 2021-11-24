package com.wx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wx.mapper.AdviceMapper;
import com.wx.mapper.CompanyMapper;
import com.wx.pojo.Advice;
import com.wx.service.AdviceService;
@Service
public class AdviceServiceImpl implements AdviceService {
	@Resource
	private AdviceMapper adviceMapper;

	@Override
	public List<Advice> showAll() {
		
		return adviceMapper.show();
	}

	@Override
	public int del(int id) {
		return adviceMapper.del(id);
	}

	@Override
	public int add(String lxfs, String yj) {
		// TODO Auto-generated method stub
		return adviceMapper.add(lxfs,yj);
	}

	

}
