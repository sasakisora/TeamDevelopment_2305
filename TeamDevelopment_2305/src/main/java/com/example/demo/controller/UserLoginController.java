package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLoginController {
	

	//ログイン画面への遷移
	@GetMapping
	public String getLogin() {
		return "login";
	}

	//ログイン成功時のメニュー画面への遷移
	@GetMapping("/hello")
	public String postLogin() {
		return "hello";
	}

	 
	} 
