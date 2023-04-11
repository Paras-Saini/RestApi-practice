package com.example.springrest.practice.RestApi.Practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springrest.practice.RestApi.Practice.student.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	List<Student> findByName(String name);

}
