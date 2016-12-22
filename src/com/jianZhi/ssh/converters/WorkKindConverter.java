package com.jianZhi.ssh.converters;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;

import com.jianZhi.ssh.entities.WorkKind;
import com.jianZhi.ssh.services.WorkKindService;

public class WorkKindConverter extends StrutsTypeConverter {

	@Autowired
	private WorkKindService workKindService;

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		if (arg2 == WorkKind.class) {
			if (arg1 != null && arg1.length != 0) {
				return workKindService.getWorkKindByName(arg1[0].trim());
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
