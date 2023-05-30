package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.annotation.MyTestAnnotation;
import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.service.TestService;

@Service
public class TestServiceImpl implements TestService {

  @Autowired
  public ArticleRepository articleRepository;

  @Override
  @MyTestAnnotation(value="test")
  public String Hello(String input) {
    return input + ":abc";
  }

  @Override
  @MyTestAnnotation(value="Article")
  public Optional<Article> GetArticle() {
    long id = 1;
    return articleRepository.findById(id);
  }
  
}
