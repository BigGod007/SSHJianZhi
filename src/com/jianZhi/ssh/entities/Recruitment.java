package com.jianZhi.ssh.entities;

import java.util.Date;

public class Recruitment {
	
	private Integer recruitment_id;
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

	public Recruitment() {
		
	}
	
	public Recruitment(Recruitment r) {
		this.recruitment_id = r.getRecruitment_id();
		this.title = r.getTitle();
		this.city = new City(r.getCity());
		this.district = r.getDistrict();
		this.address = r.getAddress();
		this.salary = r.getSalary();
		this.phone = r.getPhone();
		this.beginYear = r.getBeginYear();
		this.beginMonth = r.getBeginMonth();
		this.beginDay = r.getBeginDay();
		this.endYear = r.getEndYear();
		this.endMonth = r.getBeginMonth();
		this.endDay = r.getBeginDay();
		this.correspond = new Correspond(r.getCorrespond());
		this.workKind = new WorkKind(r.getWorkKind());
		this.date = r.getDate();
		this.recruiter = new Recruiter(r.getRecruiter());
		this.context = r.getContext();
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

	public Integer getRecruitment_id() {
		return recruitment_id;
	}

	public void setRecruitment_id(Integer recruitment_id) {
		this.recruitment_id = recruitment_id;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public City getCity() {
		return city;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public Recruiter getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}

	@Override
	public String toString() {
		return recruitment_id + "," + " Recruitment [title=" + title + ", city=" + city + ", district=" + district + ", address=" + address
				+ ", salary=" + salary + ", phone=" + phone + ", beginYear=" + beginYear + ", beginMonth=" + beginMonth
				+ ", beginDay=" + beginDay + ", endYear=" + endYear + ", endMonth=" + endMonth + ", endDay=" + endDay
				+ ", correspond=" + correspond + ", workKind=" + workKind + ", date=" + date + ", recruiter="
				+ recruiter + ", context=" + context + "]" + "\r\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((beginDay == null) ? 0 : beginDay.hashCode());
		result = prime * result + ((beginMonth == null) ? 0 : beginMonth.hashCode());
		result = prime * result + ((beginYear == null) ? 0 : beginYear.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result + ((correspond == null) ? 0 : correspond.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((district == null) ? 0 : district.hashCode());
		result = prime * result + ((endDay == null) ? 0 : endDay.hashCode());
		result = prime * result + ((endMonth == null) ? 0 : endMonth.hashCode());
		result = prime * result + ((endYear == null) ? 0 : endYear.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((recruiter == null) ? 0 : recruiter.hashCode());
		result = prime * result + ((recruitment_id == null) ? 0 : recruitment_id.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((workKind == null) ? 0 : workKind.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recruitment other = (Recruitment) obj;
		if(this.recruitment_id == other.getRecruitment_id())
			return true;
		return false;
	}

	
}
