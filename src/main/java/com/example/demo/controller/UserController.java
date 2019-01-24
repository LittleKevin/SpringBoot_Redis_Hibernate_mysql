package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.User;

import com.example.demo.service.User_Service;
@RestController
public class UserController {  
    @Autowired 
    User_Service ser;
    
    @RequestMapping("/addUser")
    public String addUser() {
    	User u=new User("ming","woman","20","NC");
    	ser.addUser(u);
        return "DONE!";
    }
    @RequestMapping("/findUser")
    public List<User> findUser() {
    	
        return  ser.FindAllUser();
    }
}
