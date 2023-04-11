package com.example.springrest.practice.RestApi.Practice.student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;


@Component
public class StudentDaoService {
	
	static List<Student> student=new ArrayList<>();
	
	public static int id=0;
	
	static {
		student.add(new Student(id++,"Ramesh","Learn RESTful Web Services"));
		student.add(new Student(id++,"Rohit","Learn Full Stack Web Development"));
		student.add(new Student(id++,"Rahul","Learn DevOps Engineer"));	
	}
	
	
	public List<Student> findAll() {
		return student;
	}
	
	public Student addStudent(String name, String course) {
		Student stu=new Student(id++,name,course);
		student.add(stu);
		return stu;
	}
	
	public Student findById(Integer id) {
		Predicate<? super Student> predicate=student->student.getId()==id;
		return student.stream().filter(predicate).findFirst().get();
	}
	
	public Student findByName(String name) {
		Predicate<? super Student> predicate=student->student.getName().equals(name);
		return student.stream().filter(predicate).findFirst().get();
	}
	
	public void deleteById(int id) {
		Predicate<? super Student> predicate=student->student.getId()==id;
		student.removeIf(predicate);
	}
	
	public void updateStudent(Student stu) {
		deleteById(stu.getId());
		student.add(stu);
		
	}
}
