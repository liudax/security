package com.lss.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Magic
 * @date 17:32 2017/10/16
 * @description
 */
@Component
public class MyInterceptor implements HandlerInterceptor {


    /**
     * 控制器调用之前调用该方法
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
        System.out.println(((HandlerMethod)handler).getMethod().getName());

        request.setAttribute("start",System.currentTimeMillis());
        System.out.println("preHandle");
        return true;
    }

    /**
     * 控制器返回之后调用该方法，如果控制器中抛出异常，则不会调用
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("postHandle");
        long start = Long.valueOf(request.getAttribute("start").toString());
        System.out.println("执行controller耗时:"+(System.currentTimeMillis() - start));
    }


    /**
     * 该方法无论抛没抛异常都会执行
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("afterCompletion");
    }
}
