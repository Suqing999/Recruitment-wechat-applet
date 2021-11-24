package com.wx.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.wx.pojo.Advice;

public interface AdviceMapper {
	@Select("select * from advice")
	List<Advice> show();
	@Delete("DELETE FROM advice  WHERE id = #{id}")
	int del(@Param("id")int id);
	@Insert("INSERT INTO advice VALUES (default,#{lxfs},#{yj})")
	
	int add( @Param("lxfs")String lxfs, @Param("yj")String yj);
	
}
