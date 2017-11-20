package com.lss.core.validate.code.sms;

import org.springframework.stereotype.Component;

/**
 * @author Magic
 * @date 9:35 2017/11/14
 * @description
 */
@Component
public class DefaultSmsCodeSender implements SmsCodeSender {

    @Override
    public void sender(String mobile, String code) {
        System.out.println("向手机"+mobile+"发送验证码："+code);
    }
}
