package io.github.yexiaoxiaogo.weather.domain;

import java.io.Serializable;

public class City implements Serializable {

	private String cityid;
	private String cityname;
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "cityid:" + this.cityid + " cityname:" + this.cityname;
	}

}
