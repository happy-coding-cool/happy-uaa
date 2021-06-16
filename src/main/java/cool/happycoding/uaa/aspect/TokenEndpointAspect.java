package cool.happycoding.uaa.aspect;

import cool.happycoding.code.base.result.BaseResult;
import cool.happycoding.uaa.common.constants.HappyAuthConstants;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.Map;

import static cool.happycoding.code.base.util.HappyCodeUtil.check;
import static cool.happycoding.uaa.common.status.HappyAuthStatus.INSUFFICIENT_ERROR;

/**
 * <p>
 *     统一token返回样式
 * </p>
 *
 * @author pengzhenchen 2021/06/16 9:04 上午
 */
@Aspect
@Component
@SuppressWarnings("all")
public class TokenEndpointAspect {

    @Around("execution(* org.springframework.security.oauth2.provider.endpoint.TokenEndpoint.postAccessToken(..))")
    public Object handleControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();
        Principal principal = (Principal) args[0];
        check(!(principal instanceof Authentication),INSUFFICIENT_ERROR);
        Map<String, String> parameters = (Map<String, String>) args[1];
        String grantType = parameters.get(OAuth2Utils.GRANT_TYPE);
        Object proceed = joinPoint.proceed();
        if (HappyAuthConstants.AUTHORIZATION_CODE.equals(grantType)) {
            // 对于使用了 @EnableOAuth2Sso 注解的情况，不能修改返回格式
            return proceed;
        } else {
            ResponseEntity<OAuth2AccessToken> responseEntity = (ResponseEntity<OAuth2AccessToken>) proceed;
            OAuth2AccessToken body = responseEntity.getBody();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(BaseResult.success(body));
        }

    }
}
