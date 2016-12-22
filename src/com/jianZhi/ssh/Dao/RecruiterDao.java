package com.jianZhi.ssh.Dao;

import java.util.List;

import com.jianZhi.ssh.entities.Company;
import com.jianZhi.ssh.entities.Recruiter;
import com.jianZhi.ssh.web.RecruiterLogin;

public interface RecruiterDao {

	/**
	 * 是否存在该账号密码的招聘人
	 * @return 成功返回true,失败返回false;
	 */
	public boolean isHaveRecruiter(RecruiterLogin s);
	
	/**
	 * 插入一个招聘人
	 * @param s
	 * @return
	 */
	public boolean insertRecruiter(Recruiter s);
	
	/**
	 * 得到特定id的招聘人对象
	 * @param student_id
	 * @return
	 */
	public Recruiter getRecruiter(int recruiter_id);
	
	/**
	 * 招聘人
	 * @param student_id
	 */
	public boolean deleteRecruiter(int recruiter_id);
	
	/**
	 * 得到所有招聘人，后续考虑分页问题
	 * @return
	 */
	public List<Recruiter> getAll();
	
	/**
	 * 修改特定的招聘人信息
	 * @param s
	 */
	public boolean updateRecruiter(Recruiter s);
	
	public Company getCompanyByRecruiter(int recruiter_id);
	
	public Recruiter getRecruiter(String username, String password);
}
