package com.example.demo.controller;

import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import ExceptionHandle.StudentEx;
import jakarta.validation.Valid;

@Controller
public class LonginCon {

	@Autowired
	StudentService studentService;

	@RequestMapping("/login")
	public String login(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "login.html";
	}

	@PostMapping("/save")
	public ResponseEntity<String> login(@ModelAttribute("student") Student student) {
		String res = studentService.save(student);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@GetMapping("/get")
	//@ResponseBody
	public String get(Model model) {
		 List<Student> res = studentService.fetch();
		 model.addAttribute("student",res);
		return "show.html";
	}
	@GetMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam("id") String id) {
		 String res=null;
		try {
	     res = studentService.delete(id);
	     return res;
		}catch(Exception e) {
		 throw new StudentEx("Invalid Id");
		}
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam(value = "id") String id, Model model) {
		try {
		    Student student = studentService.update(id);
	        model.addAttribute("student",student);
	        return "update.html";
			}catch(Exception e) {
			 throw new StudentEx("Invalid Id");
			}
    }
}
