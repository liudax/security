package com.lss.core.validate.code.impl;

import com.lss.core.validate.code.ValidateCode;
import com.lss.core.validate.code.ValidateCodeGenerator;
import com.lss.core.validate.code.ValidateCodeProcessor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * @author Magic
 * @date 14:08 2017/11/14
 * @description
 */
public abstract class  AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor {


    /**
     * 操作session的工具类
     */
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    /**
     * spring常用开发技巧，依赖查找：收集系统中所有ValidateCodeGenerator接口的实现
     */
    @Autowired
    Map<String,ValidateCodeGenerator> validateCodeGeneratorMap;

    /**
     * 定义模版方法
     * @param request
     * @throws Exception
     */
    @Override
    public void create(ServletWebRequest request) throws Exception {
        C validateCode = generator(request);
        save(request,validateCode);
        send(request,validateCode);
    }

    /**
     * 生成校验码
     * @param request
     */
    public C generator(ServletWebRequest request){
        String type = getProcessorType(request);
        ValidateCodeGenerator validateCodeGenerator = validateCodeGeneratorMap.get(type+"CodeGenerator");
        return (C)validateCodeGenerator.generate(request);
    }

    public void save(ServletWebRequest request,C validateCode){
        sessionStrategy.setAttribute(request,SEESSION_KEY+getProcessorType(request).toUpperCase()
                ,validateCode);
    }



    /**
     * 发送校验码，由子类实现
     * @param request
     * @param validateCode
     * @throws Exception
     */
    public abstract void send(ServletWebRequest request,C validateCode) throws Exception;


    /**
     * 根据请求的url获取校验码的类型
     * @param request
     * @return
     */
    public String getProcessorType(ServletWebRequest request){
        return StringUtils.substringAfter(request.getRequest().getRequestURI(),"/code/");
    }
}
