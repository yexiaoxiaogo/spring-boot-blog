package io.github.yexiaoxiaogo.SpringBlog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import io.github.yexiaoxiaogo.SpringBlog.domain.Blog;
import io.github.yexiaoxiaogo.SpringBlog.domain.UserBlog;

public interface UserBlogDao {

	// 根据用户id查询用户所有blog有几条
	public int count(int userid);
	
	//根据关键字查询有几条blog
	public int searchcount(@Param("keyword")String keyword);

	// 登录主页显示blog列表,显示标题，时间，点击标题跳转链接
	List<UserBlog> selectALLByUserid(int userid);

	// 未登录主页显示最新10条博客
	List<Blog> findnewblog(int blogid);

	// 分页
	List<UserBlog> pagedquery(@Param("userid")int userid,@Param("offset") int offset,@Param("pagesize")int pagesize);
	
	//搜索博文
	List<UserBlog> search(@Param("keyword")String keyword,@Param("offset") int offset,@Param("pagesize")int pagesize);

}
