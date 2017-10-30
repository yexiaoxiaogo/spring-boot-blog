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
	public static void main(String[] args) {
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//				new String[] { "META-INF/spring/consumer.xml" });
//		context.start();
//		 WeatherService weatherService = (WeatherService) context.getBean("weatherService"); // 获取远程服务代理

		SpringApplication.run(App.class, args);
	}
}
