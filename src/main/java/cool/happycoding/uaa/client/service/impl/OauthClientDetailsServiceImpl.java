package cool.happycoding.uaa.client.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import cool.happycoding.uaa.client.HappyClientDetails;
import cool.happycoding.uaa.client.dao.entity.OauthClientDetails;
import cool.happycoding.uaa.client.dao.mapper.OauthClientDetailsMapper;
import cool.happycoding.uaa.client.service.IOauthClientDetailsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cool.happycoding.uaa.client.dto.form.OauthClientDetailsAddForm;
import cool.happycoding.uaa.client.dto.form.OauthClientDetailsQryForm;
import cool.happycoding.uaa.client.dto.form.OauthClientDetailsQryPageForm;
import cool.happycoding.uaa.client.dto.form.OauthClientDetailsUpdateForm;
import cool.happycoding.uaa.client.dto.OauthClientDetailsDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cool.happycoding.code.base.util.HappyCodeUtil;
import java.util.List;

/**
 * <p>
 * 应用信息 服务实现类
 * </p>
 *
 * @author happycoding
 * @since 2021-06-11
 */
@Service
public class OauthClientDetailsServiceImpl extends ServiceImpl<OauthClientDetailsMapper, OauthClientDetails> implements IOauthClientDetailsService {


     @Override
     public OauthClientDetailsDto get(String id) {
        OauthClientDetails oauthClientDetails = this.getById(id);
        if(ObjectUtil.isNotNull(oauthClientDetails)){
            return oauthClientDetails.toDTO(OauthClientDetailsDto.class);
        }
        return null;
     }

    @Override
    public HappyClientDetails loadClientByClientId(String clientId) {
        OauthClientDetails oauthClientDetails = this.getOne(new QueryWrapper<OauthClientDetails>().eq("client_id",clientId));
        if(ObjectUtil.isNotNull(oauthClientDetails)){
            return OauthClientDetails.of(oauthClientDetails);
        }
        return null;
    }

    @Override
     @Transactional(rollbackFor = Exception.class)
     public OauthClientDetailsDto save(OauthClientDetailsAddForm oauthClientDetailsAddForm) {
        OauthClientDetails oauthClientDetails = oauthClientDetailsAddForm.toEntity(OauthClientDetails.class);
        this.save(oauthClientDetails);
        return oauthClientDetails.toDTO(OauthClientDetailsDto.class);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean update(OauthClientDetailsUpdateForm oauthClientDetailsUpdateForm) {
        OauthClientDetails oauthClientDetails = oauthClientDetailsUpdateForm.toEntity(OauthClientDetails.class);
        return this.updateById(oauthClientDetails);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean delete(String id) {
        return this.removeById(id);
     }

     @Override
     public List<OauthClientDetailsDto> list(OauthClientDetailsQryForm oauthClientDetailsQryForm) {
        QueryWrapper<OauthClientDetails> queryWrapper = new QueryWrapper<>();
        // TODO 构造查询条件
        List<OauthClientDetails> oauthClientDetailss = this.list(queryWrapper);
        return HappyCodeUtil.copy(oauthClientDetailss, OauthClientDetailsDto.class);

     }

     @Override
     public IPage<OauthClientDetailsDto> page(OauthClientDetailsQryPageForm oauthClientDetailsQryPageForm) {
         QueryWrapper<OauthClientDetails> queryWrapper = new QueryWrapper<>();
         // TODO 构造查询条件
         return this.page(new Page<>(oauthClientDetailsQryPageForm.getCurrent(), oauthClientDetailsQryPageForm.getSize()),
                    queryWrapper).convert(oauthClientDetails->oauthClientDetails.toDTO(OauthClientDetailsDto.class));
      }

}
