package com.only4play.security.auto;

import com.only4play.security.base.JwtAuthenticationEntryPoint;
import com.only4play.security.base.JwtAuthenticationProvider;
import com.only4play.security.base.JwtAuthenticationTokenFilter;
import com.only4play.security.base.extension.DummyUserContextAware;
import com.only4play.security.base.extension.UserContextAware;
import com.only4play.security.config.SecurityCommonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.web.cors.CorsUtils;

/**
 * spring security 配置类 自动注入JwtAuthenticationProvider
 * 此类主要给客户端使用 -> 客户端不再处理登录，只需要关注token 即可
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private JwtAuthenticationEntryPoint unauthorizedHandler;

  @Autowired
  private JwtAuthenticationProvider jwtAuthenticationProvider;

  @Autowired
  private SecurityCommonProperties commonProperties;

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(jwtAuthenticationProvider);
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
    return new JwtAuthenticationTokenFilter();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    super.configure(web);
    web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources",
        "/configuration/security", "/swagger-ui.html", "/webjars/**")
        .antMatchers(HttpMethod.GET,
            "/",
            "/*.html",
            "/favicon.ico",
            "/**/*.html", "/**/*.css",
            "/**/*.js");
  }

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.requiresChannel()
        .anyRequest().requiresInsecure()
        .and()
        .csrf().disable()//csrf取消
        .cors().disable()
        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
        .and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()//不再存储session
        .headers().frameOptions().disable()
        .and()
        .headers().addHeaderWriter(
        new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
        .and()
        .authorizeRequests()
        .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
        .antMatchers(HttpMethod.OPTIONS).permitAll()
        .antMatchers(HttpMethod.GET,
            "/",
            "/*.html",
            "/favicon.ico",
            "/**/*.html", "/**/*.css",
            "/**/*.js").permitAll()
        .antMatchers("/swagger-ui.html").permitAll()
        .antMatchers("/swagger-resources/**").permitAll()
        .antMatchers("/images/**").permitAll()
        .antMatchers("/webjars/**").permitAll()
        .antMatchers("/v2/api-docs").permitAll()
        .antMatchers("/configuration/ui").permitAll()
        .antMatchers("/configuration/security").permitAll()
        .antMatchers("/auth/**").permitAll()
        .antMatchers("/public/**").permitAll()
        .antMatchers(commonProperties.getUnAuthUrls()
            .toArray(new String[commonProperties.getUnAuthUrls().size()])).permitAll()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .anyRequest().authenticated();

    httpSecurity
        .addFilterBefore(authenticationTokenFilterBean(),
            UsernamePasswordAuthenticationFilter.class);
    httpSecurity.headers().cacheControl();
  }
}
