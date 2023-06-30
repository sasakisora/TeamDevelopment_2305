package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * ユーザー情報 リクエストデータ
 */
@Data
@Table(name = "posts", schema = "public")
public class UserRequest implements Serializable {
		/**
		 * ID
		 */
		@Id
		//@GeneratedValue(strategy = GenerationType.IDENTITY) //登録する際に連番をつける
		@Column(name = "id")
		private Integer id;

		/**
		 * ユーザーID
		 */
		@Column(name = "user_id")
		private Integer user_id;

		/**
		 * 投稿内容
		 */
		@Column(name = "content")
		private String content;

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