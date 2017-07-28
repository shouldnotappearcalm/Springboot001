package com.gzr.service;

import com.gzr.dao.TranListRepository;
import com.gzr.entity.City;
import com.gzr.entity.TrainList;
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
 * 2017-07-18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TranListServiceTest {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Resource
    private TranListService tranListService;

    @Resource
    private TranListRepository tranListRepository;

    @Test
    public void getTrainListByPage() throws Exception {
        tranListService.getTrainListByPage(1,20,"%%");
    }

}