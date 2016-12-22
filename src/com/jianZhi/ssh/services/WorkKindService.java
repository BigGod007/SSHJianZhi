package com.jianZhi.ssh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianZhi.ssh.Dao.WorkKindDao;
import com.jianZhi.ssh.entities.WorkKind;

@Service
public class WorkKindService {
	
	@Autowired
	private WorkKindDao workKindDao;
	
	public WorkKind getWorkKindByName(String workKindName) {
		return workKindDao.getWorkKind(workKindName);
	}
	
}
