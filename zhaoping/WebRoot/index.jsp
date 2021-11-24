<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>招聘管理系统</TITLE> 
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<FRAMESET frameSpacing=0 rows=80,* frameBorder=0>
	<FRAME name=top src="top.jsp" frameBorder=0 noResize
		scrolling=no>
	<FRAMESET frameSpacing=0 frameBorder=0 cols=220,*>
		<FRAME name=menu src="menu.jsp" frameBorder=0 noResize>
		<FRAME name=main src="welcome.jsp" frameBorder=0>
	</FRAMESET>
	<NOFRAMES>
		
	</NOFRAMES>
</FRAMESET>
</HTML>
