package com.cloudin.admin.web.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Created by YFHan on 2017/1/3 0003.
 */
@Configurable
@ComponentScan(basePackages = "com.cloudin.admin", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})})
public class AppConfig {

    public AppConfig() {
        System.out.println(this.getClass().getName());
    }
}
