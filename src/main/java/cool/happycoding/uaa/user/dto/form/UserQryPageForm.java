package cool.happycoding.uaa.user.dto.form;

import cool.happycoding.code.base.pojo.PageForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 用户 分页查询
 * </p>
 *
 * @author happycoding
 * @since 2021-06-10
 */
@Data
@ApiModel(value="UserQryPageForm对象", description="用户分页查询")
public class UserQryPageForm extends PageForm {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "用户账号")
    private String account;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "邮箱")
    private String mail;

    @ApiModelProperty(value = "组织ID")
    private String orgId;

    @ApiModelProperty(value = "用户类型：管理员/普通用户")
    private String userType;

    @ApiModelProperty(value = "用户状态")
    private String userSta;

}