<?php 
 header("Content-Type:text/html;charset=utf8"); 
 header("Access-Control-Allow-Origin: *"); //解决跨域
 header('Access-Control-Allow-Methods:POST');// 响应类型 
 header('Access-Control-Allow-Headers:*'); // 响应头设置 
 //$link=mysql_connect("localhost","root","root"); 
 //mysql_select_db("new_test", $link); //选择数据库
 //mysql_query("SET NAMES utf8");//解决中文乱码问题
 //error_reporting(0);
  $qid = $_POST["qid"];
  //echo $_POST["qid"];
 if ($_FILES["file"]["error"] > 0) 
 { 
 echo "错误: " . $_FILES["file"]["error"] . "<br />"; 
 } 
 else
 { 
 $dlog["name"]=$_FILES["file"]["name"];
 $dlogs=$dlog; 
  //echo urldecode(json_encode($dlogs));
 $name =$_FILES["file"]["name"];
 echo '上传成功！';

 //插入数据到数据库 
 //$strsql = "insert into name (fileName) values('$name')";
 //mysql_query() 函数执行一条 MySQL 查询。SELECT，SHOW，EXPLAIN 或 DESCRIBE 都需要用这个函数执行
 //$result = @mysql_query($strsql);
// echo "文件名: " . $_FILES["file"]["name"] . "<br />"; 
// echo "类型: " . $_FILES["file"]["type"] . "<br />"; 
// echo "大小: " . ($_FILES["file"]["size"] / 1024) . " Kb<br />"; 
 } 
 if (file_exists("F://xiaochengxu/zhaoping/WebRoot/jianl/" . $_FILES["file"]["name"])) 
  { 
  // echo $_FILES["file"]["name"] . " 文件已经存在. "; 
  } 
 else
  { 
 // move_uploaded_file($_FILES["file"]["tmp_name"], 
 // "F://xiaochengxu/zhaoping/WebRoot/jianl/" .iconv("UTF-8", "gbk",$_FILES["file"]["name"])); 
 
  move_uploaded_file($_FILES["file"]["tmp_name"], 
  "F://xiaochengxu/.metadata/.me_tcat85/webapps/zhaoping/jianl/" .iconv("UTF-8", "gbk",$_FILES["file"]["name"])); 
 //echo "文件已经被存储到: " . "F://xiaochengxu/zhaoping/WebRoot/jianl/" . $_FILES["file"]["name"]; 
 
 //echo "文件已经被存储到: " . "F://xiaochengxu/.metadata/.me_tcat85/webapps/zhaoping/jianl/" . $_FILES["file"]["name"]; 
  } 
  
  
        //定义变量，存储文件上传路径，之后将变量写进数据库相应字段即可
       $file = "http://localhost:8080/zhaoping/jianl/" . $_FILES["file"]["name"]; 
		
		//$file = "F://xiaochengxu/.metadata/.me_tcat85/webapps/zhaoping/jianl/" . $_FILES["file"]["name"]; 
	
        include("conn.php");
		//echo $file;
	    $sql = "UPDATE qiuzhizhe SET qjl = '$file' WHERE qid = $qid";
		//echo $sql;
        if (!$query = mysqli_query($conn,$sql)) {
            die('Error: ' . mysql_error());
        }
        //echo "成功添加一条记录";//成功传入数据后显示成功添加一条数据
  
?>