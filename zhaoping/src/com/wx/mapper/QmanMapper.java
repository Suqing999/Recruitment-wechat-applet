package com.wx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wx.pojo.Qman;

public interface QmanMapper {
	@Select("select * from qiuzhizhe")
	List<Qman> show();
	@Select("SELECT * FROM qiuzhizhe WHERE qid IN (SELECT qid FROM tdandsc WHERE tdandsc.td=1 and yqms=0)")
	List<Qman> showtoudi();
	@Select("select * from qiuzhizhe  WHERE qid IN (SELECT qid FROM tdandsc WHERE tdandsc.td=1 and  yqms=1)")
	List<Qman> showmianshi();
	@Delete("DELETE FROM tdandsc  WHERE qid = #{qid} and td=1")
	int del(@Param("qid")int qid);
	@Update("UPDATE tdandsc SET yqms=1 where qid=#{qid}")
	int yms(@Param("qid")int qid);
	@Insert("INSERT INTO qiuzhizhe VALUES (default,#{qid},default,default,#{qyx},#{qname},#{qgender},#{qdate},#{qxl},#{qgzjy},#{qjzd},#{qmail},#{qphone},#{qgzxz},#{qzt},#{qmoney},#{qjs},default,default)")
	int insertOne(@Param("qid")int qid,@Param("qyx") String jobtitle,@Param("qname") String name,@Param("qgender")String gender, @Param("qdate")String nianfeng, @Param("qxl")String qxl, @Param("qgzjy")String qgzjy,
			@Param("qjzd")String address,@Param("qmail") String email, @Param("qphone")String tel, @Param("qgzxz")String qgzxz, @Param("qzt")String qzt, @Param("qmoney")String qmoney, @Param("qjs")String content);
	@Select("select count(*) from qiuzhizhe where qid=#{qid}")
	int showbyid(@Param("qid")int qid);
	@Update("UPDATE tdandsc SET yqms=2 where qid=#{qid}")
	int jujue(@Param("qid")int qid);
	@Select("select * from qiuzhizhe where qid=#{qid}")
	Qman soq(Integer qid);
	@Select("select count(*) from qiuzhizhe where qid=#{qid}")
	int ishave(Integer qid);
	@Update("update qiuzhizhe set qyx=#{qyx},qname=#{qname},qgender=#{qgender},qdate=#{qdate},qxl=#{qxl},qgzjy=#{qgzjy},qjzd=#{qjzd},qmail=#{qmail},qphone=#{qphone},qgzxz=#{qgzxz},qzt=#{qzt},qmoney=#{qmoney},qjs=#{qjs} where qid=#{qid}")
	int upone(@Param("qid")int qid,@Param("qyx") String jobtitle,@Param("qname") String name,@Param("qgender")String gender, @Param("qdate")String nianfeng, @Param("qxl")String qxl, @Param("qgzjy")String qgzjy,
			@Param("qjzd")String address,@Param("qmail") String email, @Param("qphone")String tel, @Param("qgzxz")String qgzxz, @Param("qzt")String qzt, @Param("qmoney")String qmoney, @Param("qjs")String content);
	@Select("select count(*) from tdandsc where qid=#{qid} and td=1")
	int shuliang(Integer qid);
	@Update("update qiuzhizhe set qtd=#{jid} where qid=#{qid}")
	int tdbiaoji(@Param("qid")int qid, @Param("jid")int jid);
	
	
}
