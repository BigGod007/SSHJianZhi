package com.jianZhi.ssh.Dao;

import java.util.List;

import com.jianZhi.ssh.web.RecruitmentSingle;

public interface RecruitmentSingleDao {
	/**
	 * 通过招聘人id找到该招聘人id的招聘信息（简化版）,并排序
	 * @param recruiter_id
	 * @param order
	 * @return
	 */
	public List<RecruitmentSingle> getRecruitmentSingleByRecruiteridOrder(int recruiter_id, String...order);
	
	/**
	 * 得到所有招聘信息(简化版)，后续考虑分页问题
	 * @return
	 */
	public List<RecruitmentSingle> getRecruitmentSingleAll();
	
}
