package com.jianZhi.ssh.actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jianZhi.ssh.entities.Recruiter;
import com.jianZhi.ssh.entities.Recruitment;
import com.jianZhi.ssh.services.RecruiterService;
import com.jianZhi.ssh.services.RecruitmentService;
import com.jianZhi.ssh.web.RecruiterLogin;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class RecruiterLoginAction extends ActionSupport implements SessionAware, RequestAware{
	
	private Map<String,Object> session;
	private Map<String,Object> request;
	private RecruiterLogin recruiterLogin;
	
	@Autowired
	private RecruiterService recruiterService;
	
	@Autowired
	private RecruitmentService recruitmentService;
	
	public RecruiterLogin getRecruiterLogin() {
		return recruiterLogin;
	}

	public void setRecruiterLogin(RecruiterLogin recruiterLogin) {
		this.recruiterLogin = recruiterLogin;
	}

	public String login() {
		String flag = recruiterService.login(recruiterLogin);
		if(!flag.equals("login"))
			return flag;
		int id = recruiterService.getRecruiter(recruiterLogin.getUsername(), recruiterLogin.getPassword()).getRecruiter_id();
		session.put("username", recruiterLogin.getUsername());
		session.put("id", id);
		session.put("kind", "recruiter");
		
		Recruiter rec = recruiterService.getRecruiter(id);
		List<Recruitment> list = recruitmentService.getRecruitmentsByRecruiterId(id);
		
		request.put("rec", rec);
		request.put("list", list);
		
        return flag;
	}

	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}
	
}
