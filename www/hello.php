<?php
        header("Content-type:text/html;charset=utf-8");
        //限制图片类型格式，大小
        if ((($_FILES["file"]["type"] == "image/gif")
            || ($_FILES["file"]["type"] == "image/jpeg")
            || ($_FILES["file"]["type"] == "image/jpg"))
            ) {
            if ($_FILES["file"]["error"] > 0) {
                echo "Return Code: " . $_FILES["file"]["error"] . "<br />";
            } else {
                //echo "文件名: " . $_FILES["file"]["name"] . "<br />";
                //echo "文件类型: " . $_FILES["file"]["type"] . "<br />";
                //echo "文件大小: " . ($_FILES["file"]["size"] / 1024) . " Kb<br />";
                //echo "缓存文件: " . $_FILES["file"]["tmp_name"] . "<br />";

            //设置文件上传路径，选择指定文件夹

                if (file_exists("F://WeChat/qiuzhi/picture/" . $_FILES["file"]["name"])) {
                  //  echo $_FILES["file"]["name"] . " already exists. ";
                } else {
					
                    move_uploaded_file(
                        $_FILES["file"]["tmp_name"],
                        "F://WeChat/qiuzhi/picture/" . $_FILES["file"]["name"]
                    );
					// echo "存储于: " . "F://WeChat/qiuzhi/picture/" . $_FILES["file"]["name"];//上传成功后提示上传信息
                }
            }
        } else {
            echo "上传失败！";//上传失败后显示错误信息
        }
          echo "上传成功！";//上传失败后显示错误信息
		 move_uploaded_file($_FILES["file"]["tmp_name"], 
  "F://xiaochengxu/.metadata/.me_tcat85/webapps/zhaoping/picture/" .iconv("UTF-8", "gbk",$_FILES["file"]["name"])); 
                   
        //链接数据库
        //include('conn.php');

        //定义变量，存储文件上传路径，之后将变量写进数据库相应字段即可
        $file = "../../picture/" . $_FILES["file"]["name"];
		 $file2 = "http://localhost:8080/zhaoping/picture/" . $_FILES["file"]["name"];
		?>
		<br/>
		<?php
        include("conn.php");
		//echo $file;
	   $sql = "INSERT INTO company_pic
            VALUES
            ('default','某教育公司','$file','$file2')";

        if (!$query = mysqli_query($conn,$sql)) {
            die('Error: ' . mysql_error());
        }
        //echo "成功添加一条记录";//成功传入数据后显示成功添加一条数据
       // header("Refresh:1;url=XXX.html");//成功插入数据后返回某个网页
        ?>