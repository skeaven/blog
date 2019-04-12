package pers.skeaven.blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.web.bind.annotation.*;
import pers.skeaven.blog.bean.po.Article;

@RestController
@Slf4j
public class ArticleController {

    @ResponseBody
    @RequestMapping(value = "/article", method = RequestMethod.POST)
    public Object saveArticle(@RequestBody Article article) {
        log.info("保存完成{}", StringEscapeUtils.unescapeHtml4(article.getHtml()));
        return "保存完成";
    }

    @ResponseBody
    @RequestMapping(value = "/article/{articleId}", method = RequestMethod.GET)
    public Object getArticle(@PathVariable String articleId) {
        return articleId;
    }
}
