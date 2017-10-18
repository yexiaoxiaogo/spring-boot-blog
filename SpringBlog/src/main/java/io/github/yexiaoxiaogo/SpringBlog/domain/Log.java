package io.github.yexiaoxiaogo.SpringBlog.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "logforJava")
public class Log {
	
	@Id
	private long id;
	private int leavl; 
	private String msg;
	private Date date;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getLeavl() {
		return leavl;
	}
	public void setLeavl(int leavl) {
		this.leavl = leavl;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
