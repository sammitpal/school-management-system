package com.teacher.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teacher.model.Exam;

@Service
public interface ExamService {

	public Exam createExam(Exam exam, String teacherid);
	public List<Exam> showExams(String teacherid);
	public List<Exam> showAllExams(int standard);
}
