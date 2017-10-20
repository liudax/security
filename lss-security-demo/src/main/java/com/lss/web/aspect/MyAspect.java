package com.lss.web.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author Magic
 * @date 18:07 2017/10/16
 * @description
 */
@Aspect
//@Component
public class MyAspect {

    private Logger logger = Logger.getLogger(MyAspect.class);


    @Around("execution(* com.lss.web.controller.AsyncController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("方法执行前");
        Object obj = pjp.proceed();
        logger.info("方法执行后");
        return obj;
    }
}
