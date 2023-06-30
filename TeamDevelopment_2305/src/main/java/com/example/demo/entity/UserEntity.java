package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;



//ポストEntity
@Data
@Entity
@Table(name = "posts", schema = "public")
public class UserEntity  {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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






/**
 * ユーザー情報 Entity
 */
//@Data
//@Entity
//@Table(name = "user", schema = "public")
//public class UserEntity  {
//
//	/**
//	 * ID
//	 */
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
//	private Integer id;
//
//	/**
//	 * 名前
//	 */
//	@Column(name = "name")
//	private String name;
//
//	/**
//	 * 住所
//	 */
//	@Column(name = "address")
//	private String address;
//
//	/**
//	 * 電話番号
//	 */
//	@Column(name = "phone")
//	private String phone;
//
//	/**
//	 * 更新日時
//	 */
//	@Column(name = "update_date")
//	private Date updateDate;
//
//	/**
//	 * 登録日時
//	 */
//	@Column(name = "create_date")
//	private Date createDate;
//
//	/**
//	 * 削除日時
//	 */
//	@Column(name = "delete_date")
//	private Date deleteDate;
//}