package pers.zhaoqi.solstice.log.entity;

import pers.zhaoqi.solstice.common.entity.BaseEntity;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户登录日志表
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="LoginLog对象", description="用户登录日志表")
public class LoginLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "关联用户ID")
    private Integer userId;

    @ApiModelProperty(value = "登录时间")
    private LocalDateTime loginTime;

    @ApiModelProperty(value = "登录ip地址")
    private String loginIp;

    @ApiModelProperty(value = "登录状态 0：失败1：成功 关联数据字典")
    private String loginStatus;


}
