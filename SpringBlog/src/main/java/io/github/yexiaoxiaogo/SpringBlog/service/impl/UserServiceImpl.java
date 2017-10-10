package io.github.yexiaoxiaogo.SpringBlog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.yexiaoxiaogo.SpringBlog.dao.UserDao;
import io.github.yexiaoxiaogo.SpringBlog.domain.User;
import io.github.yexiaoxiaogo.SpringBlog.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
private UserDao userDao;
	
	//实现登录
	public User Login(String username,String password){
		User user = userDao.checkUser(username,password);
		if(user != null && user.getPassword().equals(password)){
			return user;
		}
		return null;
	}
	//实现注册
	public Long Register(User user){
		return userDao.insertUser(user);
	}

	//注册是否重复
	public User findNameByName(String username){
		return userDao.findNameByName(username);
	}

}
