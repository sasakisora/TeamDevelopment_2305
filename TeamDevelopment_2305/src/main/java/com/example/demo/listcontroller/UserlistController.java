package com.example.demo.listcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.listentity.UserlistEntity;
import com.example.demo.listservice.UserlistService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class UserlistController {
  /**
   * ユーザー情報 Service
   */
  @Autowired
  private UserlistService userlistService;

  /**
   * ユーザー情報一覧画面を表示
   *
   * @param model Model
   * @return ユーザー情報一覧画面
   */
//  @GetMapping(value = "/user/list")
//  public String displayList(Model model) {
//    List<UserlistEntity> userlist = userlistService.searchAll();
//    model.addAttribute("userlist", userlist);
//    return "user/list";
//  }
//  
  
  @GetMapping("/user/list")
  public String search(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
    if (keyword != null) {
      List<UserlistEntity> results = userlistService.searchByKeyword(keyword);
      model.addAttribute("userlist", results);
    } else {
      List<UserlistEntity> userlist = userlistService.searchAll();
      model.addAttribute("userlist", userlist);
    }
    return "user/list";
  }
  
  
  
  
  
  
//  @GetMapping(value = "/user/list")
//  public String displaylist(Model model) {
//	  return "user/list";  
//  }
//  
  
  /**
   * マイページを表示
   *
   * @param model Model
   * @return マイページ
   */
  @GetMapping(value = "/user/mypage")
  public String displayview(Model model) {
	  return "user/mypage";  
  }

  /**
   * キーワード検索
   *
   * @param keyword 検索キーワード
   * @return 検索結果リスト
   */
 @GetMapping("/list")
  public List<UserlistEntity> search(@RequestParam String keyword) {
   List<UserlistEntity> results = userlistService.searchByKeyword(keyword);
   return results;
  }
 
 /**
  * 返信画面を表示
  *
  * @param id    返信対象の投稿ID
  * @param model Model
  * @return 返信画面
  */
 @GetMapping("/user/reply")
 public String displayReply(@RequestParam("id") int id, Model model) {
     // 返信対象の投稿IDをモデルにセット
     model.addAttribute("postId", id);
     return "user/reply";
 }

}