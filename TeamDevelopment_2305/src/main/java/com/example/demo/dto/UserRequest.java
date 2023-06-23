//package com.example.demo.dto;
//
//import java.io.Serializable;
//
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;
//
//import lombok.Data;
//
//
// //ユーザー情報 リクエストデータ
// 
//@Data
//public class UserRequest implements Serializable {
//
//  
//   //名前
// 
//  @NotEmpty(message = "ユーザーネームを入力してください")
//  @Size(max = 100, message = "ユーザーネームは100桁以内で入力してください")
//  private String name;
//
////メールアドレス  
//  @Size( message = "正しいアドレスを入力してください")
//  private String email;
//
// //4〜8文字が必要であり、数字、小文字、大文字が含まれていること
//  @Pattern(regexp =  "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$", message = "正しいパスワードを入力してください")
//  private String passward;
//}
//
////入力チェックのルール