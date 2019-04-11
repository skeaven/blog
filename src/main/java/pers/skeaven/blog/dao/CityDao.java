package pers.skeaven.blog.dao;

import org.springframework.stereotype.Repository;
import pers.skeaven.blog.bean.po.City;

@Repository
public interface CityDao {
    City getCity(String cityName);
}
