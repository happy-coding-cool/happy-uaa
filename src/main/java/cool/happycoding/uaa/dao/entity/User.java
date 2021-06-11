package cool.happycoding.uaa.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import cool.happycoding.code.mybatis.base.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author happycoding
 * @since 2021-06-10
 */
@Data
@TableName("h_user")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 用户账号
     */
    @TableField("account")
    private String account;

    /**
     * 用户密码
     */
    @TableField("password")
    private String password;

    /**
     * 用户名称
     */
    @TableField("user_name")
    private String userName;

    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 性别
     */
    @TableField("gender")
    private String gender;

    /**
     * 手机号
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 邮箱
     */
    @TableField("mail")
    private String mail;

    /**
     * 组织ID
     */
    @TableField("org_id")
    private String orgId;

    /**
     * 用户类型：管理员/普通用户
     */
    @TableField("user_type")
    private String userType;

    /**
     * 用户状态
     */
    @TableField("user_sta")
    private String userSta;

}
