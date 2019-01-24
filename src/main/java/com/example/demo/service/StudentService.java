package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Student;
import com.example.demo.dao.StudentDao;

@Service
public class StudentService {
  @Autowired
  private StudentDao dao;
  
  @Cacheable(value="AdminList")
  public List<Student> getAllAdmin(){
	  System.out.println("正从数据库中查询数据!");
	  return dao.findAll();
  }
  
  @Transactional
  public  Student findAdmin(String name,String password){
	return dao.findLogin(name, password);
	   
  }
}
