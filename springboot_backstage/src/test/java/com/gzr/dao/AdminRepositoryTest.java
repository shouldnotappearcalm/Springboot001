package com.gzr.dao;

import com.gzr.entity.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * ${description}
 * Created by GZR
 * 2017-07-04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AdminRepositoryTest {

    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Resource
    private AdminRepository adminRepository;

    @Resource
    private CityRepository cityRepository;

    @Test
    public void test(){
        System.out.println(adminRepository.findAdminByUsername("admin"));
        System.out.println(adminRepository.findAdminByUsernameAndPassword("admin","Aa11223344"));
        System.out.println(adminRepository.findAdminByUsernameAndPasswordAndStatus("admin","Aa11223344",1));
        System.out.println(adminRepository.findAdminByStatus(1));
    }

    @Test
    public void test2(){
        int page=0,size=10;
        Sort sort=new Sort(Sort.Direction.ASC,"id");
        Pageable pageable=new PageRequest(page,size,sort);
        Page<City> pages=cityRepository.findAll(pageable);
        Page<City> pages2=cityRepository.findByStationLike("%成%",pageable);
        logger.info(pages.toString());
        logger.info("pages2:"+pages2);
    }

    @Test
    public void test3(){
        City city=new City();
        City city2=new City();
        city.setStation("1111212121");
        city2=cityRepository.save(city);
    }

    @Test
    public void test4(){
        City city=cityRepository.findCityById(1);
        City city2=cityRepository.findOne(2);
        logger.info(city.toString()+","+city2.toString());
    }

    /*@Test
    public void test5(){
        City city=cityRepository.findCityById(3031);
        city.setStation("zzzzzzzz");
        cityRepository.save(city);
    }*/

    /*@Test
    public void test6(){
        cityRepository.delete(3031);
    }*/


}