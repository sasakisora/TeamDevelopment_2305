package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * ユーザー情報 リクエストデータ
 */
@Data
@Table(name = "comments", schema = "public")
public class Re_CommentsRequest implements Serializable {
	
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) //登録する際に連番をつける
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "user_id")
	private Integer user_id;


	@Column(name = "post_id")
	private Integer post_id;
	
	
	@NotNull
	@Column(name = "content")
	private String content;


	/**
	 * 登録日時
	 */
	@Column(name = "created_at")
	private Date created_at;
	
	/**
	 * 更新日時
	 */
	@Column(name = "updated_at")
	private Date updated_at;
	
}