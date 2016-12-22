package com.jianZhi.ssh.Dao;

import java.util.List;
import java.util.Map;

import com.jianZhi.ssh.entities.Recruiter;
import com.jianZhi.ssh.entities.Recruitment;
import com.jianZhi.ssh.web.RecruitmentSingle;

public interface RecruitmentDao {

	
	/**
	 * 插入一个招聘信息
	 * @param s
	 * @return
	 */
	public boolean insertRecruitment(Recruitment s, int Recruiter_id);
	
	/**
	 * 得到特定id的招聘信息
	 * @param student_id
	 * @return
	 */
	public Recruitment getRecruitmentByRecruitmentId(int recruitment_id);
	
 	/**
	 * 删除招聘信息
	 * @param student_id
	 */
	public boolean deleteRecruitment(int recruitment_id);
	
	/**
	 * 得到所有招聘信息，后续考虑分页问题
	 * @return
	 */
	public List<Recruitment> getAll();
	
	/**
	 * 修改特定的招聘信息信息
	 * @param s
	 */
	public boolean updateRecruiter(Recruitment s);
	
	/**
	 * strings值传入需要进行筛选的字段名与字段值
	 * 比如username=linying
	 * 服务端通过解析这种格式获取键、值
	 * @param strings
	 * @param args
	 * @return
	 */
	public List<Recruitment> getRecruitments(List<String> strings, String...args);
	
	/**
	 * (简化版)
	 * strings值传入需要进行筛选的字段名与字段值
	 * 比如username=linying
	 * 服务端通过解析这种格式获取键、值
	 * @param strings
	 * @param args
	 * @return
	 */
	public List<RecruitmentSingle> getRecruitmentsSingle(List<String> strings, String...args);
	
	/**
	 * @param min
	 * @param strings
	 * @param args
	 * @return
	 */
	public List<Recruitment> getRecruitmentsByTime(int min, List<String> strings, String...args);
	
	/**
	 * 
	 * @param min
	 * @param strings
	 * @param args
	 * @return
	 */
	public List<RecruitmentSingle> getRecruitmentsSingleByTime(int min, List<String> strings, String...args);
	
	/**
	 * 模糊查询
	 */
	public List<Recruitment> findMessageByTitle(String title);
	
	/**
	 * 模糊查询
	 */
	public List<RecruitmentSingle> findMessageByTitleSingle(String title);
	
	public List<Recruitment> getRecruitmentsByRecruiterId(int recruiter_id);

	public List<RecruitmentSingle> getRecruitmentsSingleByRecruiterId(int recruiter_id);
}
