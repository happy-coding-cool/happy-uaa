package cool.happycoding.uaa.client.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cool.happycoding.uaa.client.dao.entity.OauthClientDetails;

/**
 * <p>
 * 应用信息 Mapper 接口
 * </p>
 *
 * @author happycoding
 * @since 2021-06-11
 */
@Mapper
public interface OauthClientDetailsMapper extends BaseMapper<OauthClientDetails> {

}
