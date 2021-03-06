package cool.happycoding.uaa.common.status;

import cool.happycoding.code.base.common.ResultCode;

/**
 * description
 *
 * @author pengzhenchen 2021/06/16 9:13 上午
 */
public enum HappyAuthStatus implements ResultCode {

    /**
     * There is no client authentication. Try adding an appropriate authentication filter.
     */
    INSUFFICIENT_ERROR("insufficient-error","It is no client authentication"),
    /**
     * 账号或密码错误
     */
    BAD_CREDENTIALS("BAD-CREDENTIALS","用户名或密码错误");

    String code;
    String message;

    HappyAuthStatus(String code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
