package com.jianZhi.ssh.Dao.impl;

import org.springframework.stereotype.Repository;

import com.jianZhi.ssh.Dao.SchoolDao;
import com.jianZhi.ssh.entities.School;

@Repository("schoolDao")
public class SchoolDaoImpl extends BaseDao<School> implements SchoolDao {

	public void insertSchool(School c) {
		insert(c);
	}

	public boolean deleteSchool(int school_id) {
		School c = get(school_id);
		return delete(c);
	}

	public boolean updateSchool(School c) {
		return update(c);
	}

	public School selectSchool(int school_id) {
		return get(school_id);
	}

	public School selectSchoolByCityDistrictAndSchoolName(String schoolName, String city, String district) {
		String hql = "from School where city.cityName = ? and district = ? and schoolName = ?";
		return get(hql, city, district, schoolName).get(0);
	}

}
