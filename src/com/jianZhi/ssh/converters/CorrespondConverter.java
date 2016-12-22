package com.jianZhi.ssh.converters;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;

import com.jianZhi.ssh.entities.Correspond;
import com.jianZhi.ssh.services.CorrespondService;

public class CorrespondConverter extends StrutsTypeConverter {

	@Autowired
	private CorrespondService correspondService;

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		if (arg2 == Correspond.class) {
			if (arg1 != null && arg1.length != 0) {
				return correspondService.getCorrespond(arg1[0].trim());
			}
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
