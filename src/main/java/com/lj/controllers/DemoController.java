package com.lj.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lj.service.LoginService;


@Controller
@RequestMapping("/demo.do")
public class DemoController {
	
	private static Logger logger = Logger.getLogger(DemoController.class);  
	
	@Autowired
	LoginService loginService;

	@RequestMapping(params = "method=login")
	public String login(Model model) {
		try {
			if(loginService.lonin("liangjian", "7a4bffc2c8bdd7eeff9fdcbe61e9ee5663d5780e")){
				model.addAttribute("message", "登录成功！");
				logger.info("登录成功~");
				return "index";
			}else{
				model.addAttribute("message", "用户名或密码不正确");
				return "login";
			}
		} catch (Exception e) {
			model.addAttribute("message", "系统异常！");
			logger.error("系统异常！",e);
			return "login";
		}
	}
	
	@RequestMapping(params = "method=query")
	public String query(Model model) {
		model.addAttribute("liming", "查询接口");
		System.out.println("调用了查询接口");
		try {
			boolean boo = loginService.lonin("LiangJian", "123456");
			System.out.println(boo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	@RequestMapping(params = "method=add")
	public void add(Model model) {
		model.addAttribute("liming", "添加接口");
		System.out.println("调用了添加接口");
	}
}
