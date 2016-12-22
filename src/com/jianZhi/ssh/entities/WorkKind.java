package com.jianZhi.ssh.entities;

public class WorkKind {
	private String workKindName;

	public WorkKind() {
		
	}
	
	public WorkKind(WorkKind w) {
		this.workKindName = w.getWorkKindName();
	}
	
	public String getWorkKindName() {
		return workKindName;
	}

	public void setWorkKindName(String workKindName) {
		this.workKindName = workKindName;
	}

	@Override
	public String toString() {
		return "WorkKind [workKindName=" + workKindName + "]";
	}

}
