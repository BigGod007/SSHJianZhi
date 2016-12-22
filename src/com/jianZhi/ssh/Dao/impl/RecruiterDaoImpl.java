package com.jianZhi.ssh.Dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.jianZhi.ssh.Dao.RecruiterDao;
import com.jianZhi.ssh.entities.Company;
import com.jianZhi.ssh.entities.Recruiter;
import com.jianZhi.ssh.entities.Student;
import com.jianZhi.ssh.web.RecruiterLogin;

@Repository("recruiterDao")
public class RecruiterDaoImpl extends BaseDao<Recruiter> implements RecruiterDao {

	public boolean isHaveRecruiter(RecruiterLogin s) {
		String hql = "from Recruiter r where r.username = ? and r.password = ?";
		List<Recruiter> list = get(hql, s.getUsername(), s.getPassword());
		if(list.size() == 0)
			return false;
		return true;
	}

	public boolean insertRecruiter(Recruiter s) {
		return insert(s);
	}

	public Recruiter getRecruiter(int recruiter_id) {
		return get(recruiter_id);
	}

	public boolean deleteRecruiter(int recruiter_id) {
		Recruiter r = get(recruiter_id);
		return delete(r);
	}

	public List<Recruiter> getAll() {
		String hql = "from Recruiter";
		return get(hql);
	}

	public boolean updateRecruiter(Recruiter s) {
		return update(s);
	}

	public Company getCompanyByRecruiter(int recruiter_id) {
		Recruiter r = get(recruiter_id);
		return r.getCompany();
	}

	public Recruiter getRecruiter(String username, String password) {
		String hql = "from Recruiter where username = ? and password = ?";
		return get(hql, username, password).get(0);
	}
	
}
