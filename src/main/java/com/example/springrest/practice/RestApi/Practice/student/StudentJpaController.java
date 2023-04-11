package com.example.springrest.practice.RestApi.Practice.student;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springrest.practice.RestApi.Practice.repository.StudentRepository;

@RestController
public class StudentJpaController {
	

	private StudentDaoService service;
	
	private StudentRepository repository;
	
	
	public StudentJpaController(StudentDaoService service, StudentRepository repository) {
		this.service=service;
		this.repository=repository;
	}
	
	@GetMapping("/hello/{name}")
	public String getHelloMessage(@PathVariable String name) {
		return "Hello " + name;
	}

	@GetMapping("/student")
	public List<Student> retrieveAllStudent() {
		return repository.findAll();
	}
	
	@GetMapping("/student/{id}")
	public Student retrieveById(@PathVariable int id) {
		return repository.findById(id).get();
	}
	
	/*@GetMapping("/student/{name}")
	public Student retrieveByName(@PathVariable String name) {
		return service.findByName(name);
	}*/
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@PutMapping("/student/{id}")
	public void updateStudent(@RequestBody Student student, @PathVariable int id) {
		repository.save(student);
	}
	
	@PostMapping("/student")
	public void addNewStudent(@RequestBody Student student) {
		repository.save(student);
	}
	
	
	
	
}
