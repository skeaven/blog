package pers.skeaven.blog.bean.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ArticleRequest {
    private String title;
    private String label;
    private String markdown;
    private String html;
}
