package io.github.yexiaoxiaogo.SpringBlog.service;

import io.github.yexiaoxiaogo.SpringBlog.domain.User;

public interface UserService {
	//业务层接口通过用户名user和用户密码password实现用户登录
		public User Login(String username,String password);
		//注册
		public Long Register(User user);
		////注册是否重复
		public User findNameByName(String username);

}
