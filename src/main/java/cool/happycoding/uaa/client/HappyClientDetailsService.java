package cool.happycoding.uaa.client;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.google.common.collect.Lists;
import cool.happycoding.uaa.client.dao.entity.OauthClientDetails;
import cool.happycoding.uaa.client.service.IOauthClientDetailsService;
import org.springframework.security.oauth2.provider.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * description
 *
 * @author pengzhenchen 2021/06/11 5:52 下午
 */

public class HappyClientDetailsService implements ClientDetailsService, ClientRegistrationService {

    private final IOauthClientDetailsService oauthClientDetailsService;

    public HappyClientDetailsService(IOauthClientDetailsService oauthClientDetailsService) {
        this.oauthClientDetailsService = oauthClientDetailsService;
    }


    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        return oauthClientDetailsService.loadClientByClientId(clientId);
    }

    @Override
    public void addClientDetails(ClientDetails clientDetails) throws ClientAlreadyExistsException {
        oauthClientDetailsService.save(HappyClientDetails.of(clientDetails));
    }

    @Override
    public void updateClientDetails(ClientDetails clientDetails) throws NoSuchClientException {
        oauthClientDetailsService.update(HappyClientDetails.of(clientDetails),
                new UpdateWrapper<OauthClientDetails>().eq("client_id", clientDetails.getClientId()));
    }

    @Override
    public void updateClientSecret(String clientId, String secret) throws NoSuchClientException {
        oauthClientDetailsService.update(new UpdateWrapper<OauthClientDetails>()
                .eq("client_id", clientId)
                .set("clientSecret", secret));
    }

    @Override
    public void removeClientDetails(String clientId) throws NoSuchClientException {
        oauthClientDetailsService.remove(new QueryWrapper<OauthClientDetails>()
                .eq("client_id", clientId));
    }

    @Override
    public List<ClientDetails> listClientDetails() {
        List<OauthClientDetails> oauthClientDetails = oauthClientDetailsService.list();
        if (CollUtil.isNotEmpty(oauthClientDetails)){
            return oauthClientDetails.stream().map(OauthClientDetails::of).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }
}
