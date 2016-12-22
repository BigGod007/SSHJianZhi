package com.jianZhi.ssh.entities;

public class Student {

	private Long student_id;
	private String username;
	private String password;
	private School school;
	private String telphone;
	private String email;
	
	public Student() {
		
	}
	
	public Student(Student s) {
		this.student_id = s.getStudent_id();
		this.username = s.getUsername();
		this.password = s.getPassword();
		this.school = new School(s.getSchool());
		this.telphone = s.getTelphone();
		this.email = s.getEmail();
	}

	public Long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", username=" + username + ", password=" + password + ", school="
				+ school + ", telphone=" + telphone + ", email=" + email + "]";
	}

	
}
