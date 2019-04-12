package pers.skeaven.blog.dao;

import org.springframework.stereotype.Repository;
import pers.skeaven.blog.bean.po.Article;

@Repository
public interface ArticleDao {
    void saveArticle(Article article);
}
