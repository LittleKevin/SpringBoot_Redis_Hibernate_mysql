package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Student;
import com.example.demo.service.StudentService;

@RestController
public class RedisTestController {
	@Autowired
	private StudentService service;
    
    @RequestMapping("/getAdminList")
    public List<Student> getAdminList(){
    	return  service.getAllAdmin();
    }
  

  
}
