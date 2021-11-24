package com.wx.service;

import java.util.List;

import com.wx.pojo.Qman;

public interface QmanService {
	List<Qman> showAll();

	List<Qman> showTouDi();

	List<Qman> showMianshi();

	int del(int qid);

	int yms(int qid);

	int jj(int qid);

	int insertOne(int qid, String jobtitle, String name, String gender, String nianfeng,
			String qxl, String qgzjy, String address, String email, String tel, String qgzxz, String qzt, String qmoney,
			String content);

	int showbyid(int qid);

	Qman selectOneByqid(Integer qid);

	int ishave(Integer qid);

	int upOne(int qid, String jobtitle, String name, String gender, String nianfeng, String qxl, String qgzjy,
			String address, String email, String tel, String qgzxz, String qzt, String qmoney, String content);

	int ishavejianli(Integer qid);

	int shuliang(Integer qid);

	int tdbiaoji(int qid,int jid);
}
