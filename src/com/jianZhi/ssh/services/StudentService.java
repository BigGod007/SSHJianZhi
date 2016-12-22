package com.jianZhi.ssh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianZhi.ssh.Dao.StudentDao;
import com.jianZhi.ssh.entities.Student;
import com.jianZhi.ssh.web.StudentLogin;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	/**
	 * 登录
	 * @param studentLogin
	 * @return
	 */
	public String login(StudentLogin studentLogin) {
		if(studentDao.isHaveStudent(studentLogin))
			return "login";
		else
			return "input";
	}
	
	/**
	 * 注册
	 * @param student
	 * @return
	 */
	public boolean register(Student student) {
		return studentDao.insertStudent(student);
	}
	
	/**
	 * 通过登录名，密码找到账号
	 * @param username
	 * @param password
	 * @return
	 */
	public Student getStudent(String username, String password) {
		return studentDao.getStudent(username, password);
	}
	
	/**
	 * 通过id找到账号
	 * @param id
	 * @return
	 */
	public Student getStudent(long id) {
		return studentDao.getStudent(id);
	}
	
}
