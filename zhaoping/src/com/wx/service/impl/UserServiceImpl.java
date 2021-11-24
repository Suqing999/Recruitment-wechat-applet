package com.wx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx.mapper.UserMapper;
import com.wx.pojo.User;
import com.wx.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User login(String username, String password) {
		return userMapper.selByusername(username,password);
	}

	@Override
	public int add(User u) {
		
		return userMapper.add(u);
	}

	@Override
	public List<User> showAll() {

		return userMapper.showAll();
		
	}

	
	@Override
	public int up(int id, String username, String passowrd) {
	
		return userMapper.up(id,username,passowrd);
	}

	@Override
	public int del(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.del(id);
	}

	@Override
	public int xiugai(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.xiugai(id);
	} 

}
