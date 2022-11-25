package com.teacher.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teacher.model.Exam;
import com.teacher.model.Teacher;

public interface ExamRepository extends JpaRepository<Exam, String> {

	List<Exam> findByTeacher(Teacher teacherFound);

	List<Exam> findAllByStandard(int standard);

}
