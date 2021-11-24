package com.wx.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.wx.pojo.Company;
import com.wx.pojo.Companyloc;
import com.wx.pojo.Companypic;
import com.wx.pojo.Job;
import com.wx.pojo.Qlogin;
import com.wx.pojo.Qman;
import com.wx.service.AdviceService;
import com.wx.service.CompanyService;
import com.wx.service.CompanylocService;
import com.wx.service.CompanypicService;
import com.wx.service.JobService;
import com.wx.service.QloginService;
import com.wx.service.QmanService;
import com.wx.service.impl.QmanServiceImpl;

@Controller
public class WxController {
	
	@Resource 
	private AdviceService adviceServiceImpl;
	@Resource 
	private QmanService qmanServiceImpl;
	@Resource 
	private JobService jobServiceImpl;
	@Resource 
	private QloginService qloginServiceImpl;
	@Resource 
	private CompanyService companyServiceImpl;
	@Resource 
	private CompanypicService companypicServiceImpl;
	@RequestMapping("getcompany")
	@ResponseBody
    public void buttonTest(HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
      
        System.out.println("后台接入了");
		Company com = companyServiceImpl.showAll();	
        Gson gson=new Gson();
        String json = gson.toJson(com);
		System.out.println(json);
        //返回值给微信小程序
        Writer out = response.getWriter(); 
        out.write(json);
        out.flush(); 
    }
	@RequestMapping("chakantoudishuliang")
	@ResponseBody
    public void chakantoudishuliang(HttpServletResponse response,Integer qid) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
      
