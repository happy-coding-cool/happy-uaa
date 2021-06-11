package cool.happycoding.uaa.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cool.happycoding.uaa.dao.entity.User;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author happycoding
 * @since 2021-06-10
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
