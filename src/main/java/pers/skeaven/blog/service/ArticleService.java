package pers.skeaven.blog.service;

import org.springframework.stereotype.Service;
import pers.skeaven.blog.bean.dto.ArticleRequest;
import pers.skeaven.blog.bean.po.Article;

@Service
public interface ArticleService {
    boolean saveArticle(ArticleRequest articleRequest);
    Article getArticle(String articleId);
}
