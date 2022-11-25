package com.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	private boolean active;
	private String roles;

}