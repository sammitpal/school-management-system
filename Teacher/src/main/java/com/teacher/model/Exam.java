package com.teacher.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="exams")
public class Exam {

	@Id
	private String id;
	private String name;
	private String subject;
	private int standard;
	private String createddate;
	private int maxmarks;
	private boolean active;
	private String examdate;
	@OneToOne(cascade = CascadeType.ALL)
	private Teacher teacher;
}
