package com.example.loginproject.Controller;

import com.example.loginproject.entity.Article;
import com.example.loginproject.entity.Writer;
import com.example.loginproject.service.ArticleService;
import com.example.loginproject.service.UserService;
import com.example.loginproject.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @GetMapping("/getArticleList")
    @ResponseBody
    public ResponseData getWriterList(@RequestParam String searchType,@RequestParam String searchName) {
        ResponseData responseData;
        List<Article> articleList;
        articleList=articleService.getArticleList(searchType,searchName);
        if(!articleList.isEmpty()){
            responseData = new ResponseData(200,"查找文章列表成功");
            responseData.putDataValue("writerList",articleList);
        }else{
            responseData = new ResponseData(401,"系统内无对应文章！");
        }
        return responseData;
    }
    @PostMapping("/getArticleById")
    @ResponseBody
    public ResponseData getArticleInfo(@RequestBody Map<String, String> articleInfo) {
        ResponseData responseData=new ResponseData(200,"查找文章信息成功");
        Article article=articleService.getArticleById(Integer.parseInt(articleInfo.get("id")));
        responseData.putDataValue("writerInfo",article);
        return responseData;
    }
    @PostMapping("/deleteArticle")
    @ResponseBody
    public ResponseData deleteArticle(@RequestBody Map<String, String> deleteInfo) {
        ResponseData responseData;
        articleService.deleteArticle(Integer.parseInt(deleteInfo.get("id")));
        List<Article> writerList=articleService.getArticleList("","");
        if(!writerList.isEmpty()){
            responseData = new ResponseData(200,"查找作者列表成功");
            responseData.putDataValue("writerList",writerList);
        }else{
            responseData = new ResponseData(401,"系统内无作者！");
        }
        return responseData;
    }
    @PostMapping("/addArticle")
    @ResponseBody
    public ResponseData addArticle(@RequestBody Map<String, String> articleInfo) {
        ResponseData responseData;
        Article article=new Article();
        article.setA_abstract(articleInfo.get("a_abstract"));
        article.setA_name(articleInfo.get("a_name"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
            date = sdf.parse(articleInfo.get("a_date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        article.setA_date(date);
        article.setA_keyword(articleInfo.get("a_keyword"));
        article.setA_resource(articleInfo.get("a_resource"));
        article.setA_type(articleInfo.get("a_type"));
        article.setA_writer(articleInfo.get("a_writer"));
        articleService.addArticleInfo(article);
        responseData=new ResponseData(200,"添加成功！");
        return responseData;
    }
    @PostMapping("/updateArticle")
    @ResponseBody
    public ResponseData updateArticle(@RequestBody Map<String, String> articleInfo) {
        ResponseData responseData;
        Article article=new Article();
        article.setA_id(Integer.parseInt(articleInfo.get("a_id")));
        article.setA_name(articleInfo.get("a_name"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
            date = sdf.parse(articleInfo.get("a_date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        article.setA_date(date);
        article.setA_writer(articleInfo.get("a_writer"));
        article.setA_keyword(articleInfo.get("a_keyword"));
        article.setA_resource(articleInfo.get("a_resource"));
        article.setA_type(articleInfo.get("a_type"));
        article.setA_abstract(articleInfo.get("a_abstract"));
        articleService.updateArticle(article);
        responseData=new ResponseData(200,"添加成功！");
        return responseData;
    }
}
