package com.wx.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wx.pojo.Company;
import com.wx.pojo.Job;
import com.wx.service.CompanyService;
import com.wx.service.JobService;

@Controller
public class JobController {
	@Resource 
	private JobService jobServiceImpl;
	
	@RequestMapping("job")
	public String show(String method, HttpServletRequest req,String jjy,String jms,String jname,String jwz,String jxl,String jxs,String jyh,Integer jid){
		if(method.equals("list1")){
			List<Job> job = jobServiceImpl.showAll();
			req.setAttribute("Job",job);
			return "/jsp/job/list.jsp";
		}
		if(method.equals("add1")){
			
			return "/jsp/job/add.jsp";
		}
		if(method.equals("addNow")){
			Job job = new Job();
			job.setJjy(jjy);
			job.setJms(jms);
			job.setJname(jname);
			job.setJwz(jwz);
			job.setJxl(jxl);
			job.setJxs(jxs);
			job.setJyh(jyh);
			int j = jobServiceImpl.add(job);
			if(j>0){return "/jsp/success.jsp";}return "/jsp/error.jsp";
		}
		if(method.equals("upNow")){
			Job job = new Job();
			job.setJid(jid);
			job.setJjy(jjy);
			job.setJms(jms);
			job.setJname(jname);
			job.setJwz(jwz);
			job.setJxl(jxl);
			job.setJxs(jxs);
			job.setJyh(jyh);
			System.out.println(job);
			int j = jobServiceImpl.upNow(job);
			if(j>0){return "/jsp/success.jsp";}return "/jsp/error.jsp";
		}
		if(method.equals("up1")){
			Job job = jobServiceImpl.showById(jid);
			req.setAttribute("Job",job);
			return "/jsp/job/edit.jsp";
		}
		if(method.equals("del")){
			int num  = jobServiceImpl.delById(jid);
			if(num>0){
				return "/jsp/success.jsp";
			}
			return "/jsp/error.jsp";
			
		}
		return "/jsp/error.jsp";
	}
}
