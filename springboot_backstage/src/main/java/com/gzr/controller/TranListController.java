package com.gzr.controller;

import com.gzr.entity.TrainList;
import com.gzr.service.TranListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * ${description}
 * Created by GZR
 * 2017-07-18
 */
@Controller
@RequestMapping(value = "/admin")
public class TranListController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Resource
    private TranListService tranListService;

    @RequestMapping("/selectTrainListLimit/{page}/{size}")
    @ResponseBody
    public Page<TrainList> selectPage(@PathVariable(name = "page")int page, @PathVariable(name = "size")int pageSize, @RequestParam(name = "keyText",defaultValue = "",required = false) String keyText){
        logger.info("page:"+page+",size:"+pageSize+",keyText:"+keyText);
        keyText=keyText.trim();
        return tranListService.getTrainListByPage(page-1,pageSize,keyText);
    }

}
