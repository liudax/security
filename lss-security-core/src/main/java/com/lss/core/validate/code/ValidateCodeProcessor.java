package com.lss.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author Magic
 * @date 14:05 2017/11/14
 * @description
 */
public interface ValidateCodeProcessor {

    /**
     * 验证码放入session时的前缀
     */
    String SEESSION_KEY = "SESSION_KEY_IMAGE_CODE";

    /**
     * 创建校验码
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;
}
