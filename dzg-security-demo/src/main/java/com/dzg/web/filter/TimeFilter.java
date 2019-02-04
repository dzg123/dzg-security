package com.dzg.web.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * @program: dzg-security
 * @description: 时间过滤器
 * @author: dzg
 * @create: 2019-02-04 12:09
 **/
@Slf4j
//@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("time filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("filter start");
        long startTime = new Date().getTime();
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("consumingTime:{}",new Date().getTime()-startTime);
        log.info("filter end");
    }

    @Override
    public void destroy() {
        log.info("time filter destroy");
    }
}
