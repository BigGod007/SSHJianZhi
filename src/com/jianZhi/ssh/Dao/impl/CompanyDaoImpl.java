package com.jianZhi.ssh.Dao.impl;

import org.springframework.stereotype.Repository;

import com.jianZhi.ssh.Dao.CompanyDao;
import com.jianZhi.ssh.entities.Company;

@Repository("companyDao")
public class CompanyDaoImpl extends BaseDao<Company> implements CompanyDao{

	public void insertCompany(Company c) {
		insert(c);
	}

	public boolean deleteSchool(int company_id) {
		Company c = get(company_id);
		return delete(c);
	}

	public boolean updateSchool(Company c) {
		return update(c);
	}

	public Company selectSchool(int company_id) {
		return get(company_id);
	}

	public Company selectCompanyByCityDistrictCompanyName(String city, String district, String companyName) {
		String hql = "from Company where city.cityName = ? and district = ? and companyName = ?";
		return get(hql, city, district, companyName).get(0);
	}

}
