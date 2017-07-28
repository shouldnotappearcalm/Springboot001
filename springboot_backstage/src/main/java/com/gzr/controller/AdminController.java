package com.gzr.controller;

import com.gzr.dao.AdminRepository;
import com.gzr.util.Constant;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * ${description}
 * Created by GZR
 * 2017-07-04
 */
@Controller
public class AdminController {

    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Resource
    private AdminRepository adminRepository;


    @RequestMapping(value="/login")
    public String login(HttpServletRequest request){
        return "login";
    }

    @RequestMapping(value = "/")
    public String index(){
        logger.info("请求/");
        return "redirect:admin/index";
    }

    @RequestMapping(value = "admin/index")
    public String index(ModelMap map){
        logger.info("请求admin/index");
        return "admin/adminindex";
    }
    @RequestMapping(value = "admin/welcome")
    public String welcome(){
        logger.info("请求admin/welcome");
        return "admin/welcome";
    }

    @RequestMapping(value = "admin/article-list")
    public String article(){
        logger.info("请求admin/article_list");
        return "admin/article-list";
    }

    @RequestMapping(value = "admin/station")
    public String station(){
        logger.info("请求station管理请求");
        return "admin/station-list";
    }

    @RequestMapping(value = "/login/checkCode",method = RequestMethod.GET)
    @ResponseBody
    public String checkImgCode(HttpServletRequest request){
        String code=request.getParameter("code");
        logger.info("验证code:"+code);
        HttpSession session=request.getSession();
        String sessionCode=session.getAttribute(Constant.IMG_CODE.getValue()).toString();
        if(null!=code&&code.equalsIgnoreCase(sessionCode)){
            return "success";
        }
        return "error";
    }
}
