package cool.happycoding.uaa.config;

import cn.hutool.core.util.ObjectUtil;
import cool.happycoding.code.base.result.Result;
import cool.happycoding.code.web.exception.ErrorDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.common.exceptions.UnsupportedResponseTypeException;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * description
 *
 * @author pengzhenchen 2021/06/16 9:24 上午
 */
@Slf4j
public class HappyWebResponseExceptionTranslator extends DefaultWebResponseExceptionTranslator{

    private static final String BAD_MSG = "坏的凭证";
    private static final String BAD_MSG_EN = "Bad credentials";

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {

        OAuth2Exception oAuth2Exception;
        if (checkPwd(e)) {
            oAuth2Exception = new InvalidGrantException("用户名或密码错误", e);
        } else if (e instanceof InternalAuthenticationServiceException) {
            oAuth2Exception = new InvalidGrantException(e.getMessage(), e);
        } else if (e instanceof OAuth2Exception) {
            oAuth2Exception = (OAuth2Exception)e;
        } else {
            oAuth2Exception = new UnsupportedResponseTypeException("服务内部错误", e);
        }
        log.debug("认证失败", oAuth2Exception);
        ResponseEntity<OAuth2Exception> response = super.translate(oAuth2Exception);
        String path = null;
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (ObjectUtil.isNotNull(requestAttributes)) {
            HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
            path = request.getRequestURI();
        }
        ResponseEntity.status(oAuth2Exception.getHttpErrorCode());
        Result result = ErrorDetail.error(oAuth2Exception.getOAuth2ErrorCode(),
                oAuth2Exception.getMessage(), path);
        return new ResponseEntity(result, response.getStatusCode());
    }

    private boolean checkPwd(Exception exception) {
        return exception.getMessage() != null
                && (BAD_MSG.equals(exception.getMessage())
                || BAD_MSG_EN.equals(exception.getMessage()));
    }
}
