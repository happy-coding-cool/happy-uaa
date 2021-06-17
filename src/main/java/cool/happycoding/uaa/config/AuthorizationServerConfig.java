package cool.happycoding.uaa.config;

import cool.happycoding.uaa.client.HappyClientDetailsService;
import cool.happycoding.uaa.client.service.IOauthClientDetailsService;
import cool.happycoding.uaa.filter.HappyClientCredentialsTokenEndpointFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.ClientCredentialsTokenEndpointFilter;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * description
 *
 * @author lanlanhappy 2021/06/11 9:54 上午
 */
@Configuration
@RequiredArgsConstructor
@EnableAuthorizationServer
@AutoConfigureAfter(AuthorizationServerEndpointsConfigurer.class)
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final TokenStore tokenStore;

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final AuthenticationEntryPoint authenticationEntryPoint;
    private final IOauthClientDetailsService oauthClientDetailsService;
    private final WebResponseExceptionTranslator<OAuth2Exception> webResponseExceptionTranslator;

    /**
     * 配置身份认证器，配置认证方式，TokenStore，TokenGranter，OAuth2RequestFactory
     * 注入authenticationManager 来支持 password grant type
     * @param endpoints
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .exceptionTranslator(webResponseExceptionTranslator)
                .userDetailsService(userDetailsService);
    }

    /**
     * 配置应用名称 应用id
     * 配置OAuth2的客户端相关信息
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(new HappyClientDetailsService(oauthClientDetailsService, passwordEncoder));
    }

    /**
     * 对应于配置AuthorizationServer安全认证的相关信息，创建ClientCredentialsTokenEndpointFilter核心过滤器
     * @param security
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        // 让/oauth/token支持client_id以及client_secret作登录认证,同时自定义异常格式，重写ClientCredentialsTokenEndpointFilter
        ClientCredentialsTokenEndpointFilter clientCredentialsTokenEndpointFilter
                =  new HappyClientCredentialsTokenEndpointFilter(security, authenticationEntryPoint);
        clientCredentialsTokenEndpointFilter.setAuthenticationEntryPoint(authenticationEntryPoint);
        clientCredentialsTokenEndpointFilter.afterPropertiesSet();
        security.addTokenEndpointAuthenticationFilter(clientCredentialsTokenEndpointFilter);
        security
                .tokenKeyAccess("isAuthenticated()")
                .checkTokenAccess("permitAll()")
                .authenticationEntryPoint(authenticationEntryPoint)
        ;
    }


}
