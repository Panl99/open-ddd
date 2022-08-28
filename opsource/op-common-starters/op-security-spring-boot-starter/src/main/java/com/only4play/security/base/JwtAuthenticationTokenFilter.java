package com.only4play.security.base;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * token 拦截器，加入上下文参数 user-agent ，也可以加入其它的扩展
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    public static final String HEADER_TOKEN_NAME = "token";
    public static final String USER_AGENT = "user-agent";
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authorization = request.getHeader(HEADER_TOKEN_NAME);
        String userAgent = request.getHeader(USER_AGENT);
        /**
         * auth /public 开头的请求不再做token 过滤，前端传也不处理，防止传参之后进行验证
         */
        List<AntPathRequestMatcher> list = Lists.newArrayList();
        list.add(new AntPathRequestMatcher("/auth/**"));
        list.add(new AntPathRequestMatcher("/public/**"));
        boolean match = false;
        for(AntPathRequestMatcher ant : list){
            if(ant.matches(request)){
                match = true;
            }
        }
        if (!Strings.isNullOrEmpty(authorization) && !match) {
            JwtAuthToken token = new JwtAuthToken(authorization);
            token.setUserAgent(userAgent);
            SecurityContextHolder.getContext().setAuthentication(token);
        }
        chain.doFilter(request, response);
    }
}
