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

    @RequestMapping(path = {"/signin"})
    public String signin(){
        return "signin";
    }

    @RequestMapping(path = {"/signout"})
    public String signout(){
        return "signout";
    }

}
