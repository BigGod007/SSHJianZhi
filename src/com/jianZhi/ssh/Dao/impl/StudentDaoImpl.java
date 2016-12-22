package com.jianZhi.ssh.Dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jianZhi.ssh.Dao.StudentDao;
import com.jianZhi.ssh.entities.School;
import com.jianZhi.ssh.entities.Student;
import com.jianZhi.ssh.web.StudentLogin;

@Repository("studentDao")
public class StudentDaoImpl extends BaseDao<Student> implements StudentDao{

	public boolean isHaveStudent(StudentLogin s) {
		String hql = "from Student s where s.username = ? and s.password = ?";
		List<Student> list = get(hql, s.getUsername(), s.getPassword());
		if(list.size() == 0)
			return false;
		return true;
	}


	public boolean deleteStudent(long student_id) {
		Student s = get(student_id);
		return delete(s);
	}


	public boolean insertStudent(Student s) {
		return insert(s);
	}


	public Student getStudent(long student_id) {
		return get(student_id);
	}

	public List<Student> getAll() {
		String hql = "from Student";
		return get(hql);
	}

	public boolean updateStudent(Student s) {
		return update(s);
	}
	
	public School getSchoolByStudent(long student_id) {
		String hql = "from Student where student_id = ?";
		Student s = get(student_id);
		return s.getSchool();
	}


	public Student getStudent(String username, String password) {
		String hql = "from Student where username = ? and password = ?";
		Student s = get(hql, username, password).get(0);
		return s;
	}


}
