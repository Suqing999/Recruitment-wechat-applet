package com.wx.service;

import java.util.List;

import com.wx.pojo.User;

public interface UserService {
	User login(String username,String password);
	
	int add(User u);

	List<User> showAll();

	
	int up(int  id, String username, String p);

	int del(Integer id);

	int xiugai(Integer id);
	
}
