package cool.happycoding.uaa.client.service;

import cool.happycoding.uaa.client.HappyClientDetails;
import cool.happycoding.uaa.client.dao.entity.OauthClientDetails;
import com.baomidou.mybatisplus.extension.service.IService;
import cool.happycoding.uaa.client.dto.form.OauthClientDetailsAddForm;
import cool.happycoding.uaa.client.dto.form.OauthClientDetailsQryForm;
import cool.happycoding.uaa.client.dto.form.OauthClientDetailsQryPageForm;
import cool.happycoding.uaa.client.dto.form.OauthClientDetailsUpdateForm;
import cool.happycoding.uaa.client.dto.OauthClientDetailsDto;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.List;

/**
 * <p>
 * 应用信息 服务类
 * </p>
 *
 * @author happycoding
 * @since 2021-06-11
 */
public interface IOauthClientDetailsService extends IService<OauthClientDetails> {

    /**
     * 获取应用信息
     *
     * @param id 应用信息id
     * @return OauthClientDetailsDto
     */
    OauthClientDetailsDto get(String id);

    /**
     * 获取应用信息
     *
     * @param clientId 应用信息id
     * @return OauthClientDetailsDto
     */
    HappyClientDetails loadClientByClientId(String clientId);


    /**
     * 获取应用信息
     *
     * @param oauthClientDetailsAddForm
     * @return OauthClientDetailsDto
     */
    OauthClientDetailsDto save(OauthClientDetailsAddForm oauthClientDetailsAddForm);

    /**
     * 更新应用信息信息
     *
     * @param oauthClientDetailsUpdateForm
     * @return
     */
    boolean update(OauthClientDetailsUpdateForm oauthClientDetailsUpdateForm);

    /**
     * 根据id删除应用信息
     *
     * @param id
     * @return
     */
    boolean delete(String id);

    /**
     * 查询应用信息
     *
     * @param oauthClientDetailsQryForm
     * @return
     */
    List<OauthClientDetailsDto> list(OauthClientDetailsQryForm oauthClientDetailsQryForm);

    /**
     * 查询应用信息
     * @param oauthClientDetailsQryPageForm
     * @return
     */
    IPage<OauthClientDetailsDto> page(OauthClientDetailsQryPageForm oauthClientDetailsQryPageForm);
}
