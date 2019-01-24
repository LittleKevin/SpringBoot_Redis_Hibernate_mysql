package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.bean.User;
import com.example.demo.dao.UserDao;
@Service
public class User_Service {
	@Autowired
 private UserDao userdao;
	@Autowired
	private StringRedisTemplate template;
	
	
	public void addUser(User u) {
		System.out.println("正在添加数据至数据库!");
		userdao.save(u);
		System.out.println("正在添加数据至Redis!");
		template.opsForHash().put("Userkey", "UserID", String.valueOf(u.getId()));
		template.opsForHash().put("Userkey", "UserName", u.getName());
		template.opsForHash().put("Userkey", "UserAge", u.getAge());
		template.opsForHash().put("Userkey", "UserSex", u.getSex());
	}
	
	public List<User> FindAllUser(){
		System.out.println("正在从数据库中查询!");
		List<User> u=userdao.findAll();
		return userdao.findAll();
	}
}
