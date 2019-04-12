package pers.zhaoqi.solstice.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
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
 * @since 2019-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_login")
@ApiModel(value="Login对象", description="用户登录表")
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "逻辑删除标识符
0:未删除1:已删除")
    private Integer isRemove;

    @ApiModelProperty(value = "版本号-乐观锁")
    private Integer version;

    @ApiModelProperty(value = "创建人ID")
    private Integer create;

    @ApiModelProperty(value = "创建人名称")
    private String createName;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改人ID")
    private Integer modify;

    @ApiModelProperty(value = "修改人名称")
    private String modifyName;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime modifyTime;

    @ApiModelProperty(value = "用户账号")
    private String userAccount;

    @ApiModelProperty(value = "用户密码")
    private String userPassword;

    @ApiModelProperty(value = "用户账号关联邮箱")
    private String userEmail;

    @ApiModelProperty(value = "用户账户关联手机号")
    private String userPhone;

    @ApiModelProperty(value = "用户身份权限表
关联数据字典")
    private String userAuthority;


}
