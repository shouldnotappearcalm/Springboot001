package com.gzr.dao;

import com.gzr.entity.TrainList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ${description}
 * Created by GZR
 * 2017-07-18
 */

public interface TranListRepository extends JpaRepository<TrainList,String>{

    Page<TrainList> findByStartStationOrEndStationLike(String keyText1,String keyText2, Pageable pageable);

    Page<TrainList> findByStartStationLike(String keyText, Pageable pageable);

}
