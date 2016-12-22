package com.jianZhi.ssh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianZhi.ssh.Dao.CityDao;
import com.jianZhi.ssh.entities.City;

@Service
public class CityService {

	@Autowired
	private CityDao cityDao;
	
	public City getCity(String cityName) {
		return cityDao.getCityByName(cityName);
	}
	
}
