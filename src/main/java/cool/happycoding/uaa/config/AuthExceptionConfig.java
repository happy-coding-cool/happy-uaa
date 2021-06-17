package cool.happycoding.uaa.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.annotation.Resource;

/**
 * description
 *
 * @author pengzhenchen 2021/06/16 9:25 上午
 */
@Configuration
public class AuthExceptionConfig {

    @Resource
    private ObjectMapper objectMapper;

    /**
     * 获取token失败，异常格式处理
     * @return
     */
    @Bean
    public WebResponseExceptionTranslator<OAuth2Exception> webResponseExceptionTranslator(){
        return new HappyWebResponseExceptionTranslator();
    }

    /**
     * token无效，或client校验非法，异常格式处理
     * @return
     */
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new HappyAuthenticationEntryPoint(objectMapper);
    }

}
