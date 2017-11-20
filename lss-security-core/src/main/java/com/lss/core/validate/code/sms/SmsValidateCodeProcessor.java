package com.lss.core.validate.code.sms;

import com.lss.core.validate.code.ValidateCode;
import com.lss.core.validate.code.impl.AbstractValidateCodeProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author Magic
 * @date 14:20 2017/11/14
 * @description
 */
@Component
public class SmsValidateCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode>{

    private SmsCodeSender smsCodeSender;

    @Override
    public void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
        String mobile =ServletRequestUtils.getRequiredStringParameter(request.getRequest(),"mobile");
        smsCodeSender.sender(mobile,validateCode.getCode());
    }
}
