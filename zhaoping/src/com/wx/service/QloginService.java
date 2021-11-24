package com.wx.service;

import java.util.List;

import com.wx.pojo.Qlogin;

public interface QloginService {
	Qlogin login(String username,String password);

	int regist(String name, String username, String password);

	int wangji(String name, String username, String newpassword);
}
 