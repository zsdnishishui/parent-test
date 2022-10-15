package com.resource.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

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
@Primary
@Bean
public RemoteTokenServices remoteTokenServices(){
    final RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
//      设置/oauth/check_token端口
    remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:8083/oauth/check_token");
//      设置客户端信息
    remoteTokenServices.setClientId("client");
    remoteTokenServices.setClientSecret("secret");
    return remoteTokenServices;
}


//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/admin/**").hasRole("admin").anyRequest().authenticated()
//                ;
//    }
}