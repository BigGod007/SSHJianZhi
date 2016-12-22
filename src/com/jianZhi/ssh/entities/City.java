package com.jianZhi.ssh.entities;

public class City {
	private String cityName;

	public City() {
		
	}
	
	public City(City c) {
		this.cityName = c.getCityName();
	}
	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "City [cityName=" + cityName + "]";
	}

}
