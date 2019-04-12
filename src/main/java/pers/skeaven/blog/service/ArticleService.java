package pers.skeaven.blog.service;

import org.springframework.stereotype.Service;
import pers.skeaven.blog.bean.dto.ArticleRequest;

@Service
public interface ArticleService {
    boolean saveArticle(ArticleRequest articleRequest);
}
