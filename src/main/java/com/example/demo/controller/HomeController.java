package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.reopsitory.StudentRepository;

@RestController
public class HomeController {
	@Autowired
	 private StudentRepository studentRepo;
	
	
//show student detail list
@GetMapping("/students") 
public List<Student> getAllStudents() { 
 return studentRepo.findAll(); 
} 

//Add student details
	@PostMapping("/saveStudent") 
	public Student saveData(@RequestBody Student student) {
		studentRepo.save(student);
		return student;
	}
	
	//delete student details
	@DeleteMapping("/deleteStudent/{rollno}") 
		public String deleteStudent(@PathVariable int rollno) {
		Student student =studentRepo.findById(rollno).get();
		if(student!=null) 
			studentRepo.delete(student);
			return "Deleted successfully";
		
	}
	//update student details
	@PutMapping ("/updateStudent") 
	public Student updateStudentData(@RequestBody Student student) {
		studentRepo.save(student);
		return student;
		
	}
	
	
	

}
