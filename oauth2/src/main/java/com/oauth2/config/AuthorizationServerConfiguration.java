package com.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.annotation.Resource;
import java.util.Arrays;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    TokenStore tokenStore;
//    @Autowired
//    ClientDetailsService clientDetailsService;
    @Autowired
    JwtAccessTokenConverter jwtAccessTokenConverter;
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient("client")
                .secret(passwordEncoder.encode("secret"))
                .authorizedGrantTypes("authorization_code")
                .scopes("app")
                .redirectUris("http://www.baidu.com");

    }
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
//允许表单认证
        oauthServer.allowFormAuthenticationForClients();
        oauthServer.checkTokenAccess("permitAll()");
        // 所有人可访问 /oauth/token_key 后面要获取公钥, 默认拒绝访问
        oauthServer.tokenKeyAccess("permitAll()");

    }
    /**
     * 配置令牌的访问端点和令牌服务
     * 授权码和令牌有什么区别？授权码是用来获取令牌的，使用一次就失效，令牌则是用来获取资源的
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // 配置令牌的存储
        endpoints.tokenServices(this.tokenServices());
    }
    /**
     * 配置 Token 的一些基本信息
     */
    @Bean
    AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices services = new DefaultTokenServices();
//        services.setClientDetailsService(this.clientDetailsService);
        // 是否支持刷新
        services.setSupportRefreshToken(true);
        // 存储位置
        services.setTokenStore(this.tokenStore);
        // 有效期
        services.setAccessTokenValiditySeconds(60 * 60 * 1);
        // 刷新token的有效期 -- 当token块过期的时候，需要获取一个新的token，在获取新token的时候，需要一个凭证信息，这个凭证信息不是旧的 Token，而是另外一个 refresh_token，这个 refresh_token 也是有有效期的。
        services.setRefreshTokenValiditySeconds(60 * 60 * 24 * 3);

        // 注入“jwt添加额外信息”相关实例,此处很关键
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(this.jwtAccessTokenConverter));
        services.setTokenEnhancer(tokenEnhancerChain);

        return services;
    }
}
