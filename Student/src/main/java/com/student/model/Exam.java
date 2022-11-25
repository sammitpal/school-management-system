package com.student.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.student.model.Teacher;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Exam {

	
	private String id;
	private String name;
	private String subject;
	private int standard;
	private String createddate;
	private int maxmarks;
	private boolean active;
	private boolean accepted;
	private String examdate;
	private Teacher teacher;
}
