package com.gzr.dao;

import com.gzr.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ${description}
 * Created by GZR
 * 2017-07-13
 */

public interface CityRepository extends JpaRepository<City,Integer> {

    Page<City> findAll(Pageable pageable);

    Page<City> findByStationLike(String station,Pageable pageable);

    City findCityById(Integer id);

    void deleteById(Integer id);

}
