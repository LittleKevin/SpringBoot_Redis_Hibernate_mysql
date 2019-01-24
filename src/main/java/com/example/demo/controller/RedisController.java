package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RedisService;

@RestController
public class RedisController {
	@Autowired
 private RedisService ser;
	@RequestMapping("/setString")
	public String setString(String key,String value) {
		try {
			ser.setString(key, value);
		}catch(Exception e) {
			System.out.println("Redis存储值异常!");
		}
		return "DONE!";
	}
	@RequestMapping("/getString")
	public String getString(String key) {
		return ser.getString(key);
	}
}
