package com.jianZhi.ssh.entities;

public class Correspond {
	private String correspondName;

	public Correspond() {
		
	}
	
	public Correspond(Correspond c) {
		this.correspondName = c.getCorrespondName();
	}
	
	public String getCorrespondName() {
		return correspondName;
	}

	public void setCorrespondName(String correspondName) {
		this.correspondName = correspondName;
	}

	@Override
	public String toString() {
		return "Correspond [correspondName=" + correspondName + "]";
	}
	
}
