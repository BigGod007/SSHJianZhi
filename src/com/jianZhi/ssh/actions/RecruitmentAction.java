package com.jianZhi.ssh.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.jianZhi.ssh.entities.City;
import com.jianZhi.ssh.entities.Correspond;
import com.jianZhi.ssh.entities.Recruiter;
import com.jianZhi.ssh.entities.Recruitment;
import com.jianZhi.ssh.entities.WorkKind;
import com.jianZhi.ssh.services.CityService;
import com.jianZhi.ssh.services.CorrespondService;
import com.jianZhi.ssh.services.RecruiterService;
import com.jianZhi.ssh.services.RecruitmentService;
import com.jianZhi.ssh.services.WorkKindService;
import com.jianZhi.ssh.utils.HttpUtils;
import com.jianZhi.ssh.web.RecruitmentSingle;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RecruitmentAction extends ActionSupport implements SessionAware, RequestAware{
	@Autowired
	private RecruitmentService recruitmentService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private CorrespondService correspondService;
	
	@Autowired
	private WorkKindService workKindService;
	
	@Autowired
	private RecruiterService recruiterService;
	
	private Map<String, Object> session;
	private Map<String, Object> request;
		
//	public Recruitment getRecruitment() {
//		return recruitment;
//	}

//	public void setRecruitment(Recruitment recruitment) {
//		this.recruitment = recruitment;
//	}

	//private Recruitment recruitment;
	private String title;
	private City city; 
	private String district;
	private String address;
	private Integer salary;
	private String phone;
	private Integer beginYear;
	private Integer beginMonth;
	private Integer beginDay;
	private Integer endYear;
	private Integer endMonth;
	private Integer endDay;
	private Correspond correspond;//工作性质
	private WorkKind workKind;
	private Date date;
	private Recruiter recruiter;
	private String context;
	
	private String sort;

	private String cityFilter;
	private String districtFilter;
	private String correspondFilter;
	private String workKindFilter;
	
	private int id;
	
	public String getMine() {
		Recruiter recruiter = recruiterService.getRecruiter((Integer) session.get("id"));
		List<Recruitment> list = recruitmentService.getRecruitmentsByRecruiterId((Integer) session.get("id"));
		request.put("list", list);
		request.put("rec", recruiter);
		return SUCCESS;
	}
	
	public String delete() {
		boolean flag = recruitmentService.deleteRecruitment(id);
		if(flag)
			return SUCCESS;
		else
			return "input";
	}
	
	public String add() {
		Recruitment recruitment = new Recruitment();
		recruitment.setTitle(title);
		recruitment.setCity(city);;
		recruitment.setDistrict(district);
		recruitment.setAddress(address);
		recruitment.setSalary(salary);
		recruitment.setPhone(phone);
		recruitment.setBeginYear(beginYear);
		recruitment.setBeginMonth(beginMonth);
		recruitment.setBeginDay(beginDay);
		recruitment.setEndYear(endYear);
		recruitment.setEndMonth(endMonth);
		recruitment.setEndDay(endDay);
		recruitment.setCorrespond(correspond);
		recruitment.setWorkKind(workKind);
		recruitment.setDate(new Date());
		recruitment.setContext(context);
		boolean flag = recruitmentService.insertRecruitment(recruitment, (Integer)session.get("id"));
		if(flag)
			return SUCCESS;
		else
			return "input";
	}

	public String list() {
		try {
			List<Recruitment> list = null;
			List<String> listFilter = new ArrayList<String>();
			
			if(cityFilter != null && !cityFilter.equals(""))
				listFilter.add("city.cityName=" + cityFilter);
			if(districtFilter != null && !districtFilter.equals(""))
				listFilter.add("district=" + districtFilter);
			if(correspondFilter != null && !correspondFilter.equals(""))
				listFilter.add("correspond.correspondName=" + correspondFilter);
			if(workKindFilter != null && !workKindFilter.equals(""))
				listFilter.add("workKind.workKindName=" + workKindFilter);
			
			if(sort != null && !sort.equals("")) {
				if(sort.equals("薪资")) {
					list = recruitmentService.getRecruitmentsAndSort(listFilter, "salary");
				} else if(sort.equals("发布时间")) {
					list = recruitmentService.getRecruitmentsAndSort(listFilter, "date");
				} else {
					list = recruitmentService.getRecruitmentsAndSort(listFilter);
				}
			} else {
				list = recruitmentService.getRecruitmentsAndSort(listFilter);
			}
			request.put("list", list);
		} catch(Exception x) {
			x.printStackTrace();
			return "input";
		}
		return SUCCESS;
	}
	
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	public Recruitment getModel() {
		return new Recruitment();
	}
	
	public void deleteForAndroid() throws Exception {
		HttpServletRequest request = HttpUtils.getRequest();
		HttpServletResponse response = HttpUtils.getResponse("application/json");
		int num = Integer.parseInt(request.getParameter("id"));
		boolean flag = recruitmentService.deleteRecruitment(num);
		int flagNum = 0;
		
		if(flag) {
			flagNum = 1;
		} else {
			flagNum = -1;
		}
		
		Gson gson = new Gson();
		String data = gson.toJson(flagNum);
		response.getWriter().print(data);
	}
	
	public void getForStudent() throws Exception {
		HttpServletRequest request = HttpUtils.getRequest();
		HttpServletResponse response = HttpUtils.getResponse("application/json");
		String pass = request.getParameter("howToFilter");
		String sort = request.getParameter("howToSort");
		String title = request.getParameter("title");
		StringBuilder sb = new StringBuilder();
		if(sort != null && sort.trim().length() != 0) {
			if(sort.charAt(0) == '1')
				sb.append("date");
			else
				sb.append("salary");
			if(sort.charAt(1) == 'd')
				sb.append(" desc");
			else
				sb.append(" asc");
		}
		List<String> list = null;
		if(pass != null && pass.trim().length() != 0)
			list = decode(pass);
		String args = sb.toString();
		List<RecruitmentSingle> res = recruitmentService.getRecruitmentsSingleAndSort(list, args);
		List<RecruitmentSingle> list2 = new ArrayList<RecruitmentSingle>();
		if(title != null && title.trim().length() != 0) {
			List<RecruitmentSingle> res2 = recruitmentService.findSingle("%" + title + "%");
			
			for(int i = 0; i < res.size(); i++) {
				for(int j = 0; j < res2.size(); j++) {
					if(res.get(i).equals(res2.get(j)))
						list2.add(res.get(i));
				}
			}
		} else {
			list2 = res;
		}
		
		List<RecruitmentSingle> res2 = new ArrayList<RecruitmentSingle>();
		
		for(int i = 0; i < list2.size(); i++) {
			RecruitmentSingle r = new RecruitmentSingle(list2.get(i));
			res2.add(r);
		}
		
		Gson gson = new Gson();
		String data = gson.toJson(res2);
		response.getWriter().print(data);
	}
	
	public void flush() throws Exception {
		HttpServletRequest request = HttpUtils.getRequest();
		HttpServletResponse response = HttpUtils.getResponse("application/json");
		int num = Integer.parseInt(request.getParameter("num"));
		List<RecruitmentSingle> list = recruitmentService.getFlushSingle(num);
		
		List<RecruitmentSingle> res = new ArrayList<RecruitmentSingle>();
		
		for(int i = 0; i < list.size(); i++) {
			RecruitmentSingle r = new RecruitmentSingle(list.get(i));
			res.add(r);
		}
		
		Gson gson = new Gson();
		String data = gson.toJson(res);
		response.getWriter().print(data);
	}
	
	public void getRecruitmentByid() throws Exception {
		HttpServletRequest request = HttpUtils.getRequest();
		HttpServletResponse response = HttpUtils.getResponse("application/json");
		
		int recruitment_id = Integer.parseInt(request.getParameter("id"));
		Recruitment r = recruitmentService.getRecruitmentById(recruitment_id);
		
		Recruitment res = new Recruitment(r);
		Gson gson = new Gson();
		String data = gson.toJson(res);
		response.getWriter().print(data);
	}
	
	public void getRecruitmentsByRecruiterId() throws Exception { 
		HttpServletRequest request = HttpUtils.getRequest();
		HttpServletResponse response = HttpUtils.getResponse("application/json");
		int id = Integer.parseInt(request.getParameter("id"));
		List<RecruitmentSingle> list = recruitmentService.getRecruitmentsSingleByRecruiterId(id);
		
		Gson gson = new Gson();
		String data = gson.toJson(list);
		response.getWriter().print(data);
	}
	
	public void getForRecruiter() throws Exception {
		HttpServletRequest request = HttpUtils.getRequest();
		HttpServletResponse response = HttpUtils.getResponse("application/json");
		String pass = request.getParameter("howToFilter");
		String sort = request.getParameter("howToSort");
		String title = request.getParameter("title");
		StringBuilder sb = new StringBuilder();
		if(sort != null && sort.trim().length() != 0) {
			if(sort.charAt(0) == '1')
				sb.append("date");
			else
				sb.append("salary");
			if(sort.charAt(1) == 'd')
				sb.append(" desc");
			else
				sb.append(" asc");
		}
		List<String> list = null;
		if(pass != null && pass.trim().length() != 0)
			list = decode(pass);
		String args = sb.toString();
		List<RecruitmentSingle> res = recruitmentService.getRecruitmentsSingleAndSort(list, args);
		List<RecruitmentSingle> list2 = new ArrayList<RecruitmentSingle>();
		if(title != null && title.trim().length() != 0) {
			List<RecruitmentSingle> res2 = recruitmentService.findSingle("%" + title + "%");
			
			for(int i = 0; i < res.size(); i++) {
				for(int j = 0; j < res2.size(); j++) {
					if(res.get(i).equals(res2.get(j)))
						list2.add(res.get(i));
				}
			}
		} else {
			list2 = res;
		}
		
		List<RecruitmentSingle> res2 = new ArrayList<RecruitmentSingle>();
		
		for(int i = 0; i < list2.size(); i++) {
			RecruitmentSingle r = new RecruitmentSingle(list2.get(i));
			res2.add(r);
		}
		
		Gson gson = new Gson();
		String data = gson.toJson(res2);
		response.getWriter().print(data);
	}
	
	public void insertAdd() throws Exception {
		HttpServletRequest request = HttpUtils.getRequest();
		HttpServletResponse response = HttpUtils.getResponse("application/json");
		
		String title = request.getParameter("title");
		String cityName = request.getParameter("cityName");
		City city = cityService.getCity(cityName);
		String district = request.getParameter("district");
		String address = request.getParameter("address");
		int salary = Integer.parseInt(request.getParameter("salary"));
		String phone = request.getParameter("phone");
		int beginYear = Integer.parseInt(request.getParameter("beginYear"));
		int beginMonth = Integer.parseInt(request.getParameter("beginMonth"));
		int beginDay = Integer.parseInt(request.getParameter("beginDay"));
		int endYear = Integer.parseInt(request.getParameter("endYear"));
		int endMonth = Integer.parseInt(request.getParameter("endMonth"));
		int endDay = Integer.parseInt(request.getParameter("endDay"));
		String c = request.getParameter("correspondName");
		Correspond correspond = correspondService.getCorrespond(c);
		WorkKind workKind = workKindService.getWorkKindByName(request.getParameter("workKindName"));
		int recruiter_id = Integer.parseInt(request.getParameter("id"));
		String context = request.getParameter("context");
		
		Recruitment r = new Recruitment();
		r.setTitle(title);
		r.setCity(city);
		r.setDistrict(district);
		r.setAddress(address);
		r.setSalary(salary);
		r.setPhone(phone);
		r.setBeginYear(beginYear);
		r.setBeginMonth(beginMonth);
		r.setBeginDay(beginDay);
		r.setEndYear(endYear);
		r.setEndMonth(endMonth);
		r.setEndDay(endDay);
		r.setCorrespond(correspond);
		r.setWorkKind(workKind);
		r.setDate(new Date());
		r.setContext(context);
		
		int flagNum = 0;
		
		boolean flag = recruitmentService.insertRecruitment(r, recruiter_id);
		
		if(flag) {
			flagNum = 1;
		} else {
			flagNum = -1;
		}

		Gson gson = new Gson();
		String data = gson.toJson(flagNum);
		response.getWriter().print(data);
	}
	
	private List<String> decode(String pass) {
		String [] tmp = pass.split(",");
		List<String> list = Arrays.asList(tmp);
		return list;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getBeginYear() {
		return beginYear;
	}

	public void setBeginYear(Integer beginYear) {
		this.beginYear = beginYear;
	}

	public Integer getBeginMonth() {
		return beginMonth;
	}

	public void setBeginMonth(Integer beginMonth) {
		this.beginMonth = beginMonth;
	}

	public Integer getBeginDay() {
		return beginDay;
	}

	public void setBeginDay(Integer beginDay) {
		this.beginDay = beginDay;
	}

	public Integer getEndYear() {
		return endYear;
	}

	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
	}

	public Integer getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(Integer endMonth) {
		this.endMonth = endMonth;
	}

	public Integer getEndDay() {
		return endDay;
	}

	public void setEndDay(Integer endDay) {
		this.endDay = endDay;
	}

	public Correspond getCorrespond() {
		return correspond;
	}

	public void setCorrespond(Correspond correspond) {
		this.correspond = correspond;
	}

	public WorkKind getWorkKind() {
		return workKind;
	}

	public void setWorkKind(WorkKind workKind) {
		this.workKind = workKind;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Recruiter getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
	
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}
	

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getCityFilter() {
		return cityFilter;
	}

	public void setCityFilter(String cityFilter) {
		this.cityFilter = cityFilter;
	}

	public String getDistrictFilter() {
		return districtFilter;
	}

	public void setDistrictFilter(String districtFilter) {
		this.districtFilter = districtFilter;
	}

	public String getCorrespondFilter() {
		return correspondFilter;
	}

	public void setCorrespondFilter(String correspondFilter) {
		this.correspondFilter = correspondFilter;
	}

	public String getWorkKindFilter() {
		return workKindFilter;
	}

	public void setWorkKindFilter(String workKindFilter) {
		this.workKindFilter = workKindFilter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
