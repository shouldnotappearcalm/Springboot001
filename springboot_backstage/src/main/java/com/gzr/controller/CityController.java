package com.gzr.controller;

import com.gzr.dto.Result;
import com.gzr.entity.City;
import com.gzr.service.CityService;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;

/**
 * ${description}
 * Created by GZR
 * 2017-07-13
 */
@Controller
@RequestMapping(value = "/admin")
public class  CityController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Resource
    private CityService cityService;

    @RequestMapping("/limit")
    @ResponseBody
    public Page<City> getCityByLimit(){
        return cityService.getCityByPage(1,10,"%%");
    }

    @RequestMapping("/selectPage")
    @ResponseBody
    public Page<City> selectPage(@RequestParam(name = "page",defaultValue = "1",required = false)int page,@RequestParam(name = "pageSize",defaultValue = "10",required = false)int pageSize,@RequestParam(name = "keyText",defaultValue = "%%",required = false)String keyText){
        logger.info("page:"+page+",size:"+pageSize+",keyText:"+keyText);
        return cityService.getCityByPage(page-1,pageSize,keyText);
    }

    @RequestMapping("/getSomePageByName")
    public String addStation(@RequestParam(name = "pageName")String pageName){
        logger.info("getPageName:"+pageName);
        return "admin/"+pageName.replace("\"","");
    }

    @RequestMapping("/getPage/{name}")
    public String getPage(@PathVariable("name")String pageName){
        logger.info("getPageName:"+pageName);
        return "admin/"+pageName;
    }

    /*@RequestMapping("/selectCity")
    @ResponseBody
    public Page<City> selectCity(@RequestParam(name="keyText",defaultValue = "",required = false)String keyText){

    }*/

    @RequestMapping("/addStation")
    @ResponseBody
    public Result<City> addSation(City city){
        logger.info("city:"+city.toString());
        City city2=cityService.addCity(city);
        if(city2!=null) {
            return new Result<City>(true, city);
        }else{
            return new Result<City>(false, "失败");
        }
    }

    @RequestMapping("/editStation/{id}")
    public String getEditPage(@PathVariable("id")Integer id, ModelMap map){
        map.put("id",id);
        logger.info("id:"+id.toString());
        return "admin/station-edit";
    }

    @RequestMapping("/getCity/{id}")
    @ResponseBody
    public Result<City> selectCity(@PathVariable("id")Integer id){
        City city=cityService.selectCityById(id);
        logger.info("city:"+city.toString());
        if(city!=null) {
            return new Result<City>(true, city);
        }
        return new Result<City>(false, "");
    }

    @RequestMapping("ediStation")
    @ResponseBody
    public Result<City> editStation(City city){
        logger.info("editStation:city:"+city.toString());
        City newCity=cityService.addCity(city);
        if(newCity!=null) {
            return new Result<City>(true, newCity);
        }
        return new Result<City>(false,"错误");
    }

    @RequestMapping("/deleteCityById/{id}")
    @ResponseBody
    public Result<City> deleteCityById(@PathVariable("id")Integer id){
        try {
            cityService.deleteCityById(id);
            return new Result<City>(true,"成功");
        }catch (Exception e){
            return new Result<City>(false,"错误");
        }

    }

    @RequestMapping("/batchAdd")
    public String batchAddStation(@RequestParam(name = "file") MultipartFile file){
        if(file==null|| ("").equals(file.getName()) && file.getSize()==0){
            return "/admin/error";
        }else if(!"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet".equalsIgnoreCase(file.getContentType())){
            logger.info("上传格式不对");
            return "admin/error";
        }
        logger.info(file.getContentType()+","+file.getOriginalFilename()+","+file.getName());
        try {
            cityService.batchAddStation(file.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
            return "admin/error";
        }
        return "admin/success";
    }

}
