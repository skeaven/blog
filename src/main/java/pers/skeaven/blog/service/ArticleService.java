package pers.skeaven.blog.service;

import org.springframework.stereotype.Service;
import pers.skeaven.blog.bean.dto.ArticleRequest;
import pers.skeaven.blog.bean.po.Article;

import java.util.List;

@Service
public interface ArticleService {
    boolean saveArticle(ArticleRequest articleRequest);
    Article getArticle(String articleId);
    List<Article> getArticles();
    String getArticleDetails(String articleId);
}
