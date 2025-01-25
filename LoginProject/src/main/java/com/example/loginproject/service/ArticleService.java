package com.example.loginproject.service;

import com.example.loginproject.entity.Article;
import com.example.loginproject.entity.Writer;

import java.util.List;

public interface ArticleService {
    public List<Article> getArticleList(String type,String a_name);
    public Article getArticleById(int id);
    public void deleteArticle(int id);
    public void addArticleInfo(Article article);
    public void updateArticle(Article article);
}
