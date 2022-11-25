package com.student.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student.exception.BadRequestException;
import com.student.exception.EmailExistException;
import com.student.exception.NotFoundException;
import com.student.feignclient.ExamFeignClient;
import com.student.model.Student;
import com.student.repository.StudentRepository;
@Service

public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ExamFeignClient examFeignClient;
	

	@Override
	public Student registerNewStudent(Student student) {
		
		if(student.getEmail()==null) {
			throw new BadRequestException("Email must have a value");
		}
		
		int max=0;
		List<Student> students = studentRepository.findAllStudentByStandard(student.getStandard());
		
		if(students.size()>0) {			
			for(Student iterstudent: students) {
				if(iterstudent.getEmail().toString().equalsIgnoreCase(student.getEmail().toString())) {
					throw new EmailExistException("Email already exist or Student is already admitted! Try again later or contact the management team");
				}
				if(iterstudent.getRoll()>max) {
					max=iterstudent.getRoll();
				}
			}
		}		
		student.setRoll(max+1);
		try {
			student.setId(UUID.randomUUID().toString());
			studentRepository.save(student);
			return student;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Student getStudentDetails(String id) {
		Student student = studentRepository.findById(id).orElseThrow(()->new NotFoundException("Whoops! Student not found"));
		return student;
	}

	@Override
	public List<Student> getAllStudentDetails(int standard) {
		List<Student> students = studentRepository.findAllStudentByStandard(standard);
		return students;
	}

	@Override
	public ResponseEntity<?> getAllExamByStandard(int standard) {
		return examFeignClient.showAllExams(standard);
	}

}
