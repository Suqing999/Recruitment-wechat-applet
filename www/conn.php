<?php
 header("Content-type:text/html;charset=utf-8");
$mysql_server_name = 'localhost'; //改成自己的mysql数据库服务器

$mysql_username = 'root'; //改成自己的mysql数据库用户名

$mysql_password = 'hh856hh'; //改成自己的mysql数据库密码

$mysql_database = 'zhaoping'; //改成自己的mysql数据库名

$conn=mysqli_connect($mysql_server_name,$mysql_username,$mysql_password,$mysql_database); //连接数据库

//连接数据库错误提示

if (mysqli_connect_errno($conn)) { 

    die("连接 MySQL 失败: " . mysqli_connect_error()); 

}else{
	echo "ok";
}

mysqli_query($conn,"set names utf8"); //数据库编码格式


/*
//查询代码

$sql = "select * from job";

$query = mysqli_query($conn,$sql);

while($row = mysqli_fetch_array($query)){

    echo $row['jname'];

}
/*
//查询代码

// 释放结果集+关闭MySQL数据库连接
*/
//mysqli_free_result($result);

//mysqli_close($conn);

?>