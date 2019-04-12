package pers.skeaven.blog.bean.po;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Article {
    private String articleId;
    private String markdown;
    private String html;
}
