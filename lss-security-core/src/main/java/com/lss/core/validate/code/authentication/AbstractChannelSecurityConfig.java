package com.lss.core.validate.code.authentication;

import com.lss.core.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author Magic
 * @date 14:00 2017/11/24
 * @description
 */
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler lssAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler lssAuthenticationFailureHandler;

    protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(lssAuthenticationSuccessHandler)
                .failureHandler(lssAuthenticationFailureHandler);
    }
}
