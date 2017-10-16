package com.lss.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Magic
 * @date 16:18 2017/10/16
 * @description
 */
@Component
public class CrossFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse)response;
        System.out.println("进入CrossFilter");
        res.setHeader("Access-Control-Allow-Origin","*");
        res.setHeader("Access-Control-Allow-Methods","*");
        res.setHeader("Access-Control-Max-Age", "3600");
        res.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
        res.setHeader("Access-Control-Allow-Credentials", "true");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
