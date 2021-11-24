package com.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class textController {
	@RequestMapping("papa")
	public String nae(){
		System.out.println("nem");
		return "/login.jsp";
	}
}
