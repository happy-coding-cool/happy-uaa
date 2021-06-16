package cool.happycoding.uaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;

/**
 * description
 *
 * @author pengzhenchen 2021/06/16 9:25 上午
 */
@Configuration
public class ExceptionTranslatorConfig {

    @Bean
    public WebResponseExceptionTranslator<OAuth2Exception> webResponseExceptionTranslator(){
        return new HappyWebResponseExceptionTranslator();
    }

}
