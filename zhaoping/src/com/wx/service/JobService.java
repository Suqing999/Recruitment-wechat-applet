package com.wx.service;

import java.util.List;

import com.wx.pojo.Job;

public interface JobService {
	List<Job> showAll();

	int  add(Job job);

	Job showById(int jid);

	int upNow(Job job);

	List<Job> showscAll();

	List<Job> showshAll();

	List<Job> showmhAll(String jname);

	int toudi(int qid, int jid);

	int searchtoudi(int qid, int jid);

	int searchsc(int qid, int jid);

	int shoucang(int qid, int jid);

	List<Job> showshoucangAll(int qid);

	List<Job> showtoudiAll(int qid);

	int tdzt(int qid, int jid);

	int delById(Integer jid);
}
