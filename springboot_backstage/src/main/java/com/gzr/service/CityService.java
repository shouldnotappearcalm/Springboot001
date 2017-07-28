package com.gzr.service;

import com.gzr.entity.City;
import org.springframework.data.domain.Page;

import java.io.InputStream;

/**
 * ${description}
 * Created by GZR
 * 2017-07-13
 */

public interface CityService {

    public Page<City> getCityByPage(int page,int size,String ketText);

    public City addCity(City city);

    public City selectCityById(Integer id);

    public void deleteCityById(Integer id);

    public void batchAddStation(InputStream inputStream)throws  Exception ;

}
