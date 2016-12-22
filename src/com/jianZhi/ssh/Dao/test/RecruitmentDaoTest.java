package com.jianZhi.ssh.Dao.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.jianZhi.ssh.Dao.RecruitmentDao;
import com.jianZhi.ssh.Dao.impl.RecruitmentDaoImpl;
import com.jianZhi.ssh.entities.Recruitment;

public class RecruitmentDaoTest {

	private RecruitmentDao recruitmentDao = new RecruitmentDaoImpl(); 
	
	@Test
	public void testSave() {
		Recruitment s = new Recruitment();
		recruitmentDao.insertRecruitment(s, 1);
	}
	
	@Test
	public void testGetRecruitment() {
		Recruitment r = recruitmentDao.getRecruitmentByRecruitmentId(12);
		System.out.println(r);
	}
	
	
	@Test
	public void testDelete() {
		int id = 4;
		System.out.println(recruitmentDao.deleteRecruitment(id));
	}
	
	@Test
	public void testUpdate() {
		int id = 3;
		Recruitment r = recruitmentDao.getRecruitmentByRecruitmentId(id);
		r.setAddress("dfdf@df");
		System.out.println(recruitmentDao.updateRecruiter(r));
	}
	
	@Test
	public void testGetByTiaoJian() {
		List<String> list = new ArrayList<String>();
//		map.put("city.cityName", "广州");
//		map.put("district", "白云");
		list.add("city.cityName=广州");
		list.add("district=白云");
		System.out.println(recruitmentDao.getRecruitments(list, "salary"));
	}
}
