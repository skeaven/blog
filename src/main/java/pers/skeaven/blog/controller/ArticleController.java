package pers.skeaven.blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.skeaven.blog.bean.dto.ArticleRequest;
import pers.skeaven.blog.service.ArticleService;

@RestController
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ResponseBody
    @RequestMapping(value = "/article", method = RequestMethod.POST)
    public Object saveArticle(@RequestBody ArticleRequest articleRequest) {
        boolean success = articleService.saveArticle(articleRequest);
        if (success)
            return "保存完成";
        else
            return "保存失败";
    }

    @ResponseBody
    @RequestMapping(value = "/article", method = RequestMethod.PUT)
    public Object updateArticle(@RequestBody ArticleRequest articleRequest) {
        log.info("保存完成{}", StringEscapeUtils.unescapeHtml4(articleRequest.getHtml()));
        return "保存完成";
    }

    @ResponseBody
    @RequestMapping(value = "/article/{articleId}", method = RequestMethod.GET)
    public Object getArticle(@PathVariable String articleId) {
        return articleId;
    }
}
