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
 * ユーザー情報 Entity
 */
@Entity
@Data
@Table(name = "posts")
public class Post implements Serializable {

  /**
   * ID
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * ユーザーID
   */
  @Column(name = "user_id")
  private Long userId;

  /**
   * コンテンツ
   */
  @Column(name = "content")
  private String content;

  /**
   * 作成日時
   */
  @Column(name = "created_at")
  private Date createdAt;

  /**
   * 更新日時
   */
  @Column(name = "updated_at")
  private Date updatedAt;

  // コンストラクタ、ゲッター、セッター、toString()などの必要なメソッドを実装

}