        System.out.println("注册了");
		int num = qmanServiceImpl.shuliang(qid); 
        //返回值给微信小程序
		if(num>=1){
			  Writer out = response.getWriter(); 
		        out.write("you");
		        out.flush(); 
		}else{
			  Writer out = response.getWriter(); 
		        out.write("meiyou");
		        out.flush(); 
		}
      
    }
	@RequestMapping("registQQ")
	@ResponseBody
    public void registQQ (HttpServletResponse response,String name,String username,String password) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
      
        System.out.println("注册了");
		int num = qloginServiceImpl.regist(name,username,password); 
        //返回值给微信小程序
        Writer out = response.getWriter(); 
        out.write(num);
        out.flush(); 
    }
	@RequestMapping("ishavejianli")
	@ResponseBody
    public void ishavejianli (HttpServletResponse response,Integer qid) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
      
        System.out.println("是否有简历");
		int num = qmanServiceImpl.ishave(qid); 
        //返回值给微信小程序
		if(num>0){
			 Writer out = response.getWriter(); 
		        out.write("success");
		        out.flush(); 
		}else{
			 Writer out = response.getWriter(); 
		        out.write("error");
		        out.flush(); 
		}
       
    }
	
	@RequestMapping("getxingxi")
	@ResponseBody
    public void getxingxi (HttpServletResponse response,Integer qid) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
        System.out.println(qid);
        Qman q = qmanServiceImpl.selectOneByqid(qid);
        System.out.println(q);
        Gson gson=new Gson();
        String json = gson.toJson(q);
		System.out.println(json);
        //返回值给微信小程序
        Writer out = response.getWriter(); 
        out.write(json);
        out.flush(); 
    }
	
	
	@RequestMapping("wangjiQQ")
	@ResponseBody
    public void wangji(HttpServletResponse response,String username,String newpassword,String name) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
      
        System.out.println("忘记密码");
		/*Company com = companyServiceImpl.showAll();	
        Gson gson=new Gson();
        String json = gson.toJson(com);
		System.out.println(json);*/
        //返回值给微信小程序
        int num = qloginServiceImpl.wangji(name,username,newpassword);
        System.out.println(num);
        if(num>0){
        	  Writer out = response.getWriter(); 
              out.write("成功");
              out.flush(); 
        }else{
        	  Writer out = response.getWriter(); 
              out.write("error");
              out.flush(); 
        }
      
    }
	
	
	@RequestMapping("toudijob")
	@ResponseBody
    public void toudi(HttpServletResponse response,int qid,int jid) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
      
        System.out.println("投递职位");
		/*Company com = companyServiceImpl.showAll();	
        Gson gson=new Gson();
        String json = gson.toJson(com);
		System.out.println(json);*/
        //返回值给微信小程序
        int num0 = qmanServiceImpl.tdbiaoji(qid,jid);
        //先查询是否有投递，有投递就不进行投递
        int num1  = jobServiceImpl.searchtoudi(qid,jid);
        if(num1>0){ //有投递
        	 Writer out = response.getWriter(); 
             out.write("error1");
             out.flush(); 
        }else{
        	int num2 = jobServiceImpl.toudi(qid,jid);
            System.out.println(num2);
            if(num2>0){
            	  Writer out = response.getWriter(); 
                  out.write("成功");
                  out.flush(); 
            }else{
            	  Writer out = response.getWriter(); 
                  out.write("error2");
                  out.flush(); 
            }
        }
        
      
    }
	
	
	@RequestMapping("shoucangjob")
	@ResponseBody
    public void scjob(HttpServletResponse response,int qid,int jid) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
      
        System.out.println("收藏职位");
        System.out.println(qid+"   "+ jid);
		/*Company com = companyServiceImpl.showAll();	
        Gson gson=new Gson();
        String json = gson.toJson(com);
		System.out.println(json);*/
        //返回值给微信小程序
        
        //先查询是否有投递，有投递就不进行投递
        int num1  = jobServiceImpl.searchsc(qid,jid);
        if(num1>0){ //有投递
        	 Writer out = response.getWriter(); 
             out.write("error1");
             out.flush(); 
        }else{
        	int num2 = jobServiceImpl.shoucang(qid,jid);
            System.out.println(num2);
            if(num2>0){
            	  Writer out = response.getWriter(); 
                  out.write("成功");
                  out.flush(); 
            }else{
            	  Writer out = response.getWriter(); 
                  out.write("error2");
                  out.flush(); 
            }
        }
        
      
    }
	
	@RequestMapping("yj")
	@ResponseBody
    public void yijian(HttpServletResponse response,String lxfs,String yj) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
      
        System.out.println("添加意见");
		/*Company com = companyServiceImpl.showAll();	
        Gson gson=new Gson();
        String json = gson.toJson(com);
		System.out.println(json);*/
        //返回值给微信小程序
        int num = adviceServiceImpl.add(lxfs,yj);
        Writer out = response.getWriter(); 
        out.write(num);
        out.flush(); 
    }
	
	
	@RequestMapping("toudijianli2")
	@ResponseBody
    public void toudijianli2(HttpServletResponse response,String nianfeng,int qid,String address,String content,String email,String gender,int gzjy,String jobtitle,int mqzt,String name,int qwxz,int qzxz,String tel,int zgxl) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
      
        
        String qgzjy="";
    
        String qxl="";
        String qzt="";
        String qmoney="";
        String qgzxz="";
        System.out.println("投递简历");
        System.out.println(qid);//人员id
        System.out.println(address);//居住地址
        System.out.println(content);//自我介绍
        System.out.println(email);//邮箱
        System.out.println(gender);//性别
        System.out.println(gzjy);//工作经验
        if(gzjy==0){
        	qgzjy="无经验";
        }else if(gzjy==1){qgzjy="1年以下";}
        else if(gzjy==2){qgzjy="1-3年";}
        else if(gzjy==1){qgzjy="3-5年";}
        else if(gzjy==1){qgzjy="5-10年";}
        else if(gzjy==1){qgzjy="10年以上";}
        System.out.println(jobtitle);//求职意向
        System.out.println(mqzt);//目前状态
        if(mqzt==0){qzt="我目前已离职，可快速到岗";}
        else if(mqzt==1){qzt="我目前在职，但考虑换个新环境";}
        else if(mqzt==2){qzt="观望有好的 机会再考虑";}
        else if(mqzt==3){qzt="目前暂无跳槽打算";}
        else if(mqzt==4){qzt="应届毕业生";}
        
        System.out.println(name);
        System.out.println(qwxz);
        if(qwxz==0){qmoney="1千~2千/月";}
        else if(qwxz==1){qmoney="2千~3千/月";}
        else if(qwxz==2){qmoney="3千~4千/月";}
        else if(qwxz==3){qmoney="4千~5千/月";}
        else if(qwxz==4){qmoney="5千~1万/月";}
        else if(qwxz==5){qmoney="1万以上/月";}
        System.out.println(qzxz);
        if(qzxz==0){qgzxz="校园招聘";}
        else if(qzxz==0){qgzxz="社会招聘";}
        else if(qzxz==0){qgzxz="实习";}
        System.out.println(tel);
        System.out.println(zgxl);
		if(zgxl==0){
			qxl="初中";
		}else if(zgxl==1){qxl="高中";}
		else if(zgxl==2){qxl="中技";}
		else if(zgxl==3){qxl="中专";}
		else if(zgxl==4){qxl="大专";}
		else if(zgxl==5){qxl="本科";}
		else if(zgxl==6){qxl="硕士";}
		else if(zgxl==7){qxl="博士";}
		else if(zgxl==8){qxl="博士后";}
		/*System.out.println(showAll);
        Gson gson=new Gson();
        String json = gson.toJson(showAll);
		System.out.println(json);
        //返回值给微信小程序
        Writer out = response.getWriter(); 
        out.write(json);
        out.flush(); */
		
		int num = qmanServiceImpl.upOne(qid,jobtitle,name,gender,nianfeng,qxl,qgzjy,address,email,tel,qgzxz,qzt,qmoney,content);
		
		
		if(num>0){
			 Writer out = response.getWriter(); 
		        out.write("su");
		        out.flush(); 
		}
		
		
		
    }
	
	@RequestMapping("toudijianli")
	@ResponseBody
    public void toudijianli(HttpServletResponse response,String nianfeng,int qid,String address,String content,String email,String gender,int gzjy,String jobtitle,int mqzt,String name,int qwxz,int qzxz,String tel,int zgxl) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
      
        
        String qgzjy="";
    
        String qxl="";
        String qzt="";
        String qmoney="";
        String qgzxz="";
        System.out.println("投递简历");
        System.out.println(qid);//人员id
        System.out.println(address);//居住地址
        System.out.println(content);//自我介绍
        System.out.println(email);//邮箱
        System.out.println(gender);//性别
        System.out.println(gzjy);//工作经验
        if(gzjy==0){
        	qgzjy="无经验";
        }else if(gzjy==1){qgzjy="1年以下";}
        else if(gzjy==2){qgzjy="1-3年";}
        else if(gzjy==1){qgzjy="3-5年";}
        else if(gzjy==1){qgzjy="5-10年";}
        else if(gzjy==1){qgzjy="10年以上";}
        System.out.println(jobtitle);//求职意向
        System.out.println(mqzt);//目前状态
        if(mqzt==0){qzt="我目前已离职，可快速到岗";}
        else if(mqzt==1){qzt="我目前在职，但考虑换个新环境";}
        else if(mqzt==2){qzt="观望有好的 机会再考虑";}
        else if(mqzt==3){qzt="目前暂无跳槽打算";}
        else if(mqzt==4){qzt="应届毕业生";}
        
        System.out.println(name);
        System.out.println(qwxz);
        if(qwxz==0){qmoney="1千~2千/月";}
        else if(qwxz==1){qmoney="2千~3千/月";}
        else if(qwxz==2){qmoney="3千~4千/月";}
        else if(qwxz==3){qmoney="4千~5千/月";}
        else if(qwxz==4){qmoney="5千~1万/月";}
        else if(qwxz==5){qmoney="1万以上/月";}
        System.out.println(qzxz);
        if(qzxz==0){qgzxz="校园招聘";}
        else if(qzxz==0){qgzxz="社会招聘";}
        else if(qzxz==0){qgzxz="实习";}
        System.out.println(tel);
        System.out.println(zgxl);
		if(zgxl==0){
			qxl="初中";
		}else if(zgxl==1){qxl="高中";}
		else if(zgxl==2){qxl="中技";}
		else if(zgxl==3){qxl="中专";}
		else if(zgxl==4){qxl="大专";}
		else if(zgxl==5){qxl="本科";}
		else if(zgxl==6){qxl="硕士";}
		else if(zgxl==7){qxl="博士";}
		else if(zgxl==8){qxl="博士后";}
		/*System.out.println(showAll);
        Gson gson=new Gson();
        String json = gson.toJson(showAll);
		System.out.println(json);
        //返回值给微信小程序
        Writer out = response.getWriter(); 
        out.write(json);
        out.flush(); */
		
		int num = qmanServiceImpl.insertOne(qid,jobtitle,name,gender,nianfeng,qxl,qgzjy,address,email,tel,qgzxz,qzt,qmoney,content);
		
		
		if(num>0){
			 Writer out = response.getWriter(); 
		        out.write("添加成功");
		        out.flush(); 
		}
		
		
		
    }

	
	@RequestMapping("getpic")
	@ResponseBody
    public void getpic(HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
      
        System.out.println("后台接入了");
		List<Companypic> showAll = companypicServiceImpl.showAll();
		System.out.println(showAll);
        Gson gson=new Gson();
        String json = gson.toJson(showAll);
		System.out.println(json);
        //返回值给微信小程序
        Writer out = response.getWriter(); 
        out.write(json);
        out.flush(); 
    }

	@RequestMapping("getjob")
	@ResponseBody
    public void getscjob(HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
      
        System.out.println("后台接入了");
		List<Job> showscAll = jobServiceImpl.showscAll();
		System.out.println(showscAll);
        Gson gson=new Gson();
        String json = gson.toJson(showscAll);
		System.out.println(json);
        //返回值给微信小程序
        Writer out = response.getWriter(); 
        out.write(json);
        out.flush(); 
    }
	@RequestMapping("shifouyoujianli")
	@ResponseBody
    public void shifouyoujianli(HttpServletResponse response,Integer qid) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
      
        System.out.println("是否有简历");
		int num = qmanServiceImpl.ishavejianli(qid);
		
		if(num<=0){
			  Writer out = response.getWriter(); 
		        out.write("meiyou");
		        out.flush(); 
		}
        //返回值给微信小程序
      
    }

	
	
	@RequestMapping("getscjob")
	@ResponseBody
    public void getshoucangjob(HttpServletResponse response,int qid) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
      
        System.out.println("收藏页面");
		List<Job> showscAll = jobServiceImpl.showshoucangAll(qid);
		System.out.println(showscAll);
        Gson gson=new Gson();
        String json = gson.toJson(showscAll);
		System.out.println(json);
        //返回值给微信小程序
        Writer out = response.getWriter(); 
        out.write(json);
        out.flush(); 
    }
	
	@RequestMapping("gettoudijob")
	@ResponseBody
    public void gettoudijob(HttpServletResponse response,int qid) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
      
        System.out.println("投递页面");
		List<Job> showscAll = jobServiceImpl.showtoudiAll(qid);
		System.out.println(showscAll);
        Gson gson=new Gson();
        String json = gson.toJson(showscAll);
		System.out.println(json);
        //返回值给微信小程序
        Writer out = response.getWriter(); 
        out.write(json);
        out.flush(); 
    }
	/**tdztjob*/
	@RequestMapping("ztjob")
	@ResponseBody
    public void toudizhuantai(HttpServletResponse response,int qid,int jid) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
      
        System.out.println("投递状态");
		int zt = jobServiceImpl.tdzt(qid,jid);
		System.out.println(zt);
        if(zt==0){
        	  Writer out = response.getWriter(); 
              out.write("num1");
              out.flush(); 
        }if(zt==1){
        	 Writer out = response.getWriter(); 
             out.write("num2");
             out.flush(); 
        }if(zt==2){
       	 Writer out = response.getWriter(); 
         out.write("num3");
         out.flush(); 
    }	
    }
	
	
	@RequestMapping("getjobsh")
	@ResponseBody
    public void getscjobsh(HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
      
        System.out.println("后台接入了");
		List<Job> showscAll = jobServiceImpl.showshAll();
		System.out.println(showscAll);
        Gson gson=new Gson();
        String json = gson.toJson(showscAll);
		System.out.println(json);
        //返回值给微信小程序
        Writer out = response.getWriter(); 
        out.write(json);
        out.flush(); 
    }
	
	
	@RequestMapping("getjobmh")
	@ResponseBody
    public void getscjobmh(HttpServletResponse response, String jname) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
      
        System.out.println("后台接入了");
		List<Job> showscAll = jobServiceImpl.showmhAll(jname);
		System.out.println(showscAll);
        Gson gson=new Gson();
        String json = gson.toJson(showscAll);
		System.out.println(json);
        //返回值给微信小程序
        Writer out = response.getWriter(); 
        out.write(json);
        out.flush(); 
    }
	
	
	
	@RequestMapping("loginQman")
	@ResponseBody
    public void loginQman(HttpServletResponse response,String username,String password) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
      
        System.out.println("登录");
        System.out.println(username);
        System.out.println(password);
		Qlogin login = qloginServiceImpl.login(username, password);
		System.out.println(login);
		if(login != null){
			Gson gson=new Gson();
			 Writer out = response.getWriter();
			  String json = gson.toJson(login);
			//System.out.println(json);
		     out.write(json);
		     out.flush(); 
		}else
		{ Writer out = response.getWriter(); 
        out.write("error");
        out.flush(); 
			
		}        /*Gson gson=new Gson();
        String json = gson.toJson();*/
		//System.out.println(json);
        //返回值给微信小程序
       
    }

	
}
