package com.dzg.config;

//import com.dzg.web.filter.TimeFilter;
import com.dzg.web.filter.TimeFilter;
import com.dzg.web.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;
import java.util.ArrayList;

/**
 * @program: dzg-security
 * @description: WebConfig
 * @author: dzg
 * @create: 2019-02-04 12:38
 **/
//@Configuration
public class WebConfig implements WebMvcConfigurer{
    @Autowired
    private TimeInterceptor timeInterceptor;
    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new TimeFilter());
        ArrayList<String> urls = new ArrayList<>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);
        return registrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//        configurer.setTaskExecutor()
    }
}
