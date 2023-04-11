package com.example.springrest.practice.RestApi.Practice.student;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class StudentController {
	

	private StudentDaoService service;
	
	public StudentController(StudentDaoService service) {
		this.service=service;
		
	}
	
	@GetMapping("/hello/{name}")
	public String getHelloMessage(@PathVariable String name) {
		return "Hello " + name;
	}

	@GetMapping("/student")
	public List<Student> retrieveAllStudent() {
		return service.findAll();
	}
	
	@GetMapping("/student/{id}")
	public Student retrieveById(@PathVariable int id) {
		return service.findById(id);
	}
	
	/*@GetMapping("/student/{name}")
	public Student retrieveByName(@PathVariable String name) {
		return service.findByName(name);
	}*/
	
	@DeleteMapping("/student/{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteById(id);
	}
	
	
	@PutMapping("/student/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
		service.updateStudent(student);
		return student;
	}
	
	@PostMapping("/student")
	public Student addNewStudent(@RequestBody Student student) {
		Student stu=service.addStudent(student.getName(),student.getCourse());
		return stu;
	}
	
	
	
	
}
