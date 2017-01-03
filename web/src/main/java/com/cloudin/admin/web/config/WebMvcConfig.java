package com.cloudin.admin.web.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by YFHan on 2017/1/3 0003.
 */
@Configurable
@EnableWebMvc
@ComponentScan(basePackages = "com.cloudin.admin.web")
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    public WebMvcConfig() {
        System.out.println(this.getClass().getName());
    }


    /**
     * freemarker 框架配置
     *
     * @return
     */
    @Bean
    public FreeMarkerConfigurer getFreeMarkerConfigurer() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("/WEB-INF/view/");
        configurer.setDefaultEncoding("UTF-8");

        Properties setting = new Properties();
        try {
            setting.load(getClass().getResourceAsStream("/freemarker.properties"));
            Enumeration<String> enumeration = (Enumeration<String>) setting.propertyNames();
            while (enumeration.hasMoreElements()){
                String k = enumeration.nextElement();
                System.out.println(k + " : " + setting.getProperty(k));
            }

            HashMap<String,Object> freemarkerVars = new LinkedHashMap<>();
            Properties vars = new Properties();
            vars.load(getClass().getResourceAsStream("/freemarker-vars.properties"));
            Enumeration<String> varsEnum = (Enumeration<String>) vars.propertyNames();
            while (varsEnum.hasMoreElements()){
                String k = varsEnum.nextElement();
                System.out.println(k + " : " + vars.getProperty(k));
                freemarkerVars.put(k, vars.getProperty(k));
            }
            configurer.setFreemarkerVariables(freemarkerVars);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        configurer.setFreemarkerSettings(setting);
        return configurer;
    }

    /**
     * 视图解析器配置
     *
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.freeMarker().cache(false).suffix(".ftl");
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setSuffix(".ftl");
        freeMarkerViewResolver.setCache(true);
        freeMarkerViewResolver.setContentType("text/html; charset=UTF-8");
        registry.viewResolver(freeMarkerViewResolver);
//        registry.tiles().prefix("/WEB-INF/tiles/").suffix(".tile");
//        registry.jsp().prefix("/WEB-INF/view/").suffix(".jsp");
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
     * 消息转换器配置
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
        jsonConverter.setSupportedMediaTypes(new ArrayList<MediaType>(){
            {
                add(MediaType.APPLICATION_JSON);
                add(MediaType.APPLICATION_JSON_UTF8);
            }
        });
        converters.add(jsonConverter);
    }




}