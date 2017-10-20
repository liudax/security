package com.lss.web.aysnc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 模拟消息队列
 *
 * @author Magic
 * @date 19:39 2017/10/18
 * @description
 */
@Component
public class MockQueue {
    private String placeOrder;
    private String completeOrder;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public String getPlaceOrder() {
        return placeOrder;
    }

    /**
     * 模拟下单请求
     * @param placeOrder
     */
    public void setPlaceOrder(String placeOrder) {
        new Thread(()->{
            logger.info("接到下单请求");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            completeOrder = placeOrder;
            logger.info("订单处理完成");
        }).start();

        this.placeOrder = placeOrder;
    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
