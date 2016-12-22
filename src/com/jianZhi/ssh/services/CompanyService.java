package com.jianZhi.ssh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianZhi.ssh.Dao.CompanyDao;
import com.jianZhi.ssh.entities.Company;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyDao companyDao;
	
	public Company getCompany(String city, String district, String companyName) {
		return companyDao.selectCompanyByCityDistrictCompanyName(city, district, companyName);
	}
	
}
