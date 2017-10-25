package com.lss.security.browser;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Magic
 * @date 13:06 2017/10/21
 * @description
 */
@Configuration
public class BrowserSeurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.formLogin()
                http.httpBasic()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }
}
