package com.lss.web.controller;

import com.lss.web.aysnc.DeferredResultHolder;
import com.lss.web.aysnc.MockQueue;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author Magic
 * @date 16:52 2017/10/18
 * @description
 */
@RestController
public class AsyncController {

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    DeferredResultHolder deferredResultHolder;

    private Logger logger = LoggerFactory.getLogger(AsyncController.class);

    @RequestMapping("/async")
    public DeferredResult<String> getMsg(){

        logger.info("主线程开始");
        String order = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(order);
        DeferredResult<String> deferredResult = new DeferredResult<>();
        deferredResultHolder.getMap().put(order,deferredResult);


       /* Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info("副线程开始");
                Thread.sleep(1000);
                logger.info("副线程结束");
                return "success";
            }
        };*/
        logger.info("主线程结束");
        return deferredResult;
    }
}
