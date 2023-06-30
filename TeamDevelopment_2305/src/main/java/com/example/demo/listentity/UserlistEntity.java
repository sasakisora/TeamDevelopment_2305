package com.example.demo.listentity;

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
public class UserlistEntity implements Serializable {
  /**
   * ID
   */
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  /**
   * ユーザーID
   */
  @Column(name = "user_id")
  private String user_id;
  /**
   * コンテンツ
   */
  @Column(name = "content")
  private String content;
  /**
   * 作成
   */
  @Column(name = "created_at")
  private Date createDate;
  /**
   * 更新日時
   */
  @Column(name = "updated_at")
  private Date updated_at;
}
