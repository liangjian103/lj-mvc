package com.lj.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lj.beans.Result;
import com.lj.beans.TbUser;
import com.lj.service.UserService;
import com.lj.utils.images.ValidateCode;

/**
 * 用户管理
 * 
 * @author James Date:2015-7-17 13:45:02
 */
@Controller
@RequestMapping("/UserAction.do")
public class UserAction {

	protected static Logger logger = Logger.getLogger(UserAction.class);

	@Autowired
	private UserService userService;

	/** 用户注册 */
	@RequestMapping(params = "method=reg")
	public String reg(HttpServletRequest request,Model model,TbUser tbUser,String yanzhengma) throws Exception {
		try {
			String code = yanzhengma == null ? "" : yanzhengma;
			String sCode = request.getSession().getAttribute("authCode") + "";
			code = code.toUpperCase();
			request.getSession().removeAttribute("authCode");//安全起见，清除验证码Session,以免验证码被绕过,避免重复表单提交
			
			if(!code.equals(sCode)){
				request.setAttribute("msg", "验证码错误");
				return "userreg";
			}
			
			if(tbUser==null||isNull(tbUser.getUsername())||isNull(tbUser.getPasswd())||isNull(tbUser.getEmail())){
				request.setAttribute("msg", "请将信息填写完整");
				return "userreg";
			}
			
			Result rs = userService.regUser(tbUser);
			request.setAttribute("msg", rs.getMsg());
			if (rs.getState() == 0) {
				return "login";
			} else {
				return "userreg";
			}
			
		} catch (Exception e) {
			request.setAttribute("msg", "注册失败");
			return "userreg";
		}
	}

	/** 用户登录 */
	@RequestMapping(params = "method=login")
	public String login(HttpServletRequest request,TbUser tbUser,String yanzhengma) throws Exception {
		try {
			String code = yanzhengma == null ? "" : yanzhengma;
			String sCode = request.getSession().getAttribute("authCode") + "";
			code = code.toUpperCase();
			
			if(!code.equals(sCode)){
				request.setAttribute("msg", "验证码错误");
				return "login";
			}
			request.getSession().removeAttribute("authCode");//安全起见，清除验证码Session,以免验证码被绕过
			
			Result rs = userService.loginCheck(tbUser.getUsername(), tbUser.getPasswd());
			request.setAttribute("msg", rs.getMsg());
			if (rs.getState() == 0) {
				request.getSession().setAttribute("userInfo", (TbUser) rs.getObj());
				return "index";
			} else {
				return "login";
			}
		} catch (Exception e) {
			request.setAttribute("msg", "登录失败");
			return "login";
		}
	}

	@RequestMapping(params = "method=authCode")
	public void authCode(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.getSession().removeAttribute("authCode");
		// 设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		//禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		HttpSession session = request.getSession();
		ValidateCode vCode = new ValidateCode(180,30,5,80);
		session.setAttribute("authCode", vCode.getCode());
		vCode.write(response.getOutputStream());
	}
	
	private boolean isNull(String str){
		if(null==str||"".equals(str.trim())||str.length()<1){
			return true;
		}else{
			return false;
		}
	}
}
