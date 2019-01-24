package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
 @RequestMapping("/helloworld")
 public String hello() {
	return "Today is another day of hope";
	 
 }
 
}
