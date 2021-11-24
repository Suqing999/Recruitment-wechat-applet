package com.wx.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wx.pojo.Company;
import com.wx.pojo.User;
import com.wx.service.UserService;

@Controller
public class UserController {
	@Resource 
	private UserService userServiceImpl;
	
	@RequestMapping("login")
	public String login(HttpServletRequest req,HttpSession session,String username,String password){
		String path = req.getSession().getServletContext().getRealPath("服务器资源的相对路径");
		System.out.println(path);
		User user = userServiceImpl.login(username, password);
		if(user!=null){
			session.setAttribute("id", user.getId());
			session.setAttribute("name", user.getName());
			session.setAttribute("username", username);
			session.setAttribute("state_user", user.getStateuser());
			return "/index.jsp";
		}
		req.setAttribute("error", "登录失败请重新登录");
		return "/login.jsp";
		
	}
	//userPass?usrname=${username }
	@RequestMapping("userPass")
	public String update(HttpServletRequest req, String username){
		req.setAttribute("username", username);
		return "/jsp/admin/edit.jsp";
	}
	@RequestMapping("userPass2")
	public String update(HttpSession session,HttpServletRequest req , Integer id){
		String username = req.getParameter("username");
		String p = req.getParameter("pass");
		System.out.println(id+  " " + username +" " +p);
		int up = userServiceImpl.up(id,username,p);
		if(up>0){
			return "/jsp/success.jsp";
		}else{
			return "/jsp/error.jsp";
		}
	}
			

	@RequestMapping("userClose")
	public String close(HttpSession session){
		session.invalidate();
		return "/login.jsp";
	}
	
	
	@RequestMapping("addAdmin")
	public String add(HttpSession session,String method,String username,String password,Integer id ,String name,String gender,String phone,String state_user,HttpServletRequest req){
		
		if(method.equals("addNow")){
			User u =new User();
			u.setUsername(username);
			u.setName(name);
			u.setPassword("8888");
			u.setGender(gender);
			u.setPhone(phone);
			u.setStateuser(state_user);
			int add = userServiceImpl.add(u);
			System.out.println(u);
			if(add>0){
				return "/jsp/success.jsp";
			}else{
				return "/jsp/error.jsp";
			}
				
		}else if(method.equals("addPage")){
			String 	state = (String) session.getAttribute("state_user");
			if(!state.equals("超级管理员")){
				req.setAttribute("error", "您不是超级管理员！无权操作");
				return "/jsp/error2.jsp";
			}
			return "/jsp/admin/add.jsp";
		}
		
		else if(method.equals("deladmin")){
			String 	state = (String) session.getAttribute("state_user");
			if(!state.equals("超级管理员")){
				req.setAttribute("error", "您不是超级管理员！无权操作");
				return "/jsp/error2.jsp";
			}
			int num = userServiceImpl.del(id);
			if(num>0){
				return "/jsp/success.jsp";
			}else{
				
				return "/jsp/error.jsp";
			}
		}
		
		else if(method.equals("xiugai")){
			String 	state = (String) session.getAttribute("state_user");
			if(!state.equals("超级管理员")){
				req.setAttribute("error", "您不是超级管理员！无权操作");
				return "/jsp/error2.jsp";
			}
			int num = userServiceImpl.xiugai(id);
			if(num>0){
				return "/jsp/success.jsp";
			}else{
				
				return "/jsp/error.jsp";
			}
		}
		
		
		else if(method.equals("showAll")){
			List<User> user = userServiceImpl.showAll();
			req.setAttribute("list",user);
			for(User u : user){
				System.out.println(u);
			}
			return "/jsp/admin/list.jsp";
		}
		
		return "/jsp/error.jsp";
	}
	
}
