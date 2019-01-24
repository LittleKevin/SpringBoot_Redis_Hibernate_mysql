package com.example.demo.configs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * web拦截器
 * @author kevin
 * @date 2018-8-16
 */
public class MyInterceptor implements HandlerInterceptor{
	 @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	            throws Exception {
	 	 System.out.println("------preHandle-------");
		 HttpSession session = request.getSession();
		 System.out.println("session:"+session.getAttribute(WebSecurityConfig.SESSION_KEY));
		 if (session.getAttribute(WebSecurityConfig.SESSION_KEY) != null)
			 return true;
		 // 跳转登录
		 String url = "login";
		 response.sendRedirect(url);
		 return false;

	    }

	    @Override
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	            ModelAndView modelAndView) throws Exception {
	        // TODO Auto-generated method stub

	    }

	    @Override
	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	            throws Exception {
	        // TODO Auto-generated method stub

	    }
}
