package com.wx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wx.mapper.CompanyMapper;
import com.wx.mapper.JobMapper;
import com.wx.pojo.Job;
import com.wx.service.JobService;

@Service
public class JobServiceImpl implements JobService {
	@Resource
	private JobMapper jobMapper;
	@Override
	public List<Job> showAll() {
		
		return jobMapper.showAll();
	}
	@Override
	public int add(Job job) {
		
		return jobMapper.add(job);
	}
	@Override
	public Job showById(int jid) {
		
		return jobMapper.up(jid);
	}
	@Override
	public int upNow(Job job) {
		
		return jobMapper.upNow(job);
	}
	@Override
	public List<Job> showscAll() {
		// TODO Auto-generated method stub
		return jobMapper.showscAll();
	}
	@Override
	public List<Job> showshAll() {
		// TODO Auto-generated method stub
		return jobMapper.showshAll();
	}
	@Override
	public List<Job> showmhAll(String jname) {
		// TODO Auto-generated method stub
		return jobMapper.showmhAll(jname);
	}
	@Override
	public int toudi(int qid, int jid) {
		// TODO Auto-generated method stub
		return jobMapper.toudi(qid,jid);
	}
	@Override
	public int searchtoudi(int qid, int jid) {
		// TODO Auto-generated method stub
		return jobMapper.searchtoudi(qid,jid);
	}
	@Override
	public int searchsc(int qid, int jid) {
		// TODO Auto-generated method stub
		return jobMapper.searchshoucang(qid,jid);
	}
	@Override
	public int shoucang(int qid, int jid) {
		// TODO Auto-generated method stub
		return jobMapper.shoucang(qid,jid);
	}
	@Override
	public List<Job> showshoucangAll(int qid) {
		// TODO Auto-generated method stub
		return jobMapper.pageshoucang(qid);
	}
	@Override
	public List<Job> showtoudiAll(int qid) {
		// TODO Auto-generated method stub
		return jobMapper.pagetoudi(qid);
	}
	@Override
	public int tdzt(int qid, int jid) {
		// TODO Auto-generated method stub
		return jobMapper.zt(qid,jid);
	}
	@Override
	public int delById(Integer jid) {
		// TODO Auto-generated method stub
		return jobMapper.delyemian(jid);
	}

}
