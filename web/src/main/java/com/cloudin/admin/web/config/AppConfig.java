package com.cloudin.admin.web.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by YFHan on 2017/1/3 0003.
 */
@ComponentScan(basePackages = "com.cloudin.admin", excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = {"com.cloudin.admin.web"})})
@PropertySource(encoding = "UTF-8", value = {"classpath:application.properties"})
public class AppConfig  {

    private Logger logger;

    public AppConfig() {
        logger = LogManager.getLogger(this);
        logger.info("init...");
    }

}
