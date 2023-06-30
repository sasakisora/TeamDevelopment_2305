package com.example.demo.dto;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ユーザー情報更新リクエストデータ
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class UserUpdateRequest extends UserRequest implements Serializable {

  /**
   * ユーザーID
   */
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) //登録する際に連番をつける
	@Column(name = "id")
	private Integer id;
  
	/**
	 * 投稿内容
	 */
	@Column(name = "edit")
	private String edit;

}