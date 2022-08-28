package com.only4play.system.infrastructure.security.authentication.admin.sms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.only4play.security.base.CustomAuthenticationFailureHandler;
import com.only4play.security.base.CustomAuthenticationSuccessHandler;
import com.only4play.security.config.AuthErrorMsg;
import com.only4play.security.exception.MethodNotSupportException;
import com.only4play.system.infrastructure.security.AuthUrlEnum;
import java.io.IOException;
import java.util.Collections;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

/**
 * 后台登录用户拦截器 ，组装登录请求，并提交给认证中心
 */
@Slf4j
public class AdminSmsLoginProcessFilter extends AbstractAuthenticationProcessingFilter {

    private final CustomAuthenticationFailureHandler failureHandler;

    private final CustomAuthenticationSuccessHandler successHandler;

    public AdminSmsLoginProcessFilter(AuthenticationManager authenticationManager,
        CustomAuthenticationFailureHandler failureHandler,
        CustomAuthenticationSuccessHandler successHandler) {
        super(AuthUrlEnum.ADMIN_SMS.getUrl(),authenticationManager);
        this.failureHandler = failureHandler;
        this.successHandler = successHandler;
    }



    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException {
//        log.info("前端请求url:{}，uri:{}", request.getRequestURL(), request.getRequestURI());
        checkMethod(request);
        ObjectMapper mapper = new ObjectMapper();
        AdminSmsAuthRequest loginRequest = mapper.readValue(request.getReader(),
            AdminSmsAuthRequest.class);
        AdminSmsToken token = new AdminSmsToken(loginRequest.getPhone(), loginRequest.getVerifyCode(), Collections.emptyList());
        return this.getAuthenticationManager().authenticate(token);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
        Authentication authResult) throws IOException {
        successHandler.onAuthenticationSuccess(request, response, authResult);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
        AuthenticationException failed) throws IOException, ServletException {
        SecurityContextHolder.clearContext();
        failureHandler.onAuthenticationFailure(request, response, failed);
    }

    public void checkMethod(HttpServletRequest request){
        if (!HttpMethod.POST.name().equals(request.getMethod())) {
            throw new MethodNotSupportException(AuthErrorMsg.methodNotSupport.getName());
        }
    }


}
