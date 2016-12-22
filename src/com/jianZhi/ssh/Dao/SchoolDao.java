package com.jianZhi.ssh.Dao;

import com.jianZhi.ssh.entities.School;

public interface SchoolDao {
	public void insertSchool(School c);

	public boolean deleteSchool(int school_id);

	public boolean updateSchool(School c);

	public School selectSchool(int school_id);
	
	public School selectSchoolByCityDistrictAndSchoolName(String schoolName, String city, String district);
}
