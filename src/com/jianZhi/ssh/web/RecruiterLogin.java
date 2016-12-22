package com.jianZhi.ssh.web;

public class RecruiterLogin {

	private String username;
	private String password;

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

	@Override
	public String toString() {
		return "RecruiterLogin [username=" + username + ", password=" + password + "]";
	}

}
