package com.jianZhi.ssh.web;

import com.jianZhi.ssh.entities.Correspond;
import com.jianZhi.ssh.entities.WorkKind;

public class RecruitmentSingle {
	
	private int recruitment_id;
	
	private String title;

	private WorkKind workKind;

	private Correspond correspond;

	private String workTime;

	private int salary;

	private String address;

	public RecruitmentSingle(int recruitment_id, String title, WorkKind workKind, Correspond correspond, String workTime, int salary, String address) {
		this.recruitment_id = recruitment_id;
		this.title = title;
		this.workKind = new WorkKind(workKind);
		this.correspond = new Correspond(correspond);
		this.workTime = workTime;
		this.salary = salary;
		this.address = address;
	}
	
	public RecruitmentSingle(RecruitmentSingle r) {
		this.recruitment_id = r.getRecruitment_id();
		this.title = r.getTitle();
		this.workKind = r.getWorkKind();
		this.correspond = r.getCorrespond();
		this.workTime = r.getWorkTime();
		this.salary = r.getSalary();
		this.address = r.getAddress();
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public WorkKind getWorkKind() {
		return workKind;
	}

	public void setWorkKind(WorkKind workKind) {
		this.workKind = workKind;
	}

	public Correspond getCorrespond() {
		return correspond;
	}

	public void setCorrespond(Correspond correspond) {
		this.correspond = correspond;
	}

	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRecruitment_id() {
		return recruitment_id;
	}

	public void setRecruitment_id(int recruitment_id) {
		this.recruitment_id = recruitment_id;
	}


	@Override
	public String toString() {
		return "RecruitmentSingle [recruitment_id=" + recruitment_id + ", title=" + title + ", workKind=" + workKind
				+ ", correspond=" + correspond + ", workTime=" + workTime + ", salary=" + salary + ", address="
				+ address + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((correspond == null) ? 0 : correspond.hashCode());
		result = prime * result + recruitment_id;
		result = prime * result + salary;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((workKind == null) ? 0 : workKind.hashCode());
		result = prime * result + ((workTime == null) ? 0 : workTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecruitmentSingle other = (RecruitmentSingle) obj;
		if(recruitment_id == other.getRecruitment_id())
			return true;
		return false;
	}

}
