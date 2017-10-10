package io.github.yexiaoxiaogo.SpringBlog.service;

import io.github.yexiaoxiaogo.SpringBlog.domain.Blog;

public interface BlogService {
	//显示一篇博客
	public Blog displayBlog(int blogid);
	//发布博客
	public Long ReleaseBlog(Blog blog);
	

}
