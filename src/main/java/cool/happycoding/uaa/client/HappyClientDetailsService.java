package cool.happycoding.uaa.client;

import cool.happycoding.uaa.client.service.IOauthClientDetailsService;
import org.springframework.security.oauth2.provider.*;

import java.util.List;

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

        return null;
    }

    @Override
    public void addClientDetails(ClientDetails clientDetails) throws ClientAlreadyExistsException {

    }

    @Override
    public void updateClientDetails(ClientDetails clientDetails) throws NoSuchClientException {

    }

    @Override
    public void updateClientSecret(String clientId, String secret) throws NoSuchClientException {

    }

    @Override
    public void removeClientDetails(String clientId) throws NoSuchClientException {

    }

    @Override
    public List<ClientDetails> listClientDetails() {
        return null;
    }
}
