package com.lj.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.lj.beans.Result;

@Configuration
@ComponentScan
public class TestService {

	@Autowired
	UserService userService;
	
	private void login(){
		try {
			Result rs = userService.loginCheck("LiangJian", "123456");
			System.out.println(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test(){
		ApplicationContext context = new AnnotationConfigApplicationContext(TestService.class);
		TestService testService = context.getBean(TestService.class);
		testService.login();
	}
}
