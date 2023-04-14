package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;

import repo.StudentRepo;

@Service
public class StudentService {


	@Autowired
	StudentRepo sturepo;
	
	public String save(Student student) {
		 sturepo.save(student);
		return "Save Data Sucessfully";
	}
	public List<Student> fetch() {
		 List<Student> stu = sturepo.findAll();
		return stu;
	}
	public String delete(String id) {
		sturepo.deleteById(Integer.valueOf(id));
		return "deleted";
	}
	
	public Student update(String id) {
		Optional<Student> student = sturepo.findById(Integer.parseInt(id));
		return student.get();
	}
}
