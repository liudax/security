package com.lss.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Magic
 * @date 14:22 2017/11/8
 * @description
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
