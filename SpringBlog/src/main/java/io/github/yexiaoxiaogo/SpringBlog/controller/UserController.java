package io.github.yexiaoxiaogo.SpringBlog.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import io.github.yexiaoxiaogo.SpringBlog.domain.User;
import io.github.yexiaoxiaogo.SpringBlog.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	// 点击登录按钮，跳转到登录页面,登录成功跳转到登录成功页面listed
	@RequestMapping("/login")
	public ModelAndView Login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("user:" + username + " pass:" + password);

		ModelAndView modelAndView = new ModelAndView();

		User user = userService.Login(username, password);
		// login 返回的是一个 user对象，不是bool值
		if (user != null) {
			//设置session属性
			request.getSession().setAttribute("user", user);
			
			response.sendRedirect("/listed");
//			modelAndView.addObject("user", user);
//			modelAndView.setViewName("listed");
		} else {
			System.out.println("user is null");
			modelAndView.setViewName("login");
		}

		return modelAndView;
	}
	//登出页面写到了blogcontroller里面去？不用

	//点击退出按钮，跳转到未登录页面
		@RequestMapping("/logout")
		public String loginout(HttpServletRequest request,HttpServletResponse response) throws IOException{
			//防止创建session
			HttpSession httpSession = request.getSession(false);
			//清除session返回到未登录主页面
			httpSession.removeAttribute("user");
			response.sendRedirect("/unlisted");
			return null;
		//	return "unlisted";
		}
	

	/*	注册页面
	 * 	 点击注册按钮，跳转到注册用户页面，注册后跳转到未登录主页面，进行登录
	 */
	@RequestMapping("/register")
	public String register(){
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> registerapi(@RequestBody User user) {

		// 创建User对象，表单获取user对象的user和password
//		User user1 = new User();
//		user1.setUsername(request.getParameter("username"));
//		user1.setPassword(request.getParameter("password"));
		System.out.println(user.getUsername());
		// 插入数据库
		userService.Register(user);
		
		Map<String, String> result = new HashMap<String, String>();
		
		result.put("username",user.getUsername());
		result.put("password",user.getPassword());
		
		return result;

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
