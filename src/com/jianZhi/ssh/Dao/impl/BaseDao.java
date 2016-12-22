package com.jianZhi.ssh.Dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.jianZhi.ssh.entities.Student;
import com.jianZhi.ssh.utils.ReflectionUtils;

public class BaseDao<T> {

	private SessionFactory sessionFactory;

	private Class<T> clazz;

	/*
	 * juni case test:
	 */
//
//	private Session session;
//
//	{
////		Configuration configuration = new Configuration().configure();
////		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
////				.buildServiceRegistry();
////		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
////		session = sessionFactory.openSession();
//	}

	{
		clazz = ReflectionUtils.getSuperGenericType(getClass());
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 插入一个对象
	 */
	public boolean insert(T t) {
		Session session = getSession();
		try {
			session.save(t);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 得到所有的对象
	 * @return
	 */
	public List<T> getAll() {
		return getSession().createQuery("from " + clazz.getName()).list();
	}

	/**
	 * 得到指定id的对象
	 * @param id
	 * @return
	 */
	public T get(long id) {
		int i = 0;
		if (clazz != Student.class) {
			i = (int) id;
			return (T) getSession().get(clazz, i);
		} else
			return (T) getSession().get(clazz, id);
	}

	/**
	 * 修改一个对象
	 * @param t
	 * @return
	 */
	public boolean update(T t) {
		Session session = getSession();
		try {
			session.update(t);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 删除一个对象
	 * @param t
	 * @return
	 */
	public boolean delete(T t) {
		Session session = getSession();
		try {
			session.delete(t);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<T> get(String hql, Object...args) {
		Query a = getSession().createQuery(hql);

		if (args != null && args.length != 0) {
			for (int i = 0; i < args.length; i++) {
				a.setParameter(i, args[i]);
			}
		}
		List<T> t = a.list();
		return t;
	}

	/**
	 * 指定
	 * 【min, max)的结果
	 * @param min
	 * @param max
	 * @param hql
	 * @param args
	 * @return
	 */
	public List<T> get(int min, int max, String hql, Object... args) {
		Query a = getSession().createQuery(hql);

		a.setFirstResult(min);
		a.setMaxResults(max);
		if (args != null && args.length != 0) {
			for (int i = 0; i < args.length; i++) {
				a.setParameter(i, args[i]);
			}
		}
		List<T> t = a.list();
		return t;
	}

	/**
	 * 指定
	 * @param min
	 * @param hql
	 * @param args
	 * @return
	 */
	public List<T> get(int min, String hql, Object... args) {
		Query a = getSession().createQuery(hql);

		a.setFirstResult(min);
		a.setMaxResults(10);
		if (args != null && args.length != 0) {
			for (int i = 0; i < args.length; i++) {
				a.setParameter(i, args[i]);
			}
		}
		List<T> t = a.list();
		return t;
	}
}
