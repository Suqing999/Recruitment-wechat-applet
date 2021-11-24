package com.wx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wx.pojo.Job;

public interface JobMapper {
	@Select("select * from job")
	List<Job> showAll();
	@Insert("INSERT INTO job VALUES (default,#{jname},#{jxs},#{jwz},#{jjy},#{jxl},#{jyh},#{jms})")
	int add(Job job);
	@Select("select * from job where jid=#{jid}")
	Job up(@Param("jid")int jid);
	@Update("UPDATE job SET jname = #{jname},jxs=#{jxs},jwz=#{jwz},jjy=#{jjy},jxl=#{jxl},jyh=#{jyh},jms=#{jms} where jid=#{jid}")
	int upNow(Job job);
	@Select("select * from job where jyh='校园招聘'")
	List<Job> showscAll();
	@Select("select * from job where jyh='社会招聘'")
	List<Job> showshAll();
	@Select("select * from job where jname like CONCAT('%',#{jame},'%')")
	List<Job> showmhAll(String jname);
	@Insert("INSERT INTO tdandsc VALUES (default,#{qid},#{jid},default,default,1)")
	int toudi(@Param("qid")int qid, @Param("jid")int jid);
	@Select("select count(*) from tdandsc where qid=#{qid} and jid=#{jid} and td=1")
	int searchtoudi(@Param("qid")int qid, @Param("jid")int jid);
	@Select("select count(*) from tdandsc where qid=#{qid} and jid=#{jid} and sc=1")
	int searchshoucang(@Param("qid")int qid, @Param("jid")int jid);
	@Insert("INSERT INTO tdandsc VALUES (default,#{qid},#{jid},default,1,default)")
	int shoucang(@Param("qid")int qid, @Param("jid")int jid);
	@Select(" SELECT * FROM job WHERE jid IN (SELECT jid FROM tdandsc WHERE tdandsc.`qid`=#{qid} AND tdandsc.sc=1) ")
	List<Job> pageshoucang(@Param("qid")int qid);
	@Select(" SELECT * FROM job WHERE jid IN (SELECT jid FROM tdandsc WHERE tdandsc.`qid`=#{qid} AND tdandsc.td=1) ")
	List<Job> pagetoudi(@Param("qid")int qid);
	@Select("SELECT yqms FROM tdandsc WHERE qid=#{qid} AND jid=#{jid} AND td=1")
	int zt(@Param("qid")int qid, @Param("jid")int jid);
	
	@Delete("DELETE FROM job  WHERE jid = #{jid}")
	int delyemian(@Param("jid")int jid);

}
