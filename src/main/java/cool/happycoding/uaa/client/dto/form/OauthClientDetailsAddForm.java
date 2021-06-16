package cool.happycoding.uaa.client.dto.form;

import cool.happycoding.code.mybatis.base.BaseForm;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 应用信息 新增
 * </p>
 *
 * @author happycoding
 * @since 2021-06-11
 */
@Data
@ApiModel(value="OauthClientDetailsAddForm对象", description="应用信息新增")
public class OauthClientDetailsAddForm extends BaseForm {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "应用标识")
    @NotBlank
    private String clientId;

    @ApiModelProperty(value = "应用密钥")
    @NotBlank
    private String clientSecret;

    @ApiModelProperty(value = "资源标识")
    private String resourceIds;

    @ApiModelProperty(value = "授权范围")
    private String scope;

    @ApiModelProperty(value = "5种oauth授权方式(authorization_code,password,refresh_token,client_credentials)")
    private String authorizedGrantTypes;

    @ApiModelProperty(value = "回调地址")
    private String webServerRedirectUri;

    @ApiModelProperty(value = "权限")
    private String authorities;

    @ApiModelProperty(value = "access_token有效期")
    private Integer accessTokenValidity;

    @ApiModelProperty(value = "refresh_token有效期")
    private Integer refreshTokenValidity;

    @ApiModelProperty(value = "{}")
    private String additionalInformation;

    @ApiModelProperty(value = "是否自动授权 是-true")
    private String autoapprove;

}