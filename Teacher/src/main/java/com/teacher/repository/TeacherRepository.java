package com.teacher.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teacher.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, String>{

}
