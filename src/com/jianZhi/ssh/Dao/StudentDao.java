package com.jianZhi.ssh.Dao;

import java.util.List;

import com.jianZhi.ssh.entities.Recruiter;
import com.jianZhi.ssh.entities.School;
import com.jianZhi.ssh.entities.Student;
import com.jianZhi.ssh.web.StudentLogin;

public interface StudentDao {
	
	/**
	 * 
	 * @return 成功返回true,失败返回false;
	 */
	public boolean isHaveStudent(StudentLogin s);
	
	/**
	 * 删除学生
	 * @param student_id
	 */
	public boolean deleteStudent(long student_id);
	
	/**
	 * 加入一个学生
	 * @param s
	 */
	public boolean insertStudent(Student s);
	
	/**
	 * 得到特定id的学生
	 * @param student_id
	 */
	public Student getStudent(long student_id);
	
	/**
	 * 得到所有学生
	 */
	public List<Student> getAll();
	
	/**
	 * 修改特定学生
	 * @param s
	 */
	public boolean updateStudent(Student s);
	
	public School getSchoolByStudent(long student_id);
	
	public Student getStudent(String username, String password);
}
