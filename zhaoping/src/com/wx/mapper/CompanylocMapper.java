package com.wx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.wx.pojo.Companyloc;

public interface CompanylocMapper {
	@Delete("DELETE FROM company_loc  WHERE id = #{id}")
	int del(@Param("id")int id);
	@Select("select * from company_loc")
	List<Companyloc> showAll();
	@Insert("INSERT INTO company_loc VALUES (default,#{companyname},#{loc})")
	int add(@Param("companyname")String name, @Param("loc")String loc);

}
