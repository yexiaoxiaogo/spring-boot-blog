package io.github.yexiaoxiaogo.weather.domain;

import java.io.Serializable;

public class Weather implements Serializable {
	
	private int id; //数据ID
	private String citycode; //城市代码
	private String code_d;//白天天气状况代码  100
	private String code_n;//夜间天气状况代码  104
	private String txt_d;//白天天气状况描述  晴
	private String txt_n;//夜间天气状况描述  阴
	private String max;//最高气温
	private String min;//最低气温
	private String date;//预报日期
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getCode_d() {
		return code_d;
	}
	public void setCode_d(String code_d) {
		this.code_d = code_d;
	}
	public String getCode_n() {
		return code_n;
	}
	public void setCode_n(String code_n) {
		this.code_n = code_n;
	}
	public String getTxt_d() {
		return txt_d;
	}
	public void setTxt_d(String txt_d) {
		this.txt_d = txt_d;
	}
	public String getTxt_n() {
		return txt_n;
	}
	public void setTxt_n(String txt_n) {
		this.txt_n = txt_n;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
