package cool.happycoding.uaa.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cool.happycoding.uaa.dao.entity.User;
import cool.happycoding.uaa.dao.mapper.UserMapper;
import cool.happycoding.uaa.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cool.happycoding.uaa.dto.form.UserAddForm;
import cool.happycoding.uaa.dto.form.UserQryForm;
import cool.happycoding.uaa.dto.form.UserQryPageForm;
import cool.happycoding.uaa.dto.form.UserUpdateForm;
import cool.happycoding.uaa.dto.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cool.happycoding.code.base.util.HappyCodeUtil;
import java.util.List;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author happycoding
 * @since 2021-06-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


     @Override
     public UserDto get(String id) {
        User user = this.getById(id);
        if(ObjectUtil.isNotNull(user)){
            return user.toDTO(UserDto.class);
        }
        return null;
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public UserDto save(UserAddForm userAddForm) {
        User user = userAddForm.toEntity(User.class);
        this.save(user);
        return user.toDTO(UserDto.class);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean update(UserUpdateForm userUpdateForm) {
        User user = userUpdateForm.toEntity(User.class);
        return this.updateById(user);
     }

     @Override
     @Transactional(rollbackFor = Exception.class)
     public boolean delete(String id) {
        return this.removeById(id);
     }

     @Override
     public List<UserDto> list(UserQryForm userQryForm) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // TODO 构造查询条件
        List<User> users = this.list(queryWrapper);
        return HappyCodeUtil.copy(users, UserDto.class);

     }

     @Override
     public IPage<UserDto> page(UserQryPageForm userQryPageForm) {
         QueryWrapper<User> queryWrapper = new QueryWrapper<>();
         // TODO 构造查询条件
         return this.page(new Page<>(userQryPageForm.getCurrent(), userQryPageForm.getSize()),
                    queryWrapper).convert(user->user.toDTO(UserDto.class));
      }

}
