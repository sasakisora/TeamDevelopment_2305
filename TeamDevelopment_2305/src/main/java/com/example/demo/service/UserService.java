package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.Add_userRequest;
import com.example.demo.dto.Re_CommentsRequest;
import com.example.demo.dto.UserRequest;
import com.example.demo.entity.Add_userEntity;
import com.example.demo.entity.Re_CommentsEntity;
//import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.Add_userRepository;
import com.example.demo.repository.Re_CommentsRepository;
import com.example.demo.repository.UserRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
	/**
	 * ユーザー情報 Repository
	 */
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private Add_userRepository add_userRepository;
	@Autowired
	private Re_CommentsRepository re_commentsRepository;

	/**
	 * ユーザー情報 全検索
	 * @return 検索結果
	 */
	public List<UserEntity> searchAll() {
		return userRepository.findAll();
	}
	/**
	 * ユーザー情報 主キー検索
	 * @return 検索結果
	 */
	public UserEntity findById(Integer id) {
		return userRepository.getOne(id);
	}
	
	public UserEntity findByUser_Id(Integer id) {
		return userRepository.findById(id).get();
	}
	
	public UserEntity getUser_Id(Integer user_id) {
		return userRepository.findById(user_id).get();
	}
	
	//返信用テーブルに保存
	public void reply(Re_CommentsRequest re_commentsRequest) {
		Date now = new Date();
		Re_CommentsEntity reply = new Re_CommentsEntity();
		reply.setId(re_commentsRequest.getId());
		reply.setUser_id(2);
		reply.setPost_id(3);
		reply.setContent(re_commentsRequest.getContent());
		reply.setCreated_at(now);
		reply.setUpdated_at(now);
		re_commentsRepository.save(reply);
	}
	
	


	/**
	 * ユーザー情報 新規登録
	 * @param user ユーザー情報
	 */
	public void create(Add_userRequest add_userRequest) {
		Date now = new Date();
		Add_userEntity user = new Add_userEntity();
		user.setUsername(add_userRequest.getUsername());
		user.setEmail(add_userRequest.getEmail());
		user.setPassword(add_userRequest.getPassword());
		user.setCreateDate(now);
		user.setUpdateDate(now);
		add_userRepository.save(user);
	}
	
	
	
	
//	/**
//	 * ユーザー情報 更新
//	 * @param user ユーザー情報
//	 */
//	public void update(UserUpdateRequest userUpdateRequest) {
//		UserEntity user = findById(userUpdateRequest.getId());
//		//user.setContent(userUpdateRequest.getContent());
//		user.setUpdateDate(new Date());
//		userRepository.save(user);
//	}
	
	//編集情報を保存
	public void update(UserRequest userRequest) {
		UserEntity content = findById(userRequest.getId());
		content.setId(userRequest.getId());
		content.setContent(userRequest.getContent());
		content.setUpdateDate(new Date());
		userRepository.save(content);
	}

	/**
	 * ユーザー情報 物理削除
	 * @param id ユーザーID
	 */
	public void delete(Integer id) {
		userRepository.deleteById(id);
	}
}