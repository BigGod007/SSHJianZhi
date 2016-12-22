package com.jianZhi.ssh.Dao.test;

import org.junit.Test;

import com.jianZhi.ssh.Dao.SchoolDao;
import com.jianZhi.ssh.Dao.impl.SchoolDaoImpl;
import com.jianZhi.ssh.entities.School;

public class SchoolDaoTest {

	private SchoolDao schoolDao = new SchoolDaoImpl();
	
	@Test
	public void test() {
		School c = new School();
		schoolDao.insertSchool(c);
	}

}
