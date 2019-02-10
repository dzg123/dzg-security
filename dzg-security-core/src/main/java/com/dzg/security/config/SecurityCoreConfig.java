package com.dzg.security.config;

import com.dzg.security.properties.BrowserProperties;

import com.dzg.security.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: dzg-security
 * @description:
 * @author: dzg
 * @create: 2019-02-07 20:38
 **/
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
    @Bean
    public BrowserProperties browserProperties(){
        return new BrowserProperties();
    }
}
