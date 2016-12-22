package com.jianZhi.ssh.web;

public class RecruiterRegister {
	private String username;
	private String password;
	private String city;
	private String district;
	private String companyName;
	private String telphone;
	private String email;

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
		return "RecruiterRegister [username=" + username + ", password=" + password + ", city=" + city + ", district="
				+ district + ", companyName=" + companyName + ", telphone=" + telphone + ", email=" + email + "]";
	}

}
