package io.github.yexiaoxiaogo.SpringBlog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("io.github.yexiaoxiaogo.SpringBlog.dao")
public class App {
	public static ConfigurableApplicationContext context;
	public static void main(String[] args) {
		context =  SpringApplication.run(App.class, args);
	
	}
}
