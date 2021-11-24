package com.wx.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wx.pojo.Advice;
import com.wx.pojo.Company;
import com.wx.service.AdviceService;
import com.wx.service.CompanyService;

@Controller
public class AdviceController {
	@Resource 
	private AdviceService adviceServiceImpl;
	
	@RequestMapping("advice")
	public String show(HttpServletRequest req){
	
			List<Advice> adv = adviceServiceImpl.showAll();
			req.setAttribute("YJ",adv);
			return "/jsp/yijian/list.jsp";
		}
	
	@RequestMapping("yijian")
	public String del(Integer id){
	
			int adv = adviceServiceImpl.del(id);
			if(adv>0){
				return "/jsp/success.jsp";
			}else{
				return "/jsp/error.jsp";
			}
			
		}
}
