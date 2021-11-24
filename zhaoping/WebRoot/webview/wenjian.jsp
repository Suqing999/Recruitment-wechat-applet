<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
 <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />
 <meta charset="UTF-8">
 <title>简历上传</title>
 <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.js"></script>
 </head>
  
 <body>


 <form id="form1" action="http://localhost/wjupdate.php" target="frame1" method="post" enctype="multipart/form-data">
 <input type="file" name="file">
 <input type="hidden" name="qid" value="${param.qid}">
 <input type="submit" value="上传" onclick="upload()">
 </form>
 <iframe name="frame1" frameborder="0" height="40"></iframe>
 <!-- 其实我们可以把iframe标签隐藏掉 -->
 <script type="text/javascript">
 function upload() {
 $("#form1").submit();
 var t = setInterval(function() {
  //获取iframe标签里body元素里的文字。即服务器响应过来的"上传成功"或"上传失败"
  var word = $("iframe[name='frame1']").contents().find("body").text();
  if(word != "") {
//  alert(word); //弹窗提示是否上传成功
//  clearInterval(t); //清除定时器
  }
 }, 1000);
 }
 </script>
 </body>
  
</html>
