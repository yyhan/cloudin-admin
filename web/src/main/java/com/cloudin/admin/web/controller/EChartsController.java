package com.cloudin.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by YFHan on 2017/1/5 0005.
 */
@Controller
@RequestMapping(path = "/echarts")
public class EChartsController {
    @RequestMapping(path = {"/", "/index"})
    public String index(){
        return "echarts/index";
    }

    @RequestMapping(path = {"/", "/line"})
    public String line(){
        return "echarts/line";
    }


    @RequestMapping(path = {"/bar"})
    public String bar(){
        return "echarts/bar";
    }

    @RequestMapping(path = {"/pie"})
    public String pie(){
        return "echarts/pie";
    }

    @RequestMapping(path = {"/map"})
    public String map(){
        return "echarts/map";
    }


}
