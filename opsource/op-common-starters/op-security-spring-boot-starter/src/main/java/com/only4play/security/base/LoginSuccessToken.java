package com.only4play.security.base;

import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;

public class LoginSuccessToken extends AbstractAuthenticationToken {

    private final String token;
    @Getter
    private String username;

    public LoginSuccessToken(String token,String name) {
        super(AuthorityUtils.NO_AUTHORITIES);
        this.token = token;
        this.username = name;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }
}
