package com.jianZhi.ssh.Dao;

import com.jianZhi.ssh.entities.Company;

public interface CompanyDao {
	public void insertCompany(Company c);
	
	public boolean deleteSchool(int company_id);
	
	public boolean updateSchool(Company c);
	
	public Company selectSchool(int company_id);
	
	public Company selectCompanyByCityDistrictCompanyName(String city, String district, String companyName);
}
