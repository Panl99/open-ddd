package com.only4play.security.exception;

import org.springframework.security.core.AuthenticationException;

public class MethodNotSupportException extends AuthenticationException {
    public MethodNotSupportException(String msg) {
        super(msg);
    }
}
