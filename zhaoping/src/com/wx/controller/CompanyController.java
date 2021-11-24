package com.wx.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.wx.pojo.Company;
import com.wx.pojo.Companypic;
import com.wx.service.CompanyService;

@Controller
public class CompanyController {
	@Resource 
	private CompanyService companyServiceImpl;
	
	@RequestMapping("company")
	public String show(String jianjie,String yewu ,String method, HttpServletRequest req,String xiangxi,String fuli){
		if(method.equals("upjj")){
			int num = companyServiceImpl.upJJ(jianjie);
			if(num>0){
				return "/jsp/success.jsp";
			}else{
				return "/jsp/error.jsp";
			}
			
		}
			
		if(method.equals("upyw")){
			int num = companyServiceImpl.upYW(yewu);
			if(num>0){
				return "/jsp/success.jsp";
			}else{
				return "/jsp/error.jsp";
			}
			
		}
		
		if(method.equals("list5")){
			List<Company> company = companyServiceImpl.showJL();
			req.setAttribute("JJ",company);
			return "/jsp/company/list5.jsp";
		}
		
		if(method.equals("list4")){
			List<Company> company = companyServiceImpl.showYW();
			req.setAttribute("YW",company);
			return "/jsp/company/list4.jsp";
		}
		if(method.equals("list1")){
			List<Company> company = companyServiceImpl.showXX();
			req.setAttribute("XX",company);
			return "/jsp/company/list.jsp";
		}
		else if(method.equals("list2")){
			List<Company> company = companyServiceImpl.showFL();
			req.setAttribute("FL",company);
			return "/jsp/company/list2.jsp";
		}else if(method.equals("updata")){
			return "/jsp/company/edit.jsp";
		}else if(method.equals("updata2")){
			return "/jsp/company/edit2.jsp";
		}else if(method.equals("updata3")){
			return "/jsp/company/edit3.jsp";
		}else if(method.equals("updata4")){
			return "/jsp/company/edit4.jsp";
		}
		else if(method.equals("updataNow")){
			System.out.println(xiangxi);
			companyServiceImpl.up1(xiangxi);
			//Company showAll = companyServiceImpl.showAll();
			System.out.println("ok2");
			return "/jsp/success.jsp";
		}
		else if(method.equals("updataNow2")){
			System.out.println(fuli);
			companyServiceImpl.up2(fuli);
			//Company showAll = companyServiceImpl.showAll();
			System.out.println("ok2");
			return "/jsp/success.jsp";
		}else if(method.equals("list3")){
			List<Companypic> selPic = companyServiceImpl.selPic();
			req.setAttribute("pic2", selPic);
			System.out.println(selPic);
			return "/jsp/company/picture.jsp";
		}
		return "/jsp/error.jsp";
	}
}
