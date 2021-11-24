package com.wx.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wx.pojo.Qman;
import com.wx.service.QmanService;

@Controller
public class QmanController {
	@Resource 
	private QmanService qmanServiceImpl;
	@RequestMapping("qiuzhi")
	public String show(String method, HttpServletRequest req,Integer qid){
		System.out.println(method);
		if(method.equals("show")){
		    System.out.println("展示了");
			List<Qman> qz = qmanServiceImpl.showAll();
			System.out.println(qz);
			req.setAttribute("QZ",qz);
			return "/jsp/qiuzhizhe/list.jsp";
		}
		if(method.equals("showtoudi")){
			List<Qman> qz = qmanServiceImpl.showTouDi();
			req.setAttribute("QZ",qz);
			System.out.println(qz);
			return "/jsp/qiuzhizhe/list2.jsp";
		}
		if(method.equals("mianshi")){
			List<Qman> qz = qmanServiceImpl.showMianshi();
			req.setAttribute("QZ",qz);
			return "/jsp/qiuzhizhe/list3.jsp";
		}
		if(method.equals("del")){
			
			int qz = qmanServiceImpl.del(qid);
			if(qz>0)
			return "/jsp/success.jsp";
			else
				return "/jsp/error.jsp";
		}
		if(method.equals("yms")){
			
			int qz = qmanServiceImpl.yms(qid);
			if(qz>0)
			return "/jsp/success.jsp";
			else
				return "/jsp/error.jsp";
		}
		if(method.equals("jj")){
			System.out.println("点击拒绝");
			int qz = qmanServiceImpl.jj(qid);
			if(qz>0)
			return "/jsp/success.jsp";
			else
				return "/jsp/error.jsp";
		}
	if(method.equals("mianshiend")){
			
			int qz = qmanServiceImpl.del(qid);
			if(qz>0)
			return "/jsp/success.jsp";
			else
				return "/jsp/error.jsp";
		}
		
		return "/jsp/error.jsp";
	}
}
