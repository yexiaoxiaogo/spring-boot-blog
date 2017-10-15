package io.github.yexiaoxiaogo.SpringBlog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.yexiaoxiaogo.SpringBlog.dao.UserBlogDao;
import io.github.yexiaoxiaogo.SpringBlog.domain.Blog;
import io.github.yexiaoxiaogo.SpringBlog.domain.UserBlog;
import io.github.yexiaoxiaogo.SpringBlog.service.UserBlogService;

@Service
public class UserBlogSerciecImpl implements UserBlogService {
	
	@Autowired
	private UserBlogDao userBlogDao;
	//denglu主页显示博客列表
	public List<UserBlog> findBlogListByUser(int userid){
		
		return userBlogDao.selectALLByUserid(userid);
	}
	
	//未登录主页面显示最新10条博客
		public List<Blog> findnewblog(int blogid){
			
			return userBlogDao.findnewblog(blogid);
		}
	//
	public int count(int userid){
		
		return userBlogDao.count(userid);
	}

	//已登录主页面分页
	public List<UserBlog> pagedquery(int userid,int offset,int pagesize){
		
		return userBlogDao.pagedquery(userid, offset,pagesize);
	}
	//搜索
	public List<UserBlog> search(String keyword) {
		
		return userBlogDao.search(keyword);
	}
}
