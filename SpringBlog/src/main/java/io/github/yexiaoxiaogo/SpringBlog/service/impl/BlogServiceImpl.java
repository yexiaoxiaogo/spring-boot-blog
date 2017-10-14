package io.github.yexiaoxiaogo.SpringBlog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.yexiaoxiaogo.SpringBlog.dao.BlogDao;
import io.github.yexiaoxiaogo.SpringBlog.domain.Blog;
import io.github.yexiaoxiaogo.SpringBlog.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogDao blogDao;
	
	//显示一篇博客,点击列表标题，打开一个新的链接，显示一篇博客
	public Blog displayBlog(int blogid){
		
		return blogDao.findBlogByID(blogid);
	}
	//发布博客
	public Long ReleaseBlog(Blog blog){
		
		return blogDao.insertBlog(blog);
	}
	

}
