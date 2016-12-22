package com.jianZhi.ssh.entities.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jianZhi.ssh.entities.City;
import com.jianZhi.ssh.entities.Correspond;
import com.jianZhi.ssh.entities.Recruiter;
import com.jianZhi.ssh.entities.Recruitment;
import com.jianZhi.ssh.entities.WorkKind;
public class TestEntities {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void init() throws Exception {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}
	
	@After
	public void destroy() throws Exception {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	@Test
	public void testSaveStudent() {
	}
	
	@Test
	public void testSaveSchool() {
		
	}
	
	@Test
	public void testSaveRecruitments() {
		Recruitment recruitment = new Recruitment();
		recruitment.setRecruitment_id(2);
		recruitment.setRecruiter((Recruiter)session.get(Recruiter.class, 1));
		recruitment.setTitle("招聘启事");
		recruitment.setAddress("广东dfdfdfdfdfdf");
		recruitment.setBeginYear(2016);
		recruitment.setBeginMonth(12);
		recruitment.setBeginDay(30);
		recruitment.setEndYear(2017);
		recruitment.setEndMonth(1);
		recruitment.setEndDay(30);
		recruitment.setDate(new Date());
		recruitment.setCity((City)session.get(City.class, "广州"));
		recruitment.setContext("招聘要求。。。");
		recruitment.setCorrespond((Correspond) session.get(Correspond.class, "兼职"));
		recruitment.setDistrict("海珠");
		recruitment.setPhone("18814095634");
		recruitment.setSalary(4545);
		recruitment.setWorkKind((WorkKind)session.get(WorkKind.class, "技术"));
		session.save(recruitment);
	}
}
