package com.teacher.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="teachers")
@Getter
@Setter
public class Teacher {

	@Id
	private String id;
	private String name;
	private String email;
	private String phno;
}
