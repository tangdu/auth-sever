package com.tdu.sever;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * TODO: detail description
 *
 * @author tangdu
 * @version $: ServerSecurityConfig.java, v 0.1 2018年01月2018/1/1日 下午4:40 tangdu Exp $
 * @name TODO: ServerSecurityConfig
 */
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("admins");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login","/index").permitAll()
                .anyRequest().authenticated()
                //.and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
                .and().csrf()
                //.requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/authorize"))
                //.csrfTokenRepository(csrfTokenRepository()).and()
                //.addFilterAfter(csrfHeaderFilter(), CsrfFilter.class)
                .disable()
//                .addFilterAfter(oauth2ClientContextFilter, OAuth2ClientAuthenticationProcessingFilter.class)
                .formLogin().permitAll();
        http.logout().permitAll();
    }
}
