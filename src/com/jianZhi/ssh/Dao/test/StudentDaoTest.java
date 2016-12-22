package com.jianZhi.ssh.Dao.test;

import java.util.List;

import org.junit.Test;

import com.jianZhi.ssh.Dao.StudentDao;
import com.jianZhi.ssh.Dao.impl.StudentDaoImpl;
import com.jianZhi.ssh.entities.Student;
import com.jianZhi.ssh.web.StudentLogin;

public class StudentDaoTest {
	
	private StudentDaoImpl studentDao = new StudentDaoImpl(); 
	
	@Test
	public void testInsert() {
		Student s = new Student();
		studentDao.insert(s);
	}
	
	@Test
	public void testUpdate() {
		Student s = new Student();
		s.setStudent_id(2L);
		s.setEmail("2235921519@qq.com");
		studentDao.updateStudent(s);
	}
	
	@Test
	public void isHaveStudent() {
		StudentLogin s = new StudentLogin();
		s.setUsername("林影");
		s.setPassword("linying");
		System.out.println(studentDao.isHaveStudent(s));
	}
	
	@Test
	public void testGetStudent() {
		long id = 2;
		Student s = studentDao.getStudent(id);
		System.out.println(s);
	}
	
	@Test
	public void testGetAll() {
		List<Student> l = studentDao.getAll();
		System.out.println(l);
	}
	
	@Test
	public void testDelete() {
		studentDao.deleteStudent(2);
	}
}
