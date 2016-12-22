package com.jianZhi.ssh.actions;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jianZhi.ssh.entities.Student;
import com.jianZhi.ssh.services.StudentService;
import com.jianZhi.ssh.web.StudentLogin;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class StudentLoginAction extends ActionSupport implements SessionAware{
	
	private Map<String, Object> session;
	private StudentLogin studentLogin;
	@Autowired
	private StudentService studentService;
	
	public StudentLogin getStudentLogin() {
		return studentLogin;
	}

	public void setStudentLogin(StudentLogin studentLogin) {
		this.studentLogin = studentLogin;
	}
	
	public String login() {
		String flag = studentService.login(studentLogin);
		if(!flag.equals("login"))
			return flag;
		Student s = studentService.getStudent(studentLogin.getUsername(), studentLogin.getPassword());
		long id = s.getStudent_id();
		session.put("username", studentLogin.getUsername());
		session.put("id", id);
		session.put("kind", "student");
        return flag;
	}

	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}
