package io.github.yexiaoxiaogo.SpringBlog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import io.github.yexiaoxiaogo.SpringBlog.domain.Blog;

public interface BlogDao {
	//根据id查询一篇blog，显示在博客页面
	Blog findBlogByID(@Param("blogid")int blogid);
	//发布文章，插入blog，发布博客页面
	Long insertBlog(Blog blog);
	//未登录主页显示最新10条博客
	List<Blog> findnewblog( int blogid);

}
