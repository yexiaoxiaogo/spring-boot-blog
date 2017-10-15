package io.github.yexiaoxiaogo.SpringBlog.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import io.github.yexiaoxiaogo.SpringBlog.domain.Blog;

@Controller
@RequestMapping("/test")
public class TestController {
	
	// 模拟接口，所有数据返回 ok 对象
	@RequestMapping("/api")
	@ResponseBody
	public Map<String, String> api(HttpServletRequest request) {
		Map<String, String> result = new HashMap<String, String>();
		result.put("msg", "ok");
		result.put("blog", request.getParameter("blog"));
		return result;
	}
	
	@RequestMapping("/api/post")
	@ResponseBody
	public Map<String, String> apiPost(@RequestBody Map<String, String> body) {
		Map<String, String> result = new HashMap<String, String>();
		result.put("msg", "ok");
		result.put("blog", body.get("blog"));
		return result;
	}
	
	// 测试链接：http://localhost:8080/test/login
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	// 测试链接：http://localhost:8080/test/register
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	// 测试链接：http://localhost:8080/test/listed
	@RequestMapping("/listed")
	public ModelAndView listed(HttpServletRequest request) {
		
		int page = new Integer(request.getParameter("page"));
		ModelAndView modelAndView = new ModelAndView();
		List<Blog> blogList = new LinkedList<Blog>();
		
		int n = (page + 1) * 10;
		for (int i = page * 10; i < n; i++) {
			Blog blog = new Blog();
			blog.setBlogid(i);
			blog.setBlog("test" + i);
			blog.setDate(new Date());
			blog.setTitle("title" + i);
			blogList.add(blog);
		}
		
		modelAndView.addObject("page", page);
		modelAndView.addObject("pagesize", 10);
		modelAndView.addObject("pages", 5);
		modelAndView.addObject("total", 60);
		modelAndView.addObject("results", blogList);
		modelAndView.setViewName("listed");
		return modelAndView;
	}
	
	// 测试链接：http://localhost:8080/test/unlisted
	@RequestMapping("/unlisted")
	public String unlisted() {
		return "unlisted";
	}
	
	// 测试链接：http://localhost:8080/test/write
	@RequestMapping("/write")
	public String write() {
		return "write";
	}
	
	// 测试链接：http://localhost:8080/test/paper
	@RequestMapping("/paper")
	public String paper() {
		return "paper";
	}
}
