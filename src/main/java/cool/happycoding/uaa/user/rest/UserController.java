package cool.happycoding.uaa.user.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cool.happycoding.uaa.user.dto.form.UserAddForm;
import cool.happycoding.uaa.user.dto.form.UserQryForm;
import cool.happycoding.uaa.user.dto.form.UserQryPageForm;
import cool.happycoding.uaa.user.dto.form.UserUpdateForm;
import cool.happycoding.uaa.user.dto.UserDto;
import cool.happycoding.uaa.user.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import cool.happycoding.code.base.result.BaseResult;
import cool.happycoding.code.base.result.ListResult;
import cool.happycoding.code.base.result.PageResult;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author happycoding
 * @since 2021-06-10
 */

@Validated
@RestController
@Api(tags="用户")
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    /**
     * 用户 服务类
     */
    private final IUserService userServiceImpl;

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @PostMapping
    public BaseResult<UserDto> add(@RequestBody UserAddForm userAddForm) {
       return BaseResult.success(userServiceImpl.save(userAddForm));
    }

    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
    @DeleteMapping(value = "/{id}")
    public BaseResult<Boolean> delete(@PathVariable String id) {
       return BaseResult.success(userServiceImpl.delete(id));
    }

    @ApiOperation(value = "修改用户", notes = "修改指定用户信息")
    @PutMapping(value = "/{id}")
    public BaseResult<Boolean> update(@PathVariable String id,
            @RequestBody UserUpdateForm userUpdateForm) {
       userUpdateForm.setId(id);
       return BaseResult.success(userServiceImpl.update(userUpdateForm));
    }

    @ApiOperation(value = "获取用户", notes = "获取指定用户信息")
    @GetMapping(value = "/{id}")
    public BaseResult<UserDto> get(@PathVariable String id) {
       return BaseResult.success(userServiceImpl.get(id));
    }

    @ApiOperation(value = "搜索用户", notes = "根据条件查询用户信息")
    @PostMapping(value = "/list")
    public ListResult<UserDto> list(@RequestBody UserQryForm userQryForm) {
        return ListResult.success(userServiceImpl.list(userQryForm));
    }

    @ApiOperation(value = "分页搜索用户", notes = "根据条件分页查询用户信息")
    @PostMapping(value = "/page")
    public PageResult<UserDto> page(@RequestBody UserQryPageForm userQryPageForm) {
        IPage<UserDto> page = userServiceImpl.page(userQryPageForm);
        return PageResult.success(page.getCurrent(), page.getPages(), page.getTotal(), page.getRecords());
    }

}
