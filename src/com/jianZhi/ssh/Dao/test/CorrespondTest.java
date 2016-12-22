package com.jianZhi.ssh.Dao.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jianZhi.ssh.Dao.CorrespondDao;
import com.jianZhi.ssh.Dao.impl.CorrespondDaoImpl;
import com.jianZhi.ssh.entities.Correspond;

public class CorrespondTest {

	private CorrespondDao correspondDao = new CorrespondDaoImpl();
	
	@Test
	public void test() {
		String name = "实习";
		Correspond correspond = correspondDao.getCorrespond(name);
		System.out.println(correspond);
	}

}
