package io.github.yexiaoxiaogo.SpringBlog.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import io.github.yexiaoxiaogo.SpringBlog.domain.Blog;
import io.github.yexiaoxiaogo.SpringBlog.domain.User;
import io.github.yexiaoxiaogo.SpringBlog.domain.UserBlog;
import io.github.yexiaoxiaogo.SpringBlog.service.BlogService;
import io.github.yexiaoxiaogo.SpringBlog.service.UserBlogService;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	@Autowired
	private UserBlogService userblogService;

	// 写博客，发布成功跳转到用户登录后主页面listed
	@RequestMapping("/write")
	public ModelAndView writeBlog(HttpServletRequest request) {

		// 得到session信息
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");

		// 创建blog对象
		Blog blog = new Blog();
		blog.setUserid(user.getUserid());
		blog.setTitle(request.getParameter("title"));
		blog.setBlog(request.getParameter("blog"));
		blog.setDate(new Date());
		// 插入数据库
		blogService.ReleaseBlog(blog);

		ModelAndView modelAndView = new ModelAndView();

		if (blog != null) {
			modelAndView.addObject("blog", blog);
			modelAndView.setViewName("listed");
		}
		return modelAndView;
	}

	@RequestMapping("/api/listed")
	@ResponseBody
	public Map<String, Object> paged(HttpServletRequest request) {
		// 得到session信息
		HttpSession httpSession = request.getSession();
		// 得到session信息中，登录账户的userid
		User user = (User) httpSession.getAttribute("user");
		int userid = user.getUserid();

		int page = 0;
		int pagesize = 10;

		if (request.getParameter("page") != null) {
			page = new Integer(request.getParameter("page")) - 1;
		}

		if (request.getParameter("pagesize") != null) {

			pagesize = new Integer(request.getParameter("pagesize"));
		}

		int offset = page * pagesize;

		Map<String, Object> result = new HashMap<String, Object>();

		int count = userblogService.count(userid);

		result.put("page", page + 1);
		result.put("pagesize", pagesize);
		result.put("total", count);
		result.put("results", userblogService.pagedquery(userid, offset, pagesize));
		result.put("user", user);

		return result;
	}

	@RequestMapping("/listed")
	public ModelAndView listedPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 得到session信息
		HttpSession httpSession = request.getSession();

		ModelAndView modelAndView = new ModelAndView();
		// 得到session信息中的登录用户的userid，如果session失效，返回登录页面，程序进行登录
		User user = (User) httpSession.getAttribute("user");
		if (user == null) {
			response.sendRedirect("/login");
			return null;
		}

		int userid = user.getUserid();
		// 设置页数和每页显示条数的默认值
		int page = 0;
		int pagesize = 10;

		if (request.getParameter("page") != null) {
			page = new Integer(request.getParameter("page")) - 1;
		}

		if (request.getParameter("pagesize") != null) {

			pagesize = new Integer(request.getParameter("pagesize"));
		}

		int offset = page * pagesize;

		int count = userblogService.count(userid);

		List<UserBlog> userBlogs = userblogService.pagedquery(userid, offset, pagesize);
		modelAndView.addObject("page", page + 1);
		modelAndView.addObject("pagesize", pagesize);
		modelAndView.addObject("pages", Math.ceil(count / pagesize) + 1);
		modelAndView.addObject("total", count);
		modelAndView.addObject("results", userBlogs);
		modelAndView.setViewName("listed");
		return modelAndView;
	}

	// 关键字搜索博客，返回list
	/*
	 * 因为list只显示title和date,所以关键字只在title里面查询，没有显示摘要暂时blog里面的关键字
	 */
	@RequestMapping("/search")
	@ResponseBody
	public Map<String, Object> search(HttpServletRequest request) {

		Map<String, Object> result = new HashMap<String, Object>();

		String keyword = null;
		int page = 0;
		int pagesize = 10;

		if(request.getParameter("keyword") != null){
			keyword = new String(request.getParameter("keyword"));
		}
		
		if (request.getParameter("page") != null) {
			page = new Integer(request.getParameter("page")) - 1;
		}

		if (request.getParameter("pagesize") != null) {

			pagesize = new Integer(request.getParameter("pagesize"));
		}

		int offset = page * pagesize;
		int searchcount = userblogService.searchcount(keyword);
		
		result.put("total", searchcount);
		result.put("page", page+1);
		result.put("pagesize", pagesize);
		result.put("results", userblogService.search(keyword,offset,pagesize));

		return result;

	}

}
