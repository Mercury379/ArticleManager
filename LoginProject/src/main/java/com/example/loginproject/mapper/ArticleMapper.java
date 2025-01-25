package com.example.loginproject.mapper;

import com.example.loginproject.entity.Article;
import com.example.loginproject.entity.Writer;

import java.util.List;

public interface ArticleMapper {
    List<Article> getArticleListByName(String a_name);
    List<Article> getArticleListByWriter(String a_writer);
    List<Article> getArticleListByResource(String a_resource);
    Article getArticleById(int id);
    void deleteArticle(int id);
    void addArticle(Article article);
    void updateArticle(Article article);
}
