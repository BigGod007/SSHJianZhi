package com.jianZhi.ssh.converters;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;

import com.jianZhi.ssh.entities.City;
import com.jianZhi.ssh.services.CityService;

public class CityConverter extends StrutsTypeConverter {

	@Autowired
	private CityService cityService;

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		if (arg2 == City.class) {
			if (arg1 != null && arg1.length != 0) {
				return cityService.getCity(arg1[0].trim());
			}
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		return null;
	}

}
