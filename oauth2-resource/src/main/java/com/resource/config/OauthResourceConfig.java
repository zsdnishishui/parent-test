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
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.annotation.Resource;

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
@Resource
TokenStore tokenStore;

//    @Primary
//@Bean
//public RemoteTokenServices remoteTokenServices(){
//    final RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
////      设置/oauth/check_token端口
//    remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:8083/oauth/check_token");
////      设置客户端信息
//    remoteTokenServices.setClientId("client");
//    remoteTokenServices.setClientSecret("secret");
//    return remoteTokenServices;
//}

    /**
     * 自动调用 JwtAccessTokenConverter 将 jwt 解析出来，jwt 里边就包含了用户的基本信息，所以就不用上面一样远程校验 access_token 了。
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(this.tokenStore);
    }
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/admin/**").hasRole("admin").anyRequest().authenticated()
//                ;
//    }
}