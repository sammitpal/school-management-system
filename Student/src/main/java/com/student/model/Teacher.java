package com.student.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Teacher {

	private String id;
	private String name;
	private String email;
	private String phno;
}
