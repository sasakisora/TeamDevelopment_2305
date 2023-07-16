package com.example.demo.repository;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LoginUserEntity;




/**
 * DBへのアクセスメソッドを呼び出すDao
 * @author aoi
 *
 */
@Repository
public class loginDao {
	
	@Autowired
	EntityManager em;
	
	/**
	 * フォームの入力値から該当するユーザを検索 合致するものが無い場合Nullが返される
	 * @param userName
	 * @return 一致するユーザが存在するとき:UserEntity、存在しないとき:Null
	 */
	public LoginUserEntity findUser(String email) {
		String query = "";
		query += "SELECT * ";
		query += "FROM users ";
		query += "WHERE email = :userEmail "; //setParameterで引数の値を代入できるようにNamedParameterを利用
		
		//EntityManagerで取得された結果はオブジェクトとなるので、LoginUser型へキャストが必要となる
		return (LoginUserEntity)em.createNativeQuery(query, LoginUserEntity.class).setParameter("userEmail", email)
				.getSingleResult();
	}

}