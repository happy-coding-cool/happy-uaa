package cool.happycoding.uaa.client.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import cool.happycoding.code.mybatis.base.BaseEntity;
import cool.happycoding.uaa.client.HappyClientDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.oauth2.provider.ClientDetails;

/**
 * <p>
 * 应用信息
 * </p>
 *
 * @author happycoding
 * @since 2021-06-11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("oauth_client_details")
public class OauthClientDetails extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 应用标识
     */
    @TableField("client_id")
    private String clientId;

    /**
     * 应用密钥
     */
    @TableField("client_secret")
    private String clientSecret;

    /**
     * 资源标识
     */
    @TableField("resource_ids")
    private String resourceIds;

    /**
     * 授权范围
     */
    @TableField("scope")
    private String scope;

    /**
     * 5种oauth授权方式(authorization_code,password,refresh_token,client_credentials)
     */
    @TableField("authorized_grant_types")
    private String authorizedGrantTypes;

    /**
     * 回调地址
     */
    @TableField("web_server_redirect_uri")
    private String webServerRedirectUri;

    /**
     * 权限
     */
    @TableField("authorities")
    private String authorities;

    /**
     * access_token有效期
     */
    @TableField("access_token_validity")
    private Integer accessTokenValidity;

    /**
     * refresh_token有效期
     */
    @TableField("refresh_token_validity")
    private Integer refreshTokenValidity;

    /**
     * json 格式：{}
     */
    @TableField("additional_information")
    private String additionalInformation;

    /**
     * 是否自动授权 是-true
     */
    @TableField("autoapprove")
    private String autoapprove;

    public static HappyClientDetails of(OauthClientDetails oauthClientDetails){
        return new HappyClientDetails(oauthClientDetails);
    }

}
