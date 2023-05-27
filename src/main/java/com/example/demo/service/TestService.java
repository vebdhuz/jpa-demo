package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Article;

public interface TestService {
  String Hello(String input);
  Optional<Article> GetArticle();
}
