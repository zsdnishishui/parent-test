package com.sso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //匿名用户访问无权限资源时的异常
    @Autowired
    CustomizeAuthenticationEntryPoint authenticationEntryPoint;
    //登录成功处理逻辑
    @Autowired
    CustomizeAuthenticationSuccessHandler authenticationSuccessHandler;

    //登录失败处理逻辑
    @Autowired
    CustomizeAuthenticationFailureHandler authenticationFailureHandler;
    //实现权限拦截
//    @Autowired
//    CustomizeFilterInvocationSecurityMetadataSource securityMetadataSource;

//    @Autowired
//    private CustomizeAbstractSecurityInterceptor securityInterceptor;
    @Bean
    public UserDetailsService userDetailsService() {
        //获取用户账号密码及权限信息
        return super.userDetailsService();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 设置默认的加密方式（强hash方式加密）
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //配置认证方式
//        auth.userDetailsService(userDetailsService());
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("123456")).roles("admin");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http相关的配置，包括登入登出、异常处理、会话管理等
        // 关闭csrf(前后端分离项目要关闭此功能）
        http.csrf().disable();
        http
                .authorizeRequests()
                    .antMatchers("/base/hello").permitAll()
//                .antMatchers("/oauth/**").permitAll()
//                    .antMatchers("/base/getUser").hasAuthority("modify_user")//需要權限
                // 任意用户，认证之后才可以访问（除上面外的）
                        .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .permitAll()
                    .successHandler(authenticationSuccessHandler)//登录成功处理逻辑
                    .failureHandler(authenticationFailureHandler)//登录失败处理逻辑
                    .and()
                .logout()
                    .permitAll()
                    .and();

                //异常处理(权限拒绝、登录失效等)
                http.exceptionHandling()
                    .authenticationEntryPoint(authenticationEntryPoint);//匿名用户访问无权限资源时的异常处理

//        http.addFilterBefore(securityInterceptor, FilterSecurityInterceptor.class);
        // spring security 允许跨域
        http.cors();
    }
    //AuthenticationManager对象在OAuth2认证服务中要使用，提取放入IOC容器中
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


}
