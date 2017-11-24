package com.lss.core.validate.code.sms;

/**
 * @author Magic
 * @date 9:35 2017/11/14
 * @description
 */
public interface SmsCodeSender {

    /**
     * 向客户端发送验证码
     * @param mobile
     * @param code
     */
    void sender(String mobile, String code);
}
