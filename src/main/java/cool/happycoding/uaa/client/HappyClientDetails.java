package cool.happycoding.uaa.client;

import cn.hutool.core.util.StrUtil;
import cool.happycoding.uaa.client.dao.entity.OauthClientDetails;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * description
 *
 * @author pengzhenchen 2021/06/11 5:26 下午
 */
@Data
public class HappyClientDetails implements ClientDetails {

    private String clientId;
    private String clientSecret;
    private Set<String> scope = Collections.emptySet();
    private Set<String> resourceIds = Collections.emptySet();
    private Set<String> authorizedGrantTypes = Collections.emptySet();
    private Set<String> registeredRedirectUris;
    private Set<String> autoApproveScopes;
    private List<GrantedAuthority> authorities = Collections.emptyList();
    private Integer accessTokenValiditySeconds;
    private Integer refreshTokenValiditySeconds;
    private Map<String, Object> additionalInformation = new LinkedHashMap<String, Object>();

    public HappyClientDetails(){}

    public HappyClientDetails(OauthClientDetails prototype) {

        this();
        setAccessTokenValiditySeconds(prototype.getAccessTokenValidity());
        setRefreshTokenValiditySeconds(prototype
                .getRefreshTokenValidity());
        setClientId(prototype.getClientId());
        setClientSecret(prototype.getClientSecret());
        if (StrUtil.isNotBlank(prototype.getAuthorizedGrantTypes())){
            this.authorizedGrantTypes = StringUtils.commaDelimitedListToSet(prototype.getAuthorizedGrantTypes());
        }
        if (StrUtil.isNotBlank(prototype.getScope())){
            this.autoApproveScopes = StringUtils.commaDelimitedListToSet(prototype.getAuthorizedGrantTypes());
        }
        if (StrUtil.isNotBlank(prototype.getAuthorities())) {
            this.authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(prototype.getAuthorities());
        }
        if (StrUtil.isNotBlank(prototype.getWebServerRedirectUri())) {
            this.registeredRedirectUris = StringUtils.commaDelimitedListToSet(prototype.getWebServerRedirectUri());
        }
        if (StrUtil.isNotBlank(prototype.getScope())) {
            Set<String> scopeList = StringUtils.commaDelimitedListToSet(prototype.getScope());
            if (!scopeList.isEmpty()) {
                this.scope = scopeList;
            }
        }
        if (StrUtil.isNotBlank(prototype.getResourceIds())) {
            Set<String> resources = StringUtils
                    .commaDelimitedListToSet(prototype.getResourceIds());
            if (!resources.isEmpty()) {
                this.resourceIds = resources;
            }
        }
    }

    @Override
    public boolean isAutoApprove(String scope) {
        if (autoApproveScopes == null) {
            return false;
        }
        for (String auto : autoApproveScopes) {
            if (auto.equals(Boolean.TRUE.toString()) || scope.matches(auto)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean isSecretRequired() {
        return this.clientSecret != null;
    }

    @Override
    public boolean isScoped() {
        return this.scope != null && !this.scope.isEmpty();
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return this.registeredRedirectUris;
    }

}
