package io.github.yexiaoxiaogo.SpringBlog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import io.github.yexiaoxiaogo.SpringBlog.domain.User;
import io.github.yexiaoxiaogo.SpringBlog.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	// 显示未登录主页
	@RequestMapping("/unlisted")
	public String index(Model model) {
		return "unlisted";
	}

	// 点击登录按钮，跳转到登录页面,登录成功跳转到登录成功页面listed
	@RequestMapping("/login")
	public ModelAndView Login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("user:" + username + " pass:" + password);

		ModelAndView modelAndView = new ModelAndView();

		User user = userService.Login(username, password);
		// login 返回的是一个 user对象，不是bool值
		if (user != null) {
			modelAndView.addObject("user", user);
			modelAndView.setViewName("listed");
		} else {
			System.out.println("user is null");
			modelAndView.setViewName("error");
		}

		return modelAndView;
	}

	// 点击注册按钮，跳转到注册用户页面，注册后跳转到未登录主页面，进行登录
	@RequestMapping("/register")
	public ModelAndView register(HttpServletRequest request) {

		// 创建User对象，表单获取user对象的user和password
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));

		ModelAndView modelAndView = new ModelAndView();

		// 插入数据库
		userService.Register(user);

		// 返回前端模板数据
		if (user != null) {
			modelAndView.addObject("user", user);
			modelAndView.setViewName("unlisted");
		}

		return modelAndView;

	}
	//

	@RequestMapping("/username")
	@ResponseBody
	public Map<String, Object> checkUser(@RequestParam(value = "username") String username) {
		Map<String, Object> result = new HashMap<String, Object>();
		if (userService.findNameByName(username) != null) {
			result.put("result", "用户已存在");
			result.put("code", 1);
		} else {
			result.put("result", "用户不存在");
			result.put("code", 0);
		}
		return result;
	}

}
