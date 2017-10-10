package io.github.yexiaoxiaogo.SpringBlog.service;

import java.util.List;

import io.github.yexiaoxiaogo.SpringBlog.domain.UserBlog;

public interface UserBlogService {
	//主页显示博客列表
		public List<UserBlog> findBlogListByUser(int userid);

}
