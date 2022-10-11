package com.sso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration
@EnableResourceServer
public class OauthResourceConfig extends ResourceServerConfigurerAdapter {
//    @Autowired
//    private DataSource dataSource;
//
//    /**
//     * 指定token的持久化策略
//     * 其下有   RedisTokenStore保存到redis中，
//     * JdbcTokenStore保存到数据库中，
//     * InMemoryTokenStore保存到内存中等实现类，
//     * 这里我们选择保存在数据库中
//     *
//     * @return
//     */
//    @Bean
//    public TokenStore jdbcTokenStore() {
//        return new JdbcTokenStore(dataSource);
//    }

    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("product_api");//指定保存token的方式
    }

    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/base/**").hasRole("admin").anyRequest().authenticated()
                ;
    }
}