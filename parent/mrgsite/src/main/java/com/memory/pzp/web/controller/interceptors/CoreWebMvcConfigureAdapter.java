package com.memory.pzp.web.controller.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by wall on 2017/9/15.
 */

/***
 * springmvc配置对象
 */
//@Component
public class CoreWebMvcConfigureAdapter extends WebMvcConfigurerAdapter{

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginCheckInterceptors()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
