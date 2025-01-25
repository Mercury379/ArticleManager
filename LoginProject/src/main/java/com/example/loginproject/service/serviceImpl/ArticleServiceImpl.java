package com.example.loginproject.service.serviceImpl;

import com.example.loginproject.entity.Article;
import com.example.loginproject.entity.Writer;
import com.example.loginproject.mapper.ArticleMapper;
import com.example.loginproject.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("ArticleService")
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Override
    public List<Article> getArticleList(String type, String a_name) {
        List<Article> articleList;
        if(type.equals("作者")){
            articleList=articleMapper.getArticleListByWriter(a_name);
        } else if (type.equals("来源")) {
            articleList=articleMapper.getArticleListByResource(a_name);
        }else {
            articleList=articleMapper.getArticleListByName(a_name);
        }
        return articleList;
    }

    @Override
    public Article getArticleById(int id) {
        return articleMapper.getArticleById(id);
    }

    @Override
    public void deleteArticle(int id) {
        articleMapper.deleteArticle(id);
    }

    @Override
    public void addArticleInfo(Article article) {
        List<Article> articles=articleMapper.getArticleListByName("");
        int maxId=0;
        for(int i=0;i<articles.size();i++){
            if(articles.get(i).getA_id()>maxId){
                maxId=articles.get(i).getA_id();
            }
        }
        article.setA_id(maxId+1);
        articleMapper.addArticle(article);
    }

    @Override
    public void updateArticle(Article article) {
        articleMapper.updateArticle(article);
    }
}
