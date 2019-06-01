package com.binzikeji.itoken.common.web.config;

import com.binzikeji.itoken.common.web.interceptor.Constantslnterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description
 * @Author Bin
 * @Date 2019/4/17 15:37
 **/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Constantslnterceptor()).addPathPatterns("/**");
    }
}
