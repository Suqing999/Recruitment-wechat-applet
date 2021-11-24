package com.wx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wx.mapper.QloginMapper;
import com.wx.pojo.Qlogin;
import com.wx.service.QloginService;

@Service
public class QloginServiceImpl implements QloginService {
	@Resource
	private QloginMapper qloginMapper;
	@Override
	public Qlogin login(String username, String password) {
		
		return qloginMapper.login(username,password);
	}
	@Override
	public int regist(String name, String username, String password) {
		
		return qloginMapper.regsit(name,username,password);
	}
	@Override
	public int wangji(String name, String username, String newpassword) {
		// TODO Auto-generated method stub
		return qloginMapper.wj(name,username,newpassword);
	}

}
