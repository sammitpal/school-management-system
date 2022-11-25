package com.teacher.service;

import org.springframework.stereotype.Service;

import com.teacher.model.Teacher;

@Service
public interface TeacherService {
	
	public Teacher registerAsTeacher(Teacher teacher);

}
