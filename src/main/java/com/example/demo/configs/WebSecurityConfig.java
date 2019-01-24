package com.example.demo.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
/**
 * web拦截器配置
 * @author kevin
 * @date 2018-8-16
 */
public class WebSecurityConfig implements WebMvcConfigurer {

    /**
     * 登录session key
     */
    public final static String SESSION_KEY = "user";
  
   
   @Override
    public void addInterceptors(InterceptorRegistry registry) {

       System.out.println("JAVA 设置静态资源不拦截 ---配置!!!");
       InterceptorRegistration addInterceptor=registry.addInterceptor(new MyInterceptor());
       addInterceptor.addPathPatterns("/**");
       addInterceptor.excludePathPatterns(Arrays.asList("/static/**","/login**"));
       addInterceptor.excludePathPatterns(Arrays.asList("/css/**","/js/**"));
       addInterceptor.excludePathPatterns(Arrays.asList("/img/**","/fonts/**"));
   }
}
