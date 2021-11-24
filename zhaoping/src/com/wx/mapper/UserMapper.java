package com.wx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wx.pojo.User;

public interface UserMapper {
	@Select("select * from admin_user where username=#{username} and password=#{password}")
	User selByusername(@Param("username") String username,@Param("password") String password);
	@Insert("INSERT INTO admin_user VALUES (default,#{username},#{password},#{name},#{stateuser},#{phone},#{gender})")
	int add(User u);
	@Select("select * from admin_user")
	List<User> showAll();
	@Update("UPDATE admin_user SET username=#{username} ,password = #{password}  where id=#{id}")
	int up(@Param("id")int id,@Param("username")String username,@Param("password")String password);
	@Delete("DELETE FROM admin_user  WHERE id = #{id}")
	int del(@Param("id")int id);
	@Update("UPDATE admin_user SET stateuser ='超级管理员' where id=#{id}")
	int xiugai(@Param("id")int id);
}
