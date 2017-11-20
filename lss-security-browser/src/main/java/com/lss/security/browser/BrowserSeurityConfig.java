package com.lss.security.browser;

import com.lss.core.properties.SecurityProperties;
import com.lss.core.validate.code.ValidateFilter;
import com.lss.security.browser.authentication.LssAuthenticationFailureHandler;
import com.lss.security.browser.authentication.LssAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @author Magic
 * @date 13:06 2017/10/21
 * @description
 */
@Configuration
public class BrowserSeurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private LssAuthenticationFailureHandler lssAuthenticationFailureHandler;

    @Autowired
    LssAuthenticationSuccessHandler lssAuthenticationSuccessHandler;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        //tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ValidateFilter validateFilter = new ValidateFilter();
        validateFilter.setAuthenticationFailureHandler(lssAuthenticationFailureHandler);
        validateFilter.setSecurityProperties(securityProperties);


        http.addFilterBefore(validateFilter, UsernamePasswordAuthenticationFilter.class)
             .formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(lssAuthenticationSuccessHandler)
                .failureHandler(lssAuthenticationFailureHandler)
                .and()
             .rememberMe()  //记住我功能
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(3600)
                .userDetailsService(userDetailsService)
             .and()
                .authorizeRequests()
                .antMatchers("/authentication/require",
                        securityProperties.getBrowser().getLoginPage(),
                        "/code/*")
                    .permitAll()
                .anyRequest()
                .authenticated()
             .and()
                .csrf().disable();
    }


    @Bean
    public PasswordEncoder  passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
