package io.github.yexiaoxiaogo.SpringBlog.service.impl;

import java.net.ConnectException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import io.github.yexiaoxiaogo.SpringBlog.dao.BlogDao;
import io.github.yexiaoxiaogo.SpringBlog.domain.Blog;
import io.github.yexiaoxiaogo.SpringBlog.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	//显示一篇博客,点击列表标题，打开一个新的链接，显示一篇博客,redis实现博客缓存
	public Blog displayBlog(int blogid){
		
		//TODO: 判断redis是否连接
		
		//从缓存中读取博客信息
		String key = String.valueOf(blogid);
		ValueOperations<String, Blog> operations = redisTemplate.opsForValue();
			
		//缓存存在则返回缓存中的内容
		boolean hasKey = redisTemplate.hasKey(key);
		
		if(hasKey){
			Blog blog = operations.get(key);
			operations.set(key, blog, 5, TimeUnit.SECONDS);
			System.out.println("是缓存中读取的");
			return blog;
		}
		//不存在缓存则在数据库中获取数据，然后插入缓存中
		Blog blog = blogDao.findBlogByID(blogid);
		System.out.println("是数据库中读取的");
		//operations.set(key, blog);
		operations.set(key, blog, 5, TimeUnit.SECONDS);
		
		return blog;
	}
	//发布博客
	public Long ReleaseBlog(Blog blog){
		
		return blogDao.insertBlog(blog);
	}
	

}
