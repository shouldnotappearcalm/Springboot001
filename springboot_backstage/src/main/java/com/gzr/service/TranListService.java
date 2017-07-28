package com.gzr.service;

import com.gzr.entity.City;
import com.gzr.entity.TrainList;
import org.springframework.data.domain.Page;

/**
 * ${description}
 * Created by GZR
 * 2017-07-18
 */

public interface TranListService {

    public Page<TrainList> getTrainListByPage(int page, int size, String ketText);

}
