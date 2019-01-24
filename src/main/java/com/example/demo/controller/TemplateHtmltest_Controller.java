package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.demo.configs.WebSecurityConfig;
import com.example.demo.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
/**
 * web拦截器
 * @author kevin
 * @date 2018-8-16
 */
@Controller
public class TemplateHtmltest_Controller {
	@Autowired
	private StudentService adservice;

	@RequestMapping("/index")
	public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String account, Model model){
		model.addAttribute("name", account);
		return "index";
	}
	@RequestMapping("/")
    public String hello(){
	    return "index";
    }
	@RequestMapping("/login")
	public String login_() {
		return "login";	
	}
	
	@RequestMapping(value="/loginPost",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> loginPost_(String account, String password, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		if(adservice.findAdmin(account, password)==null) {
			 map.put("success", false);
	         map.put("message", "用户名/密码错误");
	       return map;
		}
		 // 设置session
        session.setAttribute(WebSecurityConfig.SESSION_KEY, account);
        map.put("success", true);
        map.put("message", "登录成功");
		return map;
	     
	}
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public String logout(HttpSession session){
		session.removeAttribute(WebSecurityConfig.SESSION_KEY);
		return "login";
	}
}
