package com.dzg.web.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @program: dzg-security
 * @description: time切面
 * @author: dzg
 * @create: 2019-02-04 22:33
 **/
@Aspect
@Component
@Slf4j
public class TimeAspect {
    @Around("execution(* com.dzg.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("timeAspect start");
        Object proceed = joinPoint.proceed();
        Object[] args = joinPoint.getArgs();
        for(Object arg :args){
            log.info("arg:{}",arg);
        }
        log.info("timeAspect end");
        return proceed;

    }
}
