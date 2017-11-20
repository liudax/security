package com.lss.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Magic
 * @date 14:34 2017/11/3
 * @description
 */
@ConfigurationProperties(prefix = "lss.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

   private ValidateCodeProperties  code = new ValidateCodeProperties();

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
