package pers.skeaven.blog.bean.po;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Article {
    private String articleId;
    private String title;
    private String label;
    private long createTime;
    private long updateTime;
    private String author;
    private String preview;
}
