package com.dzg.web.async;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * @program: dzg-security
 * @description: 异步处理restAPI控制器
 * @author: dzg
 * @create: 2019-02-09 13:38
 **/
@RestController
@Slf4j

public class AsyncController {
    @Autowired
    private MockQueue mockQueue;
    @Autowired
    private DeferredResultHolder resultHolder;

    @RequestMapping("/order")
    @ApiOperation("异步请求服务")
    public DeferredResult<String> order() {
        log.info("主线程开始");
        String orderNumber = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNumber);
        DeferredResult<String> deferredResult = new DeferredResult<>();
        resultHolder.getMap().put(orderNumber, deferredResult);
//           Callable<String> result = (() ->{
//                log.info("副线程开始");
//                Thread.sleep(1000);
//               log.info("副线程结束");
//                return "success";
//            });
        log.info("主线程结束");
        return deferredResult;


    }
}
