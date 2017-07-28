package com.gzr.service.impl;

import com.gzr.dao.TranListRepository;
import com.gzr.entity.City;
import com.gzr.entity.TrainList;
import com.gzr.service.TranListService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * ${description}
 * Created by GZR
 * 2017-07-18
 */
@Service("tranListService")
@Transactional
public class TrainListServiceImpl implements TranListService {

    @Resource
    private TranListRepository tranListRepository;

    @Override
    public Page<TrainList> getTrainListByPage(int page, int size, String ketText) {
        Sort sort=new Sort(Sort.Direction.ASC,"id");
        Pageable pageable=new PageRequest(page,size,sort);
        Page<TrainList> pages=tranListRepository.findByStartStationOrEndStationLike(ketText,ketText,pageable);
        return pages;
    }
}
