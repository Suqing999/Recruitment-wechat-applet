package com.wx.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wx.pojo.Companyloc;
import com.wx.service.CompanylocService;


@Controller
public class CompanylocController {
	@Resource 
	private CompanylocService companylocServiceImpl;
	@RequestMapping("locmanage")
	public String del(HttpServletRequest req,String method , Integer id){
		if(method.equals("del")){
			int a = companylocServiceImpl.delbyid(id);
			if(a>0){
				return "/jsp/success.jsp";
			}
			return "/jsp/error.jsp";
		}
		
		
		if(method.equals("show")){
			List<Companyloc> loc = companylocServiceImpl.showAll();	
			req.setAttribute("loc2", loc);
			return "/jsp/company/list3.jsp";
		}
		if(method.equals("addshow")){
			return "/jsp/company/add.jsp";
		}
		
		if(method.equals("add")){
			
			String loc =  req.getParameter("loc");
			int num = companylocServiceImpl.add("某教育公司",loc);	
			if(num>0){
				return "/jsp/success.jsp";
			}
			return "/jsp/error.jsp";
		}
		return "/jsp/error.jsp";
	}
	
			}

