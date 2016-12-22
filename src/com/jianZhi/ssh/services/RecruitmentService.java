package com.jianZhi.ssh.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianZhi.ssh.Dao.RecruitmentDao;
import com.jianZhi.ssh.entities.Recruitment;
import com.jianZhi.ssh.web.RecruitmentSingle;

@Service
public class RecruitmentService {

	@Autowired
	private RecruitmentDao recruitmentDao;
	
	/**
	 * 指定id的招聘人发布一条招聘信息
	 */
	public boolean insertRecruitment(Recruitment recruitment, int recruiter_id) {
		return recruitmentDao.insertRecruitment(recruitment, recruiter_id);
	}
	
	/**
	 * 得到所有招聘信息
	 * @return
	 */
	public List<Recruitment> getAll() {
		return recruitmentDao.getAll();
	}
	
	/**
	 * map存储需要筛选的字段名和字段值
	 * @param map
	 * args存储需要排序的字段
	 * @param args
	 * @return
	 */
	public List<Recruitment> getRecruitmentsAndSort(List<String> list, String ... args) {
		return recruitmentDao.getRecruitments(list, args);
	}
	
	/**
	 * map存储需要筛选的字段名和字段值
	 * @param map
	 * args存储需要排序的字段
	 * @param args
	 * 返回一个简化版的招聘信息表
	 * @return
	 */
	public List<RecruitmentSingle> getRecruitmentsSingleAndSort(List<String> list, String ... args) {
		return recruitmentDao.getRecruitmentsSingle(list, args);
	}
	
	/**
	 * 找到特定id的招聘信息的信息情况。
	 * @param recruitment_id
	 * @return
	 */
	public Recruitment getRecruitmentById(int recruitment_id) {
		return recruitmentDao.getRecruitmentByRecruitmentId(recruitment_id);
	}
	
	/**
	 * 模糊搜索
	 */
	public List<Recruitment> find(String title) {
		return recruitmentDao.findMessageByTitle(title);
	}
	
	public List<RecruitmentSingle> findSingle(String title) {
		return recruitmentDao.findMessageByTitleSingle(title);
	}
	
	public List<Recruitment> getFlush(int min) {
		return recruitmentDao.getRecruitmentsByTime(min, null, "date");
	}
	
	public List<RecruitmentSingle> getFlushSingle(int min) {
		return recruitmentDao.getRecruitmentsSingleByTime(min, null, "date");
	}
	
	public boolean deleteRecruitment(int recruitment_id) {
		return recruitmentDao.deleteRecruitment(recruitment_id);
	}
	
	public List<Recruitment> getRecruitmentsByRecruiterId(int recruiter_id) {
		return recruitmentDao.getRecruitmentsByRecruiterId(recruiter_id);
	}
	
	public List<RecruitmentSingle> getRecruitmentsSingleByRecruiterId(int recruiter_id) {
		return recruitmentDao.getRecruitmentsSingleByRecruiterId(recruiter_id);
	}
}
