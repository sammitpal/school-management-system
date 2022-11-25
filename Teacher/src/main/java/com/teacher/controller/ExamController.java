package com.teacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teacher.model.Exam;
import com.teacher.service.ExamService;

@RestController
@RequestMapping("/exam")
public class ExamController {

	@Autowired
	ExamService examService;
	
	@PostMapping("/create/{teacherid}")
	public ResponseEntity<?> createExam(@RequestBody Exam exam, @PathVariable String teacherid){
		return new ResponseEntity(examService.createExam(exam, teacherid),HttpStatus.OK);
	}
	
	@GetMapping("/showbyteacher/{teacherid}")
	public ResponseEntity<?> showExams(@PathVariable String teacherid){
		return new ResponseEntity(examService.showExams(teacherid),HttpStatus.OK);
	}
	
	@GetMapping("/showbystandard/{standard}")
	public ResponseEntity<?> showAllExams(@PathVariable int standard){
		return new ResponseEntity(examService.showAllExams(standard),HttpStatus.OK);
	}
}
