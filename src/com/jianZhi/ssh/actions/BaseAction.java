package com.jianZhi.ssh.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements SessionAware{
	
	private Map<String, Object> session;
	
	public String toHome() {
		return (String) session.get("kind");
	}

	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}
