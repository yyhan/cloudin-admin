package com.cloudin.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by YFHan on 2017/1/5 0005.
 */
@Controller
public class EChartsController {
    @RequestMapping(path = {"/echarts/index.htm"})
    public String index(){
        return "echarts/index";
    }

    @RequestMapping(path = {"/echarts/line.htm"})
    public String line(){
        return "echarts/line";
    }


    @RequestMapping(path = {"/echarts/bar.htm"})
    public String bar(){
        return "echarts/bar";
    }

    @RequestMapping(path = {"/echarts/pie.htm"})
    public String pie(){
        return "echarts/pie";
    }

    @RequestMapping(path = {"/map"})
    public String map(){
        return "echarts/map";
    }


}
