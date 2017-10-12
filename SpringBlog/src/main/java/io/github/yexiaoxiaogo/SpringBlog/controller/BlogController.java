package io.github.yexiaoxiaogo.SpringBlog.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import io.github.yexiaoxiaogo.SpringBlog.domain.Blog;
import io.github.yexiaoxiaogo.SpringBlog.domain.User;
import io.github.yexiaoxiaogo.SpringBlog.service.BlogList;
import io.github.yexiaoxiaogo.SpringBlog.service.BlogService;

@Controller
public class BlogController {

	@Autowired
	private BlogList blogList;
	
	@Autowired
	private BlogService blogService;
	
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

	@RequestMapping(value = "/params", method = RequestMethod.GET)
	public Page<Blog> getEntryByParams(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size) {
		Sort sort = new Sort(Direction.DESC, "blogid");
		Pageable pageable = new PageRequest(page, size, sort);
		return blogList.findAll(pageable);
	}
	
	  @RequestMapping(value = "", method=RequestMethod.GET)
	    public Page<Blog> getEntryByPageable(@PageableDefault(value = 15, sort = { "blogid" }, direction = Sort.Direction.DESC) 
	        Pageable pageable) {
	        return blogList.findAll(pageable);
	    }
}
