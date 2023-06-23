package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.service.LoginUserService;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(
				"/images/**",
				"/css/**",
				"/javascript/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				//「login.html」はログイン不要でアクセス可能に設定
				.antMatchers("/login").permitAll()
				//上記以外は直リンク禁止
				.anyRequest().authenticated()
				.and()
				.formLogin()
				//ログイン処理のパス
				.loginProcessingUrl("/login")
				//ログインページ
				.loginPage("/login")
				//ログインエラー時の遷移先 ※パラメーターに「error」を付与
				//                    .failureUrl("/login?error")
				//ログイン成功時の遷移先
				.defaultSuccessUrl("/hello", true)
				//ログイン時のキー：名前
				.usernameParameter("email")
				//ログイン時のパスワード
				.passwordParameter("{noop}password")
				.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutUrl("/logout") //ログアウトのURL
				.invalidateHttpSession(true)
				//ログアウト時の遷移先 POSTでアクセス
				.logoutSuccessUrl("/afterLogout.html");
	}

	@Autowired
	LoginUserService service;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service);
		auth.userDetailsService(service).passwordEncoder(passwordEncoder());
	}

}