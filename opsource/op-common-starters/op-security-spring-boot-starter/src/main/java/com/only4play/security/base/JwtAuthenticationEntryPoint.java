package com.only4play.security.base;

import com.only4play.security.util.HandleHttpErrorUtil;
import java.io.IOException;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException e) throws IOException {
        //response.sendError(HttpStatus.UNAUTHORIZED.value(), "Unauthorized");
        try{
            HandleHttpErrorUtil.handleHttpError(request,response,e);
        }catch (Exception throwable){
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Unauthorized");
        }
    }
}