package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * ユーザー情報 リクエストデータ
 */
@Data
@Entity
@Table(name = "comments", schema = "public")
public class Re_CommentsRequest implements Serializable {
	
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) //登録する際に連番をつける
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "user_id")
	private String user_id;

	/**
	 * 投稿内容
	 */
	@Column(name = "post_id")
	private String post_id;
	
	
	
	@Column(name = "content")
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
