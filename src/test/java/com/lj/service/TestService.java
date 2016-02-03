package com.lj.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class TestService {

	@Autowired
	LoginService loginService;
	
	private void login(){
		try {
			boolean boo = loginService.lonin("LiangJian", "123456");
			System.out.println(boo);
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
