package com.wx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wx.mapper.QmanMapper;
import com.wx.pojo.Qman;
import com.wx.service.QmanService;
@Service
public class QmanServiceImpl implements QmanService {
	@Resource
	private QmanMapper qmanMapper;
	@Override
	public List<Qman> showAll() {
	
		return qmanMapper.show();
	}
	@Override
	public List<Qman> showTouDi() {

		return qmanMapper.showtoudi();
	}
	@Override
	public List<Qman> showMianshi() {
	
		return qmanMapper.showmianshi();
	}
	@Override
	public int del(int qid) {
	
		return qmanMapper.del(qid);
	}
	@Override
	public int yms(int qid) {
		
		return qmanMapper.yms(qid);
	}
	@Override
	public int jj(int qid) {
		
		return qmanMapper.jujue(qid);
	}
	@Override
	public int insertOne(int qid, String jobtitle, String name, String gender, String nianfeng, String qxl,
			String qgzjy, String address, String email, String tel, String qgzxz, String qzt, String qmoney,
			String content) {
		
		return qmanMapper.insertOne(qid,jobtitle,name,gender,nianfeng,qxl,qgzjy,address,email,tel,qgzxz,qzt,qmoney,content);
		
		
	}
	@Override
	public int showbyid(int qid) {
		// TODO Auto-generated method stub
		return qmanMapper.showbyid(qid);
	}
	@Override
	public Qman selectOneByqid(Integer qid) {
		// TODO Auto-generated method stub
		return qmanMapper.soq(qid);
	}
	@Override
	public int ishave(Integer qid) {
		// TODO Auto-generated method stub
		return qmanMapper.ishave(qid);
	}
	@Override
	public int upOne(int qid, String jobtitle, String name, String gender, String nianfeng, String qxl, String qgzjy,
			String address, String email, String tel, String qgzxz, String qzt, String qmoney, String content) {
		// TODO Auto-generated method stub
		return qmanMapper.upone(qid,jobtitle,name,gender,nianfeng,qxl,qgzjy,address,email,tel,qgzxz,qzt,qmoney,content);
		
	}
	@Override
	public int ishavejianli(Integer qid) {
		// TODO Auto-generated method stub
		return qmanMapper.ishave(qid);
	}
	@Override
	public int shuliang(Integer qid) {
		// TODO Auto-generated method stub
		return qmanMapper.shuliang(qid);
	}
	@Override
	public int tdbiaoji(int qid,int jid) {
		// TODO Auto-generated method stub
		return qmanMapper.tdbiaoji(qid,jid);
	}

}
