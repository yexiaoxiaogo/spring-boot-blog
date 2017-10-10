package io.github.yexiaoxiaogo.SpringBlog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.yexiaoxiaogo.SpringBlog.dao.UserBlogDao;
import io.github.yexiaoxiaogo.SpringBlog.domain.UserBlog;

@Service
public class UserBlogSerciecImpl {
	
	@Autowired
	private UserBlogDao userBlogDao;
	//主页显示博客列表
	public List<UserBlog> findBlogListByUser(int userid){
		
		return userBlogDao.selectALLByUserid(userid);
	}

}
