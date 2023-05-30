package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Article;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {

  @Autowired
  public TestService testService;

  @GetMapping("/hello")
  public String hello() {
    return testService.Hello("abc");
  }

  @GetMapping("/article")
  public String article() {
    Optional<Article> article = testService.GetArticle();
    return article.map(a -> a.getTitle()).orElse("");
  }

  @Autowired
  private UserMapper userMapper;

  @GetMapping("/user")
  public User user() {
    return userMapper.getUserById(1);
  }

  @GetMapping("/addUser")
  public void addUser() {
    User user = new User();
    user.setAge(41);
    user.setUserName("cyx");
    userMapper.insert(user);
  }
}
