package com.jianZhi.ssh.actions;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.jianZhi.ssh.entities.Company;
import com.jianZhi.ssh.entities.Recruiter;
import com.jianZhi.ssh.entities.Recruitment;
import com.jianZhi.ssh.entities.Student;
import com.jianZhi.ssh.services.CompanyService;
import com.jianZhi.ssh.services.RecruiterService;
import com.jianZhi.ssh.utils.HttpUtils;
import com.jianZhi.ssh.web.RecruiterLogin;
import com.jianZhi.ssh.web.RecruiterRegister;
import com.jianZhi.ssh.web.StudentLogin;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class RecruiterAction extends ActionSupport implements SessionAware, RequestAware{

	private Map<String,Object> session;
	private Map<String,Object> request;
	@Autowired
	private RecruiterService recruiterService;
	@Autowired
	private CompanyService companyService;
	
	private RecruiterRegister recruiterRegister;

	public RecruiterRegister getRecruiterRegister() {
		return recruiterRegister;
	}

	public void setRecruiterRegister(RecruiterRegister recruiterRegister) {
		this.recruiterRegister = recruiterRegister;
	}
	
	public String register() {
		Company company = companyService.getCompany(recruiterRegister.getCity(), recruiterRegister.getDistrict(), recruiterRegister.getCompanyName());
		Recruiter recruiter = new Recruiter();
		recruiter.setUsername(recruiterRegister.getUsername());
		recruiter.setPassword(recruiterRegister.getPassword());
		recruiter.setCompany(company);
		recruiter.setTelphone(recruiterRegister.getTelphone());
		recruiter.setEmail(recruiterRegister.getEmail());
		boolean flag = recruiterService.register(recruiter);
		if(flag)
			return "register";
		else
			return "input";
	}
	
	public String toHome() {
		int id = (Integer) session.get("id");
		Recruiter recruiter = recruiterService.getRecruiter(id);
		request.put("rec", recruiter);
		return SUCCESS;
	}

	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
	
	public void test() {
		
	}
	
	public void login() throws Exception {
		HttpServletRequest request = HttpUtils.getRequest();
		HttpServletResponse response = HttpUtils.getResponse("application/json");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + "," + password);
		int flagNumber = 0;
		String flag = null;
		Gson gson = new Gson();
		if(username != null && !username.trim().equals("") && password != null && !password.trim().equals("")) {
			RecruiterLogin s = new RecruiterLogin();
			s.setUsername(username);
			s.setPassword(password);
			flag = recruiterService.login(s);
			if(flag.equals("login"))
				flagNumber = recruiterService.getRecruiter(username, password).getRecruiter_id();
			else
				flagNumber = -1;
		} else {
			flagNumber = -2;
		}
		flag = gson.toJson(flagNumber);
		
		response.getWriter().print(flag);
	}
	
	public void registerJson() throws Exception {
		HttpServletRequest request = HttpUtils.getRequest();
		HttpServletResponse response = HttpUtils.getResponse("application/json");
		
		Recruiter r = new Recruiter();
		r.setUsername(request.getParameter("username"));
		r.setPassword(request.getParameter("password"));
		
		String city = request.getParameter("cityName");
		String district = request.getParameter("district");
		String companyName = request.getParameter("companyName");
		r.setCompany(companyService.getCompany(city, district, companyName));
		r.setTelphone(request.getParameter("telphone"));
		r.setEmail(request.getParameter("email"));
		
		Gson gson = new Gson();
		boolean flag = recruiterService.register(r);
		int flagNumber = 0;
		if(flag)
			flagNumber = recruiterService.getRecruiter(r.getUsername(), r.getPassword()).getRecruiter_id();
		else
			flagNumber = -1;
		String flagData = gson.toJson(flagNumber);
		response.getWriter().print(flagData);
	}
	
	public void getById() throws Exception {
		HttpServletRequest request = HttpUtils.getRequest();
		HttpServletResponse response = HttpUtils.getResponse("application/json");
		
		int id = Integer.parseInt(request.getParameter("id"));
		Recruiter s = recruiterService.getRecruiter(id);
		Recruiter res = new Recruiter(s);
		Gson gson = new Gson();
		String rec = gson.toJson(res);
		response.getWriter().print(rec);
	}
}
