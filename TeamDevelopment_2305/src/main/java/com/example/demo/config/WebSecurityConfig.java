package com.example.demo.config;
//package com.example.demo;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration //設定クラスをSpringへ
//
//@EnableWebSecurity //SpSeを使う設定
//
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private UserDetailsService memberDetailsService;
//
//	//このメソッドをオーバーライド→特定のリクエスト（セキュリティ設定）を無視
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/css/**", "/js/**", "/images/**");
//	}
//
//	//URLごとにセキュリティ設定を行う
//	//このメソッドをオーバーライド→認可に設定やログインに関する設定ができるはず
//
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//    	//認可
//		http.authorizeHttpRequests() 
//    	.antMatchers("/","/register","/register/decision").permitAll()
//    	//↑記載したパスは全てのユーザーに許可
//    	
//		.antMatchers("/admin/**").hasRole("ADMIN");
//		///admin/から始まるパスはadmin権限でログインしている場合のみアクセスok
//		.antMatchers("/user/**").hasRole("USER");
//		///user/から始まるパスはuser権限でログインしている場合のみアクセスok
//		.anyRequest().authenticated(); 
//		//他のパスは認証が必要
//		
//		//ログインの設定
//    	http.formLogin() 
//    	
//    	.loginPage("/") 
//    	//ログイン画面に遷移させるパス
//    	.loginProcessingUrl("/login") 
//    	//ログインボタンを押したときに遷移させるパス
//    	.failureUrl("/?error=true") 
//    	//ログイン失敗時に遷移させるパス
//    	.defaultSuccessUrl("/afterLogin/top",true) 
//			//	第1引数:デフォルトでログイン成功時に遷移させるパス
//    	    //第2引数: true :認証後常に第1引数のパスに遷移
//    	
//    	//false:認証されてなくて一度ログイン画面に飛ばされてもログインしたら指定したURLに遷移
//    	.usernameParameter("email")     
//    	//認証時に使用するメールアドレスのリクエストパラメータ名
//    	.passwordParameter("password"); 
//        //認証時に使用するパスワードのリクエストパラメーター名
//    	
//    }
//
//	//認証方法の実装
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(memberDetailsService)
//				.passwordEncoder(new BCryptPasswordEncoder());
//	}
//
//	//bcryptアルゴリズム(bcryptを利用すると次のようなハッシュ値が生成されます。このハッシュ値からハッシュアルゴリズム、ストレッチング回数、ソルトの値などが分かるようになっています。)でハッシュ化する実装を返す
//	//指定することでパスワードハッシュ化やマッチ確認する際に
//	//@Autowired
//	//private PasswordEncoder passwordEncoder;
//	//と記載するとDIされるようになります。
//
//	//@return bcryptアルゴリズムでハッシュ化する実装オブジェクト
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//}
