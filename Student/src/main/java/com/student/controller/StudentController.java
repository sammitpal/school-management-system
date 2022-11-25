package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/admission")
	public ResponseEntity<?> admission(@RequestBody Student student){
		Student registeredStudent = studentService.registerNewStudent(student);
		return new ResponseEntity<>(registeredStudent, HttpStatus.OK);
	}
	
	@GetMapping("/profile/{id}")
	public ResponseEntity<?> getProfile(@PathVariable String id){
		Student student = studentService.getStudentDetails(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@GetMapping("/all/{standard}")
	public ResponseEntity<?> getProfile(@PathVariable int standard){
		List<Student> students = studentService.getAllStudentDetails(standard);
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
	
	@GetMapping("/exam/{standard}")
	public ResponseEntity<?> getAllExams(@PathVariable int standard){
		return studentService.getAllExamByStandard(standard);
	}
	
}
