package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.bean.Student;

public interface StudentDao extends JpaRepository<Student, String>{
	@Query(value="select o from Student o where o.account=:nn and o.password=:pwd")
	public Student findLogin(@Param("nn")String name,@Param("pwd")String password);
}
