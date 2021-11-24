package com.wx.controller;



import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.wx.service.CompanypicService;

@Controller
public class CompanypicController {
	@Resource 
	private CompanypicService companypicServiceImpl;

	@RequestMapping("picmanage")
	public String del(String method , Integer pid,String companyname){
		if(method.equals("del")){
			System.out.println(pid);
			int a = companypicServiceImpl.delbyid(pid);
			if(a>0){
				return "/jsp/success.jsp";
			}
			return "/jsp/error.jsp";
		}
		
		if(method.equals("add")){
			
			return "redirect:http://localhost/tupian.html";
		}
		
	
		return "/jsp/error.jsp";
	}
	
	
	
	
	
}
