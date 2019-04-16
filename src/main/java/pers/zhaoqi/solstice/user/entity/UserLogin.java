package pers.zhaoqi.solstice.user.entity;

import pers.zhaoqi.solstice.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户登录表
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UserLogin对象", description="用户登录表")
public class UserLogin extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户账号")
    private String userAccount;

    @ApiModelProperty(value = "用户密码")
    private String userPassword;

    @ApiModelProperty(value = "用户账号关联邮箱")
    private String userEmail;

    @ApiModelProperty(value = "用户账户关联手机号")
    private String userPhone;

    @ApiModelProperty(value = "用户身份权限表 关联数据字典")
    private String userAuthority;


}
