package pers.skeaven.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pers.skeaven.blog.bean.po.City;
import pers.skeaven.blog.dao.CityDao;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private CityDao cityDao;

    @ResponseBody
    @RequestMapping("/hello")
    public Object hello() {
        return "hello";
    }

    @ResponseBody
    @RequestMapping("/city/{cityName}")
    public City getCity(@PathVariable String cityName) {
        return cityDao.getCity(cityName);
    }

    @ResponseBody
    @RequestMapping("/paths")
    public Map<String, String> getPath() {
        Map<String, String> paths = new HashMap<>();
        try {
            //通过ResourceUtils方式获取路径
            String path1 = ResourceUtils.getURL("classpath:").getFile();
            String path2 = System.getProperty("user.dir");
            String path3 = ClassUtils.getDefaultClassLoader().getResource("").getPath();
            String path4 = new File(path1).getAbsolutePath();
            ApplicationHome applicationHome = new ApplicationHome(getClass());
            String path5 = applicationHome.getSource().getParent();
            paths.put("1",path1);
            paths.put("2",path2);
            paths.put("3",path3);
            paths.put("4",path4);
            paths.put("5",path5);
        } catch (Exception e) {
            System.out.println(e);
        }
        return paths;
    }

}
