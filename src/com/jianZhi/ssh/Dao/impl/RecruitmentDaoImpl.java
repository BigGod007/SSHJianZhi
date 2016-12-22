package com.jianZhi.ssh.Dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.jianZhi.ssh.Dao.RecruitmentDao;
import com.jianZhi.ssh.entities.Recruiter;
import com.jianZhi.ssh.entities.Recruitment;
import com.jianZhi.ssh.web.RecruitmentSingle;

@Repository("recruitmentDao")
public class RecruitmentDaoImpl extends BaseDao<Recruitment> implements RecruitmentDao{

	public boolean insertRecruitment(Recruitment s, int Recruiter_id) {
		s.setRecruiter((Recruiter)getSession().get(Recruiter.class, Recruiter_id));
		return insert(s);
	}

	public Recruitment getRecruitmentByRecruitmentId(int recruitment_id) {
		return get(recruitment_id);
	}

	public boolean deleteRecruitment(int recruitment_id) {
		Recruitment r = get(recruitment_id);
		return delete(r);
	}

	public boolean updateRecruiter(Recruitment s) {
		return update(s);
	}

	public List<Recruitment> getRecruitmentsByTime(int min, List<String> strings, String... args) {
		StringBuilder hql = new StringBuilder("from Recruitment");
		if(strings != null && strings.size() != 0) {
			hql = hql.append(" where");
			for(int i = 0; i < strings.size(); i++) {
				String temp = strings.get(i);
				String key = temp.substring(0, temp.indexOf('='));
				String value = temp.substring(temp.indexOf('=') + 1, temp.length());
				hql = hql.append(" " + key + "=" + "'" + value + "'");
				if(i != strings.size() - 1)
					hql = hql.append(" and");
			}
		}
		if(args != null && args.length != 0) {
			hql = hql.append(" order by");
			for(int i = 0; i < args.length; i++) {
				hql = hql.append(" " + args[i]);
				if(i != args.length - 1)
					hql = hql.append(",");
			}
		}
		return get(min, hql.toString());
	}
	
	public List<Recruitment> getRecruitments(List<String> strings, String... args) {
		System.out.println(strings.size() + " " + args.length + " ");
		System.out.println(strings);
		System.out.println(Arrays.asList(args));
		StringBuilder hql = new StringBuilder("from Recruitment");
		if(strings != null && strings.size() != 0) {
			hql = hql.append(" where");
			for(int i = 0; i < strings.size(); i++) {
				String temp = strings.get(i);
				temp.indexOf('=');
				String key = temp.substring(0, temp.indexOf('='));
				String value = temp.substring(temp.indexOf('=') + 1, temp.length());
				hql = hql.append(" " + key + "=" + "'" + value + "'");
				if(i != strings.size() - 1)
					hql = hql.append(" and");
			}
		}
		if(args != null && args.length != 0) {
			if(args.length == 1 && args[0].trim().length() != 0)
				hql.append(" order by " + args[0]);
		}
		return get(hql.toString());
	}
	
	public List<RecruitmentSingle> getRecruitmentsSingleByTime(int min, List<String> strings, String...args) {
		List<Recruitment> list = getRecruitmentsByTime(min, strings, args);
		List<RecruitmentSingle> list2 = new ArrayList<RecruitmentSingle>();
		for(int i = 0; i < list.size(); i++) {
			Recruitment r = list.get(i);
			RecruitmentSingle r2 = new RecruitmentSingle(r.getRecruitment_id(),
														 r.getTitle(), 
														 r.getWorkKind(), 
														 r.getCorrespond(),
														 r.getBeginYear() + "." + r.getBeginMonth() + "." + r.getBeginDay() + "-" + r.getEndYear() + "." + r.getEndMonth() + "." + r.getEndDay(),
														 r.getSalary(), 
														 r.getAddress());
			list2.add(r2);
		}
		return list2;
	}

	public List<RecruitmentSingle> getRecruitmentsSingle(List<String> strings, String... args) {
		List<Recruitment> list = getRecruitments(strings, args);
		List<RecruitmentSingle> list2 = new ArrayList<RecruitmentSingle>();
		for(int i = 0; i < list.size(); i++) {
			Recruitment r = list.get(i);
			RecruitmentSingle r2 = new RecruitmentSingle(r.getRecruitment_id(),
														 r.getTitle(), 
														 r.getWorkKind(), 
														 r.getCorrespond(),
														 r.getBeginYear() + "." + r.getBeginMonth() + "." + r.getBeginDay() + "-" + r.getEndYear() + "." + r.getEndMonth() + "." + r.getEndDay(),
														 r.getSalary(), 
														 r.getAddress());
			list2.add(r2);
		}
		return list2;
	}

	public List<Recruitment> findMessageByTitle(String title) {
		String hql = "from Recruitment where title like ?";
		return get(hql, title); 
	}
	
	public List<RecruitmentSingle> findMessageByTitleSingle(String title) {
		List<Recruitment> list = findMessageByTitle(title);
		List<RecruitmentSingle> list2 = new ArrayList<RecruitmentSingle>();
		for(int i = 0; i < list.size(); i++) {
			Recruitment r = list.get(i);
			RecruitmentSingle r2 = new RecruitmentSingle(r.getRecruitment_id(),
														 r.getTitle(), 
														 r.getWorkKind(), 
														 r.getCorrespond(),
														 r.getBeginYear() + "." + r.getBeginMonth() + "." + r.getBeginDay() + "-" + r.getEndYear() + "." + r.getEndMonth() + "." + r.getEndDay(),
														 r.getSalary(), 
														 r.getAddress());
			list2.add(r2);
		}
		return list2;
	}

	public List<Recruitment> getRecruitmentsByRecruiterId(int recruiter_id) {
		String hql = "from Recruitment where recruiter.recruiter_id = ?";
		return get(hql, recruiter_id);
	}

	public List<RecruitmentSingle> getRecruitmentsSingleByRecruiterId(int recruiter_id) {
		List<Recruitment> list = getRecruitmentsByRecruiterId(recruiter_id);
		List<RecruitmentSingle> list2 = new ArrayList<RecruitmentSingle>();
		for(int i = 0; i < list.size(); i++) {
			Recruitment r = list.get(i);
			RecruitmentSingle r2 = new RecruitmentSingle(r.getRecruitment_id(),
														 r.getTitle(), 
														 r.getWorkKind(), 
														 r.getCorrespond(),
														 r.getBeginYear() + "." + r.getBeginMonth() + "." + r.getBeginDay() + "-" + r.getEndYear() + "." + r.getEndMonth() + "." + r.getEndDay(),
														 r.getSalary(), 
														 r.getAddress());
			list2.add(r2);
		}
		return list2;
	}
}
