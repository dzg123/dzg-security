package com.dzg.web.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @program: dzg-security
 * @description: 模拟队列
 * @author: dzg
 * @create: 2019-02-09 14:34
 **/
@Component
@Slf4j
public class MockQueue {
    private String placeOrder;
    private String completeOrder;

    public String getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder)  {
        new Thread(() -> {
            log.info("接到下单请求：{}", placeOrder);
            try {
                Thread.sleep(1000);
                this.completeOrder = placeOrder;
                log.info("下单请求处理完毕：{}", completeOrder);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
