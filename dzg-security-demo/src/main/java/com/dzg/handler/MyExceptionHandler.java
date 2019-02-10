package com.dzg.handler;

import com.dzg.exception.UserNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: dzg-security
 * @description: 异常处理类
 * @author: dzg
 * @create: 2019-02-03 15:23
 **/
@ControllerAdvice
@Slf4j
public class MyExceptionHandler {
    //    @ExceptionHandler(UserNotExistException.class)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public Map<String,Object> UserNotExistExceptionHandler(UserNotExistException ex){
//        HashMap<String, Object> result = new HashMap<>();
//        result.put("id", ex.getId());
//        result.put("message", ex.getMessage());
//        return result;
//    }
    @ExceptionHandler(UserNotExistException.class)
    public String UserNotExistExceptionHandler(UserNotExistException ex, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", ex.getId());
        result.put("message", ex.getMessage());
        request.setAttribute("javax.servlet.error.status_code",500);
        return "forward:/error";
    }
    @ExceptionHandler(NullPointerException.class)
    public void NullPointerExceptionHandler(NullPointerException ex){
        log.info("空指针异常:{}",ex.getStackTrace());

    }
}
