package com.jianZhi.ssh.Dao.test;

import java.util.List;

import org.junit.Test;

import com.jianZhi.ssh.Dao.impl.RecruiterDaoImpl;
import com.jianZhi.ssh.entities.Recruiter;
import com.jianZhi.ssh.entities.Student;
import com.jianZhi.ssh.web.RecruiterLogin;
import com.jianZhi.ssh.web.StudentLogin;

public class RecruiterDaoTest {

	private RecruiterDaoImpl recruiterDao = new RecruiterDaoImpl();
	
	@Test
	public void testSave() {
		Recruiter recruiter = new Recruiter();
		recruiterDao.insertRecruiter(recruiter);
	}
	
	@Test
	public void testUpdate() {
		Recruiter s = new Recruiter();
		s.setRecruiter_id(2);
		s.setEmail("2235921519@qq.com");
		recruiterDao.updateRecruiter(s);
	}
	
	@Test
	public void isHaveRecruiter() {
		RecruiterLogin s = new RecruiterLogin();
		s.setUsername("林影");
		s.setPassword("linying");
		System.out.println(recruiterDao.isHaveRecruiter(s));
	}
	
	@Test
	public void testGetRecruiter() {
		int id = 2;
		Recruiter s = recruiterDao.getRecruiter(id);
		System.out.println(s);
	}
	
	@Test
	public void testGetAll() {
		List<Recruiter> l = recruiterDao.getAll();
		System.out.println(l);
	}
	
	@Test
	public void testDelete() {
		recruiterDao.deleteRecruiter(2);
	}
}
