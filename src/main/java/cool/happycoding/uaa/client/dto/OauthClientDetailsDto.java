package cool.happycoding.uaa.client.dto;

import cool.happycoding.code.mybatis.base.BaseDTO;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 应用信息 前端展示对象
 * </p>
 *
 * @author happycoding
 * @since 2021-06-11
 */
@Data
@ApiModel(value="OauthClientDetailsDto对象", description="应用信息")
public class OauthClientDetailsDto extends BaseDTO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "应用标识")
    private String clientId;

    @ApiModelProperty(value = "应用密钥")
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

    @ApiModelProperty(value = "创建人姓名")
    private String createdBy;

    @ApiModelProperty(value = "创建人ID")
    private String createdById;

    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    @ApiModelProperty(value = "更新人姓名")
    private String updatedBy;

    @ApiModelProperty(value = "更新人ID")
    private String updatedById;

    @ApiModelProperty(value = "更新时间")
    private Date updatedTime;

}
