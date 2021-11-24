package com.wx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wx.pojo.Qlogin;

public interface QloginMapper {
	@Select("select * from qlogin where username=#{username} and password = #{password}")
	Qlogin login(@Param("username")String username, @Param("password")String password);
	@Insert("insert into qlogin values (default,#{username},#{password},#{name})")
	int regsit(@Param("name")String name, @Param("username")String username,@Param("password") String password);
	@Update("UPDATE qlogin SET password = #{newpassword} where name=#{name} and username=#{username}")
	int wj(@Param("name")String name, @Param("username")String username,@Param("newpassword") String newpassword);

}
