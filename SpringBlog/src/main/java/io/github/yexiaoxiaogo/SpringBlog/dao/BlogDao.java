package io.github.yexiaoxiaogo.SpringBlog.dao;

import org.apache.ibatis.annotations.Param;

import io.github.yexiaoxiaogo.SpringBlog.domain.Blog;

public interface BlogDao {
	//根据id查询一篇blog，显示在博客页面
	Blog findBlogByID(@Param("blogid")int blogid);
	//发布文章，插入blog，发布博客页面
	Long insertBlog(Blog blog);


}
