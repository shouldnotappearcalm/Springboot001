package com.gzr.service.impl;

import com.gzr.dao.CityRepository;
import com.gzr.entity.City;
import com.gzr.service.CityService;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * ${description}
 * Created by GZR
 * 2017-07-13
 */
@Service(value = "cityService")
@Transactional
public class CityServiceImpl implements CityService {

    @Resource
    private CityRepository cityRepository;

    @Override
    public Page<City> getCityByPage(int page, int size,String keyText) {
        Sort sort=new Sort(Sort.Direction.ASC,"id");
        Pageable pageable=new PageRequest(page,size,sort);
        Page<City> pages=cityRepository.findByStationLike(keyText,pageable);
        return pages;
    }

    @Override
    public City addCity(City city) {
        return cityRepository.saveAndFlush(city);
    }

    @Override
    public City selectCityById(Integer id) {
        return cityRepository.findCityById(id);
    }

    @Override
    public void deleteCityById(Integer id) {
        cityRepository.delete(id);
    }

    @Override
    public void batchAddStation(InputStream inputStream)throws  Exception {
        try {
            XSSFWorkbook xssfWorkbook=new XSSFWorkbook(inputStream);
            //读取第一个Sheet
            XSSFSheet sheet=xssfWorkbook.getSheetAt(0);
            //定义 row、cell
            XSSFRow row;
            XSSFCell cell;
            int rowNum;
            int cellNum;
            rowNum = sheet.getLastRowNum();
            String[] args=new String[]{"station","shortCode","fullCode","province","proPinyin"};
            List<City> cityList=new ArrayList<City>();
            for (int i = 1; i <= rowNum; i++)
            {
                row = sheet.getRow(i);
                cellNum = row.getPhysicalNumberOfCells();
                City city=new City();
                for (int j = 0; j < cellNum; j++)
                {
                    cell = row.getCell(j);
                    cell.setCellType(CellType.STRING);
                    String cellValue=cell.getStringCellValue();


                    Field field=city.getClass().getDeclaredField(args[j]);
                    field.setAccessible(true);
                    field.set(city,cellValue);

                }
                cityList.add(city);
                System.out.println(city.toString());
            }
            cityRepository.save(cityList);
        } catch (Exception e) {
            e.printStackTrace();
            throw  e;
        }
    }


}
