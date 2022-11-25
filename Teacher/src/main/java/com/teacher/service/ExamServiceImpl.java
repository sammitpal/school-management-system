package com.teacher.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teacher.exception.NotFoundException;
import com.teacher.model.Exam;
import com.teacher.model.Teacher;
import com.teacher.repository.ExamRepository;
import com.teacher.repository.TeacherRepository;

@Service
public class ExamServiceImpl implements ExamService{

	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	ExamRepository examRepository;
	
	@Override
	public Exam createExam(Exam exam, String teacherid) {
		Teacher teacherFound = teacherRepository.findById(teacherid).orElseThrow(()-> new NotFoundException("Teacher not found with id: "+teacherid));
		if(teacherFound==null) {
			throw new NotFoundException("Teacher not found");
		}
		exam.setId(UUID.randomUUID().toString());
		exam.setCreateddate(new Date().toLocaleString());
		exam.setTeacher(teacherFound);
		return examRepository.save(exam);
	}

	@Override
	public List<Exam> showExams(String teacherid) {
		Teacher teacherFound = teacherRepository.findById(teacherid).orElseThrow(()-> new NotFoundException("Teacher not found with id: "+teacherid));
		return examRepository.findByTeacher(teacherFound);
	}

	@Override
	public List<Exam> showAllExams(int standard) {
		return examRepository.findAllByStandard(standard);
	}

	
	
}
