package com.dzg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: dzg-security
 * @description: 启动类
 * @author: dzg
 * @create: 2019-01-29 12:12
 **/
@SpringBootApplication
//@ComponentScan(basePackages = {"com.dzg.security","com.dzg.security.config","com.dzg.security.properties"})
@RestController
@EnableSwagger2
//@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }
}
