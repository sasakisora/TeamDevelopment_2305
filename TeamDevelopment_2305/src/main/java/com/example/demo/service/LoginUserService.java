package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LoginUserEntity;
import com.example.demo.repository.LoginUserRepository;

@Service
public class LoginUserService implements UserDetailsService {

	@Autowired
	private LoginUserRepository loginUserRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// メールアドレスによりユーザーを検索
		LoginUserEntity userEntity = loginUserRepository.findByEmail(email);

		if (userEntity == null) {
			throw new UsernameNotFoundException("そのEmailは登録されていません");
		}

		// 権限情報を格納するためのリストの作成、権限の付与
		Collection<GrantedAuthority> authorityList = new ArrayList<>();
		authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));

		return new org.springframework.security.core.userdetails.User(
				userEntity.getEmail(),
				userEntity.getPassword(),
				authorityList);
	}
}
