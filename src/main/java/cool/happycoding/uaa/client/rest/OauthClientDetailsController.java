package cool.happycoding.uaa.client.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cool.happycoding.uaa.client.dto.form.OauthClientDetailsAddForm;
import cool.happycoding.uaa.client.dto.form.OauthClientDetailsQryForm;
import cool.happycoding.uaa.client.dto.form.OauthClientDetailsQryPageForm;
import cool.happycoding.uaa.client.dto.form.OauthClientDetailsUpdateForm;
import cool.happycoding.uaa.client.dto.OauthClientDetailsDto;
import cool.happycoding.uaa.client.service.IOauthClientDetailsService;
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
 * 应用信息 前端控制器
 * </p>
 *
 * @author happycoding
 * @since 2021-06-11
 */

@Validated
@RestController
@Api(tags="应用信息")
@RequiredArgsConstructor
@RequestMapping("/oauth-client-details")
public class OauthClientDetailsController {

    /**
     * 应用信息 服务类
     */
    private final IOauthClientDetailsService oauthClientDetailsServiceImpl;

    @ApiOperation(value = "新增应用信息", notes = "新增应用信息")
    @PostMapping
    public BaseResult<OauthClientDetailsDto> add(@RequestBody @Validated OauthClientDetailsAddForm oauthClientDetailsAddForm) {
       return BaseResult.success(oauthClientDetailsServiceImpl.save(oauthClientDetailsAddForm));
    }

    @ApiOperation(value = "删除应用信息", notes = "根据url的id来指定删除对象")
    @DeleteMapping(value = "/{id}")
    public BaseResult<Boolean> delete(@PathVariable String id) {
       return BaseResult.success(oauthClientDetailsServiceImpl.delete(id));
    }

    @ApiOperation(value = "修改应用信息", notes = "修改指定应用信息信息")
    @PutMapping(value = "/{id}")
    public BaseResult<Boolean> update(@PathVariable String id,
            @RequestBody OauthClientDetailsUpdateForm oauthClientDetailsUpdateForm) {
       oauthClientDetailsUpdateForm.setId(id);
       return BaseResult.success(oauthClientDetailsServiceImpl.update(oauthClientDetailsUpdateForm));
    }

    @ApiOperation(value = "获取应用信息", notes = "获取指定应用信息信息")
    @GetMapping(value = "/{id}")
    public BaseResult<OauthClientDetailsDto> get(@PathVariable String id) {
       return BaseResult.success(oauthClientDetailsServiceImpl.get(id));
    }

    @ApiOperation(value = "搜索应用信息", notes = "根据条件查询应用信息信息")
    @PostMapping(value = "/list")
    public ListResult<OauthClientDetailsDto> list(@RequestBody OauthClientDetailsQryForm oauthClientDetailsQryForm) {
        return ListResult.success(oauthClientDetailsServiceImpl.list(oauthClientDetailsQryForm));
    }

    @ApiOperation(value = "分页搜索应用信息", notes = "根据条件分页查询应用信息信息")
    @PostMapping(value = "/page")
    public PageResult<OauthClientDetailsDto> page(@RequestBody OauthClientDetailsQryPageForm oauthClientDetailsQryPageForm) {
        IPage<OauthClientDetailsDto> page = oauthClientDetailsServiceImpl.page(oauthClientDetailsQryPageForm);
        return PageResult.success(page.getCurrent(), page.getPages(), page.getTotal(), page.getRecords());
    }

}
