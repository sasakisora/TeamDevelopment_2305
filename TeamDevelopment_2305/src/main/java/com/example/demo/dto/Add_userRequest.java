package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * ユーザー情報 リクエストデータ
 */
@Data
@Table(name = "users", schema = "public")
public class Add_userRequest implements Serializable {
	
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) //登録する際に連番をつける
	@Column(name = "id")
	private Integer id;
	
	@NotNull
	@Column(name = "username")
	private String username;

	/**
	 * 投稿内容
	 */
	@NotNull
	@Email
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Column(name = "password")
	private String password;


	/**
	 * 登録日時
	 */
	@Column(name = "created_at")
	private Date createDate;
	
	/**
	 * 更新日時
	 */
	@Column(name = "updated_at")
	private Date updateDate;
	
}