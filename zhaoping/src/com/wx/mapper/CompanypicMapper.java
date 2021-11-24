package com.wx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.wx.pojo.Companypic;

public interface CompanypicMapper {
	@Delete("DELETE FROM company_pic  WHERE pid = #{pid}")
	int del(@Param("pid")int id);
	@Select("select wxpic from company_pic")
	List<Companypic> showAll();

}
