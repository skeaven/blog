package pers.skeaven.blog.dao;

import org.springframework.stereotype.Repository;
import pers.skeaven.blog.bean.po.Article;

import java.util.List;

@Repository
public interface ArticleDao {
    void insertArticle(Article article);
    Article getArticle(String articleId);
    List<Article> getArticles();
}
