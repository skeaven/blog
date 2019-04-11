package pers.skeaven.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pers.skeaven.blog.bean.po.City;
import pers.skeaven.blog.dao.CityDao;

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

}
