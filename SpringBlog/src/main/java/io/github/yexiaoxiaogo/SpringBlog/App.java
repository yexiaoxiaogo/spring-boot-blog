package io.github.yexiaoxiaogo.SpringBlog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.github.yexiaoxiaogo.weather.service.WeatherCityService;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("io.github.yexiaoxiaogo.SpringBlog.dao")
public class App {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "META-INF/spring/consumer.xml" });
		context.start();
		WeatherCityService weatherCityService = (WeatherCityService) context.getBean("weatherCityService"); // 获取远程服务代理

	}
}
