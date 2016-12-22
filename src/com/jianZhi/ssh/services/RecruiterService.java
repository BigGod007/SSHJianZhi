package com.jianZhi.ssh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianZhi.ssh.Dao.RecruiterDao;
import com.jianZhi.ssh.entities.Recruiter;
import com.jianZhi.ssh.web.RecruiterLogin;

@Service
public class RecruiterService {
	
	@Autowired
	private RecruiterDao recruiterDao;
	
	/**
	 * 登录
	 * @param recruiterLogin
	 * @return
	 */
	public String login(RecruiterLogin recruiterLogin) {
		if(recruiterDao.isHaveRecruiter(recruiterLogin))
			return "login";
		else
			return "input";
	}
	
	/**
	 * 注册
	 * @param recruiter
	 * @return
	 */
	public boolean register(Recruiter recruiter) {
		return  recruiterDao.insertRecruiter(recruiter);
	}
	
	/**
	 * 通过账号密码找到招聘人
	 * @param username
	 * @param password
	 * @return
	 */
	public Recruiter getRecruiter(String username, String password) {
		return recruiterDao.getRecruiter(username, password);
	}
	
	/**
	 * 通过id找到
	 * @param id招聘人
	 * @return
	 */
	public Recruiter getRecruiter(int id) {
		return recruiterDao.getRecruiter(id);
	}
}
