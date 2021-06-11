package cool.happycoding.uaa.service;

import cool.happycoding.uaa.dao.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import cool.happycoding.uaa.dto.form.UserAddForm;
import cool.happycoding.uaa.dto.form.UserQryForm;
import cool.happycoding.uaa.dto.form.UserQryPageForm;
import cool.happycoding.uaa.dto.form.UserUpdateForm;
import cool.happycoding.uaa.dto.UserDto;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author happycoding
 * @since 2021-06-10
 */
public interface IUserService extends IService<User> {

    /**
     * 获取用户
     *
     * @param id 用户id
     * @return UserDto
     */
    UserDto get(String id);

    /**
     * 获取用户
     *
     * @param userAddForm
     * @return UserDto
     */
    UserDto save(UserAddForm userAddForm);

    /**
     * 更新用户信息
     *
     * @param userUpdateForm
     * @return
     */
    boolean update(UserUpdateForm userUpdateForm);

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    boolean delete(String id);

    /**
     * 查询用户
     *
     * @param userQryForm
     * @return
     */
    List<UserDto> list(UserQryForm userQryForm);

    /**
     * 查询用户
     * @param userQryPageForm
     * @return
     */
    IPage<UserDto> page(UserQryPageForm userQryPageForm);
}
