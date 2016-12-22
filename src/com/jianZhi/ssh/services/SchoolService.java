package com.jianZhi.ssh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianZhi.ssh.Dao.SchoolDao;
import com.jianZhi.ssh.entities.School;

@Service
public class SchoolService {
	
	@Autowired
	private SchoolDao schoolDao;
	
	public School getSchool(String city, String district, String schoolName) {
		return schoolDao.selectSchoolByCityDistrictAndSchoolName(schoolName, city, district);
	}
	
}
