package io.github.yexiaoxiaogo.SpringBlog.controller;


import static org.mockito.Matchers.intThat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import io.github.yexiaoxiaogo.SpringBlog.domain.Blog;
import io.github.yexiaoxiaogo.SpringBlog.domain.User;
import io.github.yexiaoxiaogo.SpringBlog.service.BlogService;
import io.github.yexiaoxiaogo.SpringBlog.service.UserBlogService;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	@Autowired
	private UserBlogService userblogService;
	
	//写博客，发布成功跳转到用户登录后主页面listed
	@RequestMapping("/write")
	public ModelAndView writeBlog(HttpServletRequest request){
		
	//得到session信息
	    HttpSession httpSession = request.getSession();
	    User  user = (User) httpSession.getAttribute("user");
		
	    //创建blog对象
		Blog blog = new Blog();
		blog.setUserid(user.getUserid());
		blog.setTitle(request.getParameter("title"));
		blog.setBlog(request.getParameter("blog"));
		blog.setDate(new Date());
		//插入数据库
		blogService.ReleaseBlog(blog);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(blog != null){
			modelAndView.addObject("blog", blog);
			modelAndView.setViewName("listed");
		}
		return modelAndView;
	}

	@RequestMapping("/listed")
	@ResponseBody
	public Map<String , Object> paged(HttpServletRequest request){
		//得到session信息
	    HttpSession httpSession = request.getSession();
	    User  user = (User) httpSession.getAttribute("user");
	    int userid = user.getUserid();
	    int page = 0;
	    int pagesize = 10;
	
		if(request.getParameter("page") != null){
	    	  page = new Integer(request.getParameter("page"))-1;
		}
		
	    if(request.getParameter("pagesize") != null){

	    	 pagesize = new Integer(request.getParameter("pagesize"));
		}
	    
		int offset = page *pagesize;
		
		Map<String, Object>  result = new HashMap<String, Object>();
		
		int count = userblogService.count(userid);

		result.put("page", page+1);
		result.put("pagesize", pagesize);
		result.put("total", count);
		result.put("results", userblogService.pagedquery(userid, offset,pagesize));
		result.put("user", user);
		
		return result;
	//	return userblogService.pagedquery(user.getUserid(), offset);
	}


}
