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
@Table(name="user")
@Setter
@Getter
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="name")
    private String name;
	@Column(name="sex")
    private String sex;
	@Column(name="age")
    private String age;
	@Column(name="info")
    private String info;
    public User() {
    	
    }
    
	public User(String name, String sex, String age, String info) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.info = info;
	}

	public User(int id, String name, String sex, String age, String info) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.info = info;
	}


    
}
