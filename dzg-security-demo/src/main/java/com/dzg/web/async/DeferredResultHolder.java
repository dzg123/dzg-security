package com.dzg.web.async;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: dzg-security
 * @description: 线程共享holder
 * @author: dzg
 * @create: 2019-02-09 14:39
 **/
@Component
public class DeferredResultHolder {
    private @Getter
    @Setter
    Map<String, DeferredResult<String>> map = new HashMap<>();
}
