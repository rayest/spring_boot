package com.rayeston.security;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by lirui on 2017/10/3.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String username = "rayest";
    private static final String password = "123456";
    private static final String user_role = "USER";
    private static final String admin = "admin";
    private static final String admin_password = "111111";
    private static final String admin_role = "ADMIN";

    @Bean
    public UserDetailsService securityUserService(){
        return new SecurityUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser(username).password(password).roles(user_role)
//        .and().withUser(admin).password(admin_password).roles(admin_role);
        auth.userDetailsService(securityUserService()); // 从数据库中处理用户和角色
    }

    @ApiOperation("配置安全策略")
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/zooKeeper", "/").permitAll() //不需要验证
//                .antMatchers("/", "/security/hello").permitAll() //不需要验证
                .anyRequest().authenticated() // 除"/," 和 "/security/hello"外，都需要验证
                .and()
                .logout().permitAll() // 退出不需要验证
                .and()
                .formLogin(); // 使用form表单验证
        httpSecurity.csrf().disable(); // 如果为403错误，尝试设置该步，以禁止CSRF验证
    }

}
