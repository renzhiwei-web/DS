package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 注解表示一个主程序类，说明这是一个springboot应用
 * @author 任志伟
 * 
 */
@SpringBootApplication
public class HelloWorldMainApplication {
	public static void main(String[] args) {
		//spring应用启动起来
		SpringApplication.run(HelloWorldMainApplication.class, args);
	}
}
