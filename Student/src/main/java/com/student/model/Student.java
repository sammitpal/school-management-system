package com.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="students")
@Getter
@Setter
public class Student {

	@Id
	private String id;
	private String name;
	private String email;
	private int roll;
	private int standard;
	private String phno;
}
