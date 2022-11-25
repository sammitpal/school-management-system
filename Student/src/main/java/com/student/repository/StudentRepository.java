package com.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.method.P;

import com.student.model.Student;

public interface StudentRepository extends JpaRepository<Student, String>{

	@Query(name = "select * from students where id=abced")
	List<Student> findAllStudentByStandard(int standard);

	Student findStudentByEmail(String email);

}
