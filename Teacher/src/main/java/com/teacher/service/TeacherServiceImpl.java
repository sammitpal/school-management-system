package com.teacher.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teacher.exception.EmailExistException;
import com.teacher.model.Teacher;
import com.teacher.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	TeacherRepository teacherRepository;

	@Override
	public Teacher registerAsTeacher(Teacher teacher) {
		List<Teacher> teachers = teacherRepository.findAll();
		for(Teacher iterTeacher: teachers) {
			if(iterTeacher.getEmail().toString().equalsIgnoreCase(teacher.getEmail().toString())) {
				throw new EmailExistException("Email already exist or you already have registered as teacher! Contact management team or try again later!");
			}
		}
		teacher.setId(UUID.randomUUID().toString());
		return teacherRepository.save(teacher);
	}

}
