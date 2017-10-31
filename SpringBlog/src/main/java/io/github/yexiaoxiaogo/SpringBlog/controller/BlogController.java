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
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import io.github.yexiaoxiaogo.SpringBlog.domain.Blog;
import io.github.yexiaoxiaogo.SpringBlog.domain.User;
import io.github.yexiaoxiaogo.SpringBlog.domain.UserBlog;
import io.github.yexiaoxiaogo.SpringBlog.service.BlogService;
import io.github.yexiaoxiaogo.SpringBlog.service.UserBlogService;
import io.github.yexiaoxiaogo.weather.domain.WeatherCity;
import io.github.yexiaoxiaogo.weather.service.WeatherCityService;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	@Autowired
	private UserBlogService userblogService;
	@Autowired
	private WeatherCityService weatherCityService;

	// // 写博客，发布成功跳转到用户登录后主页面listed,要用post方法写博文发布
	// @RequestMapping("/write")
	// public ModelAndView writeBlog(HttpServletRequest request) {
	//
	// // 得到session信息
	// HttpSession httpSession = request.getSession();
	// User user = (User) httpSession.getAttribute("user");
	//
	// // 创建blog对象
	// Blog blog = new Blog();
	// blog.setUserid(user.getUserid());
	// blog.setTitle(request.getParameter("title"));
	// blog.setBlog(request.getParameter("blog"));
	// blog.setDate(new Date());
	// // 插入数据库
	// blogService.ReleaseBlog(blog);
	//
	// ModelAndView modelAndView = new ModelAndView();
	//
	// if (blog != null) {
	// modelAndView.addObject("blog", blog);
	// modelAndView.setViewName("listed");
	// }
	// return modelAndView;
	// }

	// 未登录页面
	@RequestMapping("/unlisted")
	public ModelAndView unlistedPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView modelAndView = new ModelAndView();

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

		int count = userblogService.countAll();

		List<Blog> blogs = userblogService.allBlogPaged(offset, pagesize);
		modelAndView.addObject("page", page + 1);
		modelAndView.addObject("pagesize", pagesize);
		modelAndView.addObject("pages", Math.ceil(count / pagesize) + 1);
		modelAndView.addObject("total", count);
		modelAndView.addObject("results", blogs);
		modelAndView.setViewName("unlisted");
		return modelAndView;
	}

	// 返回的JSON信息的接口
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

	// 登录后，我的文章页面，listed
	@RequestMapping("/listed")
	public ModelAndView listedPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 得到session信息
		HttpSession httpSession = request.getSession();

		ModelAndView modelAndView = new ModelAndView();
		// 得到session信息中的登录用户的userid，如果session失效，或者没有session信心，返回登录页面，进行登录
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
		modelAndView.addObject("user", user);
		modelAndView.setViewName("listed");
		return modelAndView;
	}

	// 关键字搜索博客，返回list
	/*
	 * 因为list只显示title和date,所以关键字只在title里面查询，没有显示摘要暂时blog里面的关键字
	 */
	@RequestMapping("/search")
	public ModelAndView search(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();

		String keyword = null;
		int page = 0;
		int pagesize = 10;

		if (request.getParameter("keyword") != null) {
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
		int pages = (int) Math.ceil(searchcount / pagesize);

		modelAndView.addObject("keyword", keyword);
		modelAndView.addObject("total", searchcount);
		modelAndView.addObject("pages", pages);
		modelAndView.addObject("page", page + 1);
		modelAndView.addObject("pagesize", pagesize);
		modelAndView.addObject("results", userblogService.search(keyword, offset, pagesize));
		modelAndView.setViewName("search");

		return modelAndView;

	}

	// 点击列表链接，根据blogid查询，跳转到显示博客详情paper页面
	@RequestMapping("/paper/{id}")
	public ModelAndView paper(@PathVariable String id) {

		ModelAndView modelAndView = new ModelAndView();

		int blogid = Integer.parseInt(id);
		// int blogid =Integer.valueOf(id);

		Blog blog = blogService.displayBlog(blogid);
		String username = userblogService.findNameByBlogid(blogid);

		modelAndView.addObject("title", blog.getTitle());
		modelAndView.addObject("blog", blog.getBlog());
		modelAndView.addObject("username", username);
		modelAndView.addObject("date", blog.getDate());
		modelAndView.setViewName("paper");

		return modelAndView;
	}

	// 写博客
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> write(HttpServletRequest request, HttpServletResponse response, @RequestBody Blog blog)
			throws IOException {
		// 得到session信息
		HttpSession httpSession = request.getSession();

		// 得到session信息中的登录用户的userid，如果session失效，返回登录页面，程序进行登录
		User user = (User) httpSession.getAttribute("user");
		if (user == null) {
			response.sendRedirect("/login");
			return null;
		}

		Map<String, String> result = new HashMap<String, String>();
		int userid = user.getUserid();
		blog.setUserid(userid);
		blog.setDate(new Date());
		blogService.ReleaseBlog(blog);

		result.put("msg", "ok");
		return result;
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 得到session信息
		HttpSession httpSession = request.getSession();

		// 得到session信息中的登录用户的userid，如果session失效，或者没有session信心，返回登录页面，进行登录
		User user = (User) httpSession.getAttribute("user");
		if (user == null) {
			response.sendRedirect("/login");
			return null;
		}

		return "write";
	}

	// weather
	@RequestMapping("/weather/history")
	public String test(ModelMap map) {
		
		List<WeatherCity> citys = weatherCityService.selectAll();
		map.addAttribute("weatherlist", citys);
		return "weather";
	}

}
