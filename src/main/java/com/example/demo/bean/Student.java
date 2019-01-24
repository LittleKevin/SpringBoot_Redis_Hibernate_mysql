package com.example.demo.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Student")
@Getter
@Setter
public class Student implements Serializable{
@Id 
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="id")
 private int id;
@Column(name="account")
 private String account;
@Column(name="password")
 private String password;
 public Student() {
	 
 }
public Student(String account, String password) {
	super();
	this.account = account;
	this.password = password;
}


public Student(int id, String account, String password) {
	super();
	this.id = id;
	this.account = account;
	this.password = password;
}


}
