package io.github.yexiaoxiaogo.SpringBlog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("io.github.yexiaoxiaogo.SpringBlog.dao")
public class App {
	public static ClassPathXmlApplicationContext context;
	public static void main(String[] args) {
		context = (ClassPathXmlApplicationContext) SpringApplication.run(App.class, args);
			
	}
}
