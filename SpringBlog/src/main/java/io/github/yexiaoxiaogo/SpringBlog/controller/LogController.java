package io.github.yexiaoxiaogo.SpringBlog.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.github.yexiaoxiaogo.SpringBlog.domain.Log;
import io.github.yexiaoxiaogo.SpringBlog.service.LogRepository;

@Controller
public class LogController {

	@Autowired
	private LogRepository logRepository;
	/*
	 * TODO: 	@RequestMapping("/log" get)
	 *			@RequestMapping("/log" post)
	 */

	
	@RequestMapping("/log")
	@ResponseBody
	public String log(){
		Log log = new Log();
		
		log.setId(new Date().getTime());
		log.setDate(new Date());
		log.setLeavl(1);
		log.setMsg("test log");
//		logRepository.
		logRepository.save(log);
		return "ok";
	}
}
