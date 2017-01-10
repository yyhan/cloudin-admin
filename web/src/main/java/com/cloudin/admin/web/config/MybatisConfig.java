package com.cloudin.admin.web.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * mybatis配置文件
 * Created by YFHan on 2017/1/3 0003.
 */
@Configuration
public class MybatisConfig {

    private Logger logger;

    public MybatisConfig() {
        logger = LogManager.getLogger(this);
        logger.info("init...");
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource(Environment env) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.default.driver"));
        dataSource.setUrl(env.getProperty("db.default.url"));
        dataSource.setUsername(env.getProperty("db.default.username"));
        dataSource.setPassword(env.getProperty("db.default.password"));
        return dataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean getSqlSessionFactory(DataSource dataSource) {
        Resource resource = new ClassPathResource("/mybatis-config.xml");
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setConfigLocation(resource);
        return factory;
    }

    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.cloudin.admin.dao.api");
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return configurer;
    }
}
