package com.cloudin.admin.web.config;

import com.alibaba.fastjson.JSON;
import com.cloudin.admin.web.lang.BaseResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * Created by YFHan on 2017/1/7 0007.
 */

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private Logger logger;

    public WebSecurityConfig() {
        super();
        logger = LogManager.getLogger(this);
        logger.info("init...");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        logger.info("configure AuthenticationManagerBuilder");
//        builder.inMemoryAuthentication()
//                .withUser("admin").password("123456").roles("ADMIN");
        builder.authenticationProvider(new AuthenticationProvider() {

            @Override
            public Authentication authenticate(Authentication auth) throws AuthenticationException {
                String username = auth.getName();
                String password = auth.getCredentials().toString();
                logger.debug("username:{}, password:{}", username, password);
                Authentication token = new UsernamePasswordAuthenticationToken(username, password, null);
                return token;
            }

            @Override
            public boolean supports(Class<?> authentication) {
                logger.debug(authentication.getClass().getName());
                return true;
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("configure HttpSecurity");
        http.authorizeRequests()
                .antMatchers("/echarts/**").permitAll()
                .antMatchers("/static/**", "/signin", "/signout", "/signup").permitAll()
//                .antMatchers("/town/**").hasRole("ADMIN")
                .anyRequest().authenticated()

                .and()
                .formLogin()
                .loginPage("/signin")
                .loginProcessingUrl("/signin-process")
                .failureHandler((request, response, exception) -> {
                    BaseResponse result = new BaseResponse();
                    result.markError(exception.getMessage());
                    response.getWriter().print(JSON.toJSONString(result));
                })
                .successHandler((request, response, authentication) -> {
                    BaseResponse result = new BaseResponse();
                    result.markSuccess();
                    response.getWriter().print(JSON.toJSONString(result));
                })
                .passwordParameter("password")
                .usernameParameter("username")
                .permitAll()

                .and()
                .logout()
                .logoutUrl("/signout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)

                .and()
                .headers().defaultsDisabled().frameOptions().sameOrigin().cacheControl();
        http.csrf().disable();

    }


}
