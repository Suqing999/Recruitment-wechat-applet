package com.wx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wx.pojo.Company;
import com.wx.pojo.Companypic;


public interface CompanyMapper {
	@Select("select companyxiangxi,companyname from company")
	List<Company> selXX();
	@Select("select companyfuli,companyname from company")
	List<Company> selFL();
	
	@Update("UPDATE company SET companyxiangxi = #{xiangxi} where cid=1")
	int up1(@Param("xiangxi")String xiangxi);
	@Select("select * from company")
	Company showAll();
	@Update("UPDATE company SET companyfuli = #{fuli} where cid=1")
	int up2(@Param("fuli")String fuli);
	@Select("select * from company_pic")
	List<Companypic> selpic();
	@Select("select companyname,companyyewu,cid from company")
	List<Company> selyw();
	@Update("UPDATE company SET companyyewu = #{yewu} where cid=1")
	int up3(@Param("yewu")String companyyewu);
	@Select("select companyname,companyjianjie,cid from company")
	List<Company> showJL();
	@Update("UPDATE company SET companyjianjie = #{jianjie} where cid=1")
	int upjj(@Param("jianjie")String jianjie);
}
