package com.lss.core.validate.code;

import com.lss.core.properties.SecurityProperties;
import com.lss.core.validate.code.image.ImageCodeGenerator;
import com.lss.core.validate.code.sms.DefaultSmsCodeSender;
import com.lss.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Magic
 * @date 10:20 2017/11/9
 * @description
 */
@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 增量的方式：当容器中有名为imageCodeGenerator的bean时，直接用容器中的。 没有的时候，才用该方法生成的
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(name="imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator(){
        ImageCodeGenerator imageCodeGenerator = new ImageCodeGenerator();
        imageCodeGenerator.setSecurityProperties(securityProperties);
        return imageCodeGenerator;
    }


    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender(){
        return new DefaultSmsCodeSender();
    }
}
