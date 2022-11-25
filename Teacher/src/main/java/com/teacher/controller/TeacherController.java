package com.teacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teacher.model.Teacher;
import com.teacher.service.TeacherService;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

	@Autowired
	TeacherService teacherService;

	@PostMapping("/create")
	public ResponseEntity<?> createTeacher(@RequestBody Teacher teacher) {

		return new ResponseEntity(teacherService.registerAsTeacher(teacher), HttpStatus.OK);
	}

}
