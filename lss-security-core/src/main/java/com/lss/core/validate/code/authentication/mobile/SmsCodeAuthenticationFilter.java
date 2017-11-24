package com.lss.core.validate.code.authentication.mobile;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Magic
 * @date 14:13 2017/11/23
 * @description
 */
public class SmsCodeAuthenticationFilter extends AbstractAuthenticationProcessingFilter {




    private String mobileParameter = "/authentication/mobile";
    private boolean postOnly = true;

    protected SmsCodeAuthenticationFilter() {
        super(new AntPathRequestMatcher("/authentication/mobile","POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        if(postOnly && !"POST".equals(request.getMethod())){
            throw new AuthenticationServiceException("Authentication method not supported:"+ request.getMethod());
        }

        String mobile = obtainMobile(request);
        SmsCodeAuthenticationToken authRequest = new SmsCodeAuthenticationToken(mobile);

        setDetails(request,authRequest);

        return  this.getAuthenticationManager().authenticate(authRequest);
    }

    protected void setDetails(HttpServletRequest request, SmsCodeAuthenticationToken authRequest) {
        authRequest.setDetails(request);
    }

    protected String obtainMobile(HttpServletRequest request) {
        return  request.getParameter(mobileParameter);
    }

    public String getMobileParameter() {
        return mobileParameter;
    }

    public void setMobileParameter(String mobileParameter) {
        this.mobileParameter = mobileParameter;
    }


    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }
}
