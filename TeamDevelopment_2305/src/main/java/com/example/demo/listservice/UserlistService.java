package com.example.demo.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.listentity.UserlistEntity;
import com.example.demo.listrepository.UserlistRepository;

/**
 * ユーザー情報 Service
 */
@Service
public class UserlistService {
  /**
   * ユーザー情報 Repository
   */
  @Autowired
  private UserlistRepository userlistRepository;

  /**
   * ユーザー情報 全検索
   *
   * @return 検索結果
   */
  public List<UserlistEntity> searchAll() {
    return userlistRepository.findAll();
  }

  /**
   * キーワードでユーザー情報を検索
   *
   * @param keyword 検索キーワード
   * @return 検索結果リスト
   */
 
  public List<UserlistEntity> searchByKeyword(String keyword) {
    return userlistRepository.findByContentContaining(keyword);
  }
}
