package pers.skeaven.blog.bean.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "project-path")
public class PathConfig {
    private String applicationPath;
    private String markdownPath;

    public String getApplicationPath(){
        if (applicationPath == null){
            applicationPath = new ApplicationHome(getClass()).getSource().getParent();
        }
        return applicationPath;
    }
}
