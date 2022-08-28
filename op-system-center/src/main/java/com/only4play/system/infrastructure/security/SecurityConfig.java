package com.only4play.system.infrastructure.security;

import com.alibaba.nacos.common.utils.HttpMethod;
import com.only4play.security.base.CustomAuthenticationFailureHandler;
import com.only4play.security.base.CustomAuthenticationSuccessHandler;
import com.only4play.security.base.JwtAuthenticationEntryPoint;
import com.only4play.security.base.JwtAuthenticationProvider;
import com.only4play.security.base.JwtAuthenticationTokenFilter;
import com.only4play.security.config.SecurityCommonProperties;
import com.only4play.system.infrastructure.security.authentication.admin.password.AdminPasswordAuthenticationProvider;
import com.only4play.system.infrastructure.security.authentication.admin.password.AdminPasswordLoginProcessFilter;
import com.only4play.system.infrastructure.security.authentication.admin.sms.AdminSmsAuthenticationProvider;
import com.only4play.system.infrastructure.security.authentication.admin.sms.AdminSmsLoginProcessFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@ComponentScan(value = {"com.only4play.security.base", "com.only4play.security.config"})
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private SecurityCommonProperties commonProperties;

  @Autowired
  private JwtAuthenticationEntryPoint unauthorizedHandler;

  @Autowired
  private JwtAuthenticationProvider jwtAuthenticationProvider;

  @Autowired
  private AdminPasswordAuthenticationProvider adminPasswordProvider;

  @Autowired
  private AdminSmsAuthenticationProvider adminSmsAuthenticationProvider;

  @Autowired
  private CustomAuthenticationFailureHandler failureHandler;

  @Autowired
  private CustomAuthenticationSuccessHandler successHandler;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(jwtAuthenticationProvider);
    auth.authenticationProvider(adminPasswordProvider);
    auth.authenticationProvider(adminSmsAuthenticationProvider);
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
    return new JwtAuthenticationTokenFilter();
  }

  public AdminPasswordLoginProcessFilter adminPassFilter() {
    return new AdminPasswordLoginProcessFilter(authenticationManager, failureHandler, successHandler);
  }

  public AdminSmsLoginProcessFilter smsFilter(){
    return new AdminSmsLoginProcessFilter(authenticationManager, failureHandler, successHandler);
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
        .antMatchers("/trace/users/**").permitAll()
        // swagger start
        .antMatchers("/swagger-ui.html").permitAll()
        .antMatchers("/swagger-ui/**").permitAll()
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
        .addFilterBefore(adminPassFilter(), UsernamePasswordAuthenticationFilter.class)
        .addFilterBefore(smsFilter(), UsernamePasswordAuthenticationFilter.class)
        .addFilterBefore(authenticationTokenFilterBean(),
            UsernamePasswordAuthenticationFilter.class);

    httpSecurity.headers().cacheControl();
  }
}
