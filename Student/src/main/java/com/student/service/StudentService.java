package com.student.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student.model.Exam;
import com.student.model.Student;
@Service
public interface StudentService {

	public Student registerNewStudent(Student student);
	public Student getStudentDetails(String id);
	public List<Student> getAllStudentDetails(int standard);
	public ResponseEntity<?> getAllExamByStandard(int standard);
}
