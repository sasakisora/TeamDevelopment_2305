package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * ユーザー情報 リクエストデータ
 */
@Data
@Entity
@Table(name = "users", schema = "public")
public class Add_userEntity implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //登録する際に連番をつける
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "username")
	private String username;

	/**
	 * 投稿内容
	 */
	@Column(name = "email")
	private String email;
	
	
	
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