package com.lss.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author Magic
 * @date 10:01 2017/11/9
 * @description
 */
public interface ValidateCodeGenerator {

    /**
     *生成验证码
     * @param request 封装之后的reques请求
     * @return
     *
     */
    ValidateCode generate(ServletWebRequest request);
}
