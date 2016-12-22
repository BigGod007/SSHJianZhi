package com.jianZhi.ssh.Dao.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jianZhi.ssh.Dao.WorkKindDao;
import com.jianZhi.ssh.Dao.impl.WorkKindDaoImpl;
import com.jianZhi.ssh.entities.WorkKind;

public class WorkKindTest {

	private WorkKindDao workKindDao = new WorkKindDaoImpl();
	
	@Test
	public void test() {
		String name = "派单";
		WorkKind workKind = workKindDao.getWorkKind(name);
		System.out.println(workKind);
	}

}
