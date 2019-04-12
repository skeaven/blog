package pers.skeaven.blog.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.skeaven.blog.bean.dto.ArticleRequest;
import pers.skeaven.blog.bean.po.Article;
import pers.skeaven.blog.dao.ArticleDao;
import pers.skeaven.blog.service.ArticleService;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    private static final String MARKDOWN_DIR = "E:\\workspace\\idea\\blog\\src\\main\\resources\\static\\markdown";

//    @Autowired
//    ArticleDao articleDao;

    @Override
    public boolean saveArticle(ArticleRequest articleRequest) {
        String articleId = UUID.randomUUID().toString().replaceAll("-", "");
        File file = new File(MARKDOWN_DIR + File.separator + articleId + ".md");
        String content = StringEscapeUtils.unescapeHtml4(articleRequest.getMarkdown());

        Article article = new Article();
        article.setArticleId(articleId);
        article.setUpdateTime(System.currentTimeMillis());
        article.setCreateTime(System.currentTimeMillis());
        article.setTitle(articleRequest.getTitle());
        article.setLabel(articleRequest.getLabel());
        article.setPreview(StringEscapeUtils.unescapeHtml4(articleRequest.getHtml()).substring(0, 100));

        try {
//            articleDao.saveArticle(article);
            FileUtils.writeStringToFile(file, content, "UTF-8");
            return true;
        } catch (IOException e) {
            log.error("文件写入失败!", e);
            //TODO 进行文件清理和事务回退
            return false;
        }
    }
}
