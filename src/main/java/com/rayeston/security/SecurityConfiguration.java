package com.rayeston.security;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by lirui on 2017/10/3.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String username = "ray";
    private static final String password = "123456";
    private static final String user_role = "USER";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser(username).password(password).roles(user_role);
    }

    @ApiOperation("配置安全策略")
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/", "/security/hello").permitAll() //不需要验证
                .anyRequest().authenticated() // 除"/," 和 "/security/hello"外，都需要验证
                .and()
                .logout().permitAll() // 退出不需要验证
                .and()
                .formLogin(); // 使用form表单验证
    }

}
