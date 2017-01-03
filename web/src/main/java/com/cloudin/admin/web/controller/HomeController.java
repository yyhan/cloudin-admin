package com.cloudin.admin.web.controller;

import com.cloudin.admin.web.lang.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by YFHan on 2017/1/3 0003.
 */
@Controller
@RequestMapping(path = "/")
public class HomeController {

    @RequestMapping(path = {"/", "/index"})
    public String index(){
        return "index";
    }

    @RequestMapping(path = {"/jsp"})
    public String jsp(Model model){
        model.addAttribute("user", "jone");
        return "/WEB-INF/jsp/index.jsp";
    }
    @RequestMapping(path = {"/freemarker"})
    public String freemarker(Model model){
        model.addAttribute("user", "jone");
//        return "/WEB-INF/freemarker/welcome.ftl";
        return "welcome";
    }
    @RequestMapping(path = {"/tiles"})
    public String tiles(Model model){
        model.addAttribute("user", "jone");
        return "/WEB-INF/tiles/index.tile";
    }

    @RequestMapping(path = {"/json"})
    @ResponseBody
    public BaseResponse json(){
        BaseResponse result = new BaseResponse();
        return  result;
    }
}
