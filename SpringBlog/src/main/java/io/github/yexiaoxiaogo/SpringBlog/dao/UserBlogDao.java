package io.github.yexiaoxiaogo.SpringBlog.dao;

import java.util.List;

import io.github.yexiaoxiaogo.SpringBlog.domain.UserBlog;

public interface UserBlogDao {
	
	//根据用户id查询用户所有blog有几条
	public int count(int userid);
	//登录主页显示blog列表,显示标题，时间，点击标题跳转链接
	List<UserBlog> selectALLByUserid(int userid);
	//分页

}
