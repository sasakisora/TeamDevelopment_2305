package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class LoginUserEntity {
	
	@Id
	@Column(name = "id")
	private  Integer id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;

}
