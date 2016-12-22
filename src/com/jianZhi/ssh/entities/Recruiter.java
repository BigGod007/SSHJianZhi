package com.jianZhi.ssh.entities;

import java.util.HashSet;
import java.util.Set;

public class Recruiter {
	private Integer recruiter_id;
	private String username;
	private String password;
	private Company company;
	private String telphone;
	private String email;
	private Set<Recruitment> recruitments = new HashSet<Recruitment>();

	public Recruiter() {
		
	}
	
	public Recruiter(Recruiter r) {
		this.recruiter_id = r.getRecruiter_id();
		this.username = r.getUsername();
		this.password = r.getPassword();
		this.company = new Company(r.getCompany());
		this.telphone = r.telphone;
		this.email = r.email;
//		this.recruitments = new HashSet<Recruitment>();
//		for(Recruitment re : r.getRecruitments()) {
//			this.recruitments.add(re);
//		}
	}
	
	
	public Set<Recruitment> getRecruitments() {
		return recruitments;
	}

	public void setRecruitments(Set<Recruitment> recruitments) {
		this.recruitments = recruitments;
	}

	public Integer getRecruiter_id() {
		return recruiter_id;
	}

	public void setRecruiter_id(Integer recruiter_id) {
		this.recruiter_id = recruiter_id;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
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
		return "Recruiter [recruiter_id=" + recruiter_id + ", username=" + username + ", password=" + password
				+ ", company=" + company + ", telphone=" + telphone + ", email=" + email + "]";
	}

}
