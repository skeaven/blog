package pers.skeaven.blog.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.skeaven.blog.bean.config.PathConfig;
import pers.skeaven.blog.bean.dto.ArticleRequest;
import pers.skeaven.blog.bean.po.Article;
import pers.skeaven.blog.dao.ArticleDao;
import pers.skeaven.blog.service.ArticleService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    @Autowired
    PathConfig pathConfig;

    @Override
    public boolean saveArticle(ArticleRequest articleRequest) {
        String articleId = UUID.randomUUID().toString().replaceAll("-", "");
        String content = StringEscapeUtils.unescapeHtml4(articleRequest.getMarkdown());

        Article article = new Article();
        article.setArticleId(articleId);
        article.setUpdateTime(System.currentTimeMillis());
        article.setCreateTime(System.currentTimeMillis());
        article.setTitle(articleRequest.getTitle() + "");
        article.setLabel(articleRequest.getLabel());
        String html = StringEscapeUtils.unescapeHtml4(articleRequest.getHtml());
        article.setPreview(html.length() < 100 ? html : html.substring(0, 100));

        try {
            articleDao.insertArticle(article);
            File file = new File(pathConfig.getApplicationPath()
                    + pathConfig.getMarkdownPath() + File.separator + articleId + ".md");
            FileUtils.writeStringToFile(file, content, "UTF-8");
            log.info("文件保存成功,保存路径:{}", file.getPath());
            return true;
        } catch (IOException e) {
            log.error("文件写入失败!", e);
            //TODO 进行文件清理和事务回退
            return false;
        }
    }

    @Override
    public Article getArticle(String articleId) {
        return articleDao.getArticle(articleId);
    }

    @Override
    public List<Article> getArticles() {
        return articleDao.getArticles();
    }

    @Override
    public String getArticleDetails(String articleId) {
        try {
            String filePath = pathConfig.getApplicationPath()
                    + pathConfig.getMarkdownPath() + File.separator + articleId + ".md";
            String content = FileUtils.readFileToString(new File(filePath), "UTF-8");
            return content;
        } catch (IOException e) {
            log.error("文件读取失败!", e);
        }
        return "文章读取失败!";
    }
}
