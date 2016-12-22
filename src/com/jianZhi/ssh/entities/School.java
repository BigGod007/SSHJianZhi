package com.jianZhi.ssh.entities;

public class School {
	private Integer school_id;
	private String schoolName;
	private City city;
	private String district;
	private String address;

	public School() {
	}
	
	public School(School s) {
		this.school_id = s.getSchool_id();
		this.schoolName = s.getSchoolName();
		this.city = new City(s.getCity());
		this.district = s.getDistrict();
		this.address = s.getAddress();
	}
	
	public Integer getSchool_id() {
		return school_id;
	}

	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "School [school_id=" + school_id + ", schoolName=" + schoolName + ", city=" + city + ", district="
				+ district + "]";
	}

	
}
