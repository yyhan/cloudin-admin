package com.cloudin.admin.web.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by YFHan on 2017/1/3 0003.
 */
@EnableWebMvc
@ComponentScan(basePackages = "com.cloudin.admin.web.controller")
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    private Logger logger;

    public WebMvcConfig() {
        logger = LogManager.getLogger(this);
        logger.info("init...");
    }

    /**
     * freemarker 框架配置
     *
     * @return
     */
    @Bean()
    public FreeMarkerConfigurer getFreeMarkerConfigurer(Environment environment) {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("/WEB-INF/view/");
        configurer.setDefaultEncoding("UTF-8");

        // 加载freemarker配置参数
        try {
            Properties setting = new Properties();
            setting.load(new InputStreamReader(getClass().getResourceAsStream("/freemarker.properties"), "UTF-8"));
            Enumeration<String> enumeration = (Enumeration<String>) setting.propertyNames();
            configurer.setFreemarkerSettings(setting);
            if (logger.isDebugEnabled()) {
                while (enumeration.hasMoreElements()) {
                    String k = enumeration.nextElement();
                    logger.debug("{}:{}", k, setting.getProperty(k));
                }
            }
        } catch (IOException e) {
            logger.error(e);
        }

        // 加载freemarker全局变量
        try {
            HashMap<String, Object> freemarkerVars = new LinkedHashMap<>();
            Properties vars = new Properties();
            vars.load(new InputStreamReader(getClass().getResourceAsStream("/freemarker-vars.properties"), "UTF-8"));
            Enumeration<String> varsEnum = (Enumeration<String>) vars.propertyNames();
            while (varsEnum.hasMoreElements()) {
                String k = varsEnum.nextElement();
                String v = vars.getProperty(k);
                freemarkerVars.put(k, v);
                if (logger.isDebugEnabled()) {
                    logger.debug("{}:{}", k, v);
                }
            }
            configurer.setFreemarkerVariables(freemarkerVars);
        } catch (IOException e) {
            logger.error(e);
        }

        return configurer;
    }

    /**
     * 视图解析器配置
     *
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setSuffix(".ftl");
        freeMarkerViewResolver.setCache(true);
        freeMarkerViewResolver.setContentType("text/html; charset=UTF-8");
        registry.viewResolver(freeMarkerViewResolver);
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.TEXT_HTML);
    }

    /**
     * 添加静态资源处理
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        registry.addResourceHandler("/example/**").addResourceLocations("/example/");
        registry.addResourceHandler("/index.html").addResourceLocations("/index.html");
        registry.addResourceHandler("/detail.html").addResourceLocations("/detail.html");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    }

    /**
     * 消息转换器配置<br>
     * 配置fastjson用于解析json数据
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setCharset(Charset.forName("UTF-8"));
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:MM:SS.fff");
        FastJsonHttpMessageConverter4 jsonConverter = new FastJsonHttpMessageConverter4();
        jsonConverter.setFastJsonConfig(fastJsonConfig);
        jsonConverter.setSupportedMediaTypes(new ArrayList<MediaType>() {
            {
                add(MediaType.APPLICATION_JSON);
                add(MediaType.APPLICATION_JSON_UTF8);
            }
        });
        converters.add(jsonConverter);
    }


}