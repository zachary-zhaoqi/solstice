package pers.zhaoqi.solstice.userinfo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: starr
 * @Date: 2019/5/14 0:41
 **/
@Data
@Accessors(chain = true)
@ApiModel(value="UserInfoDTO对象", description="用户信息表")
public class UserInfoInputDTO {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "连接到用户登录表的ID")
    private Integer userId;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "用户性别")
    private String userSex;

    @ApiModelProperty(value = "用户生日")
    private LocalDateTime userBirthday;

    @ApiModelProperty(value = "用户头像路径")
    private String userChatHead;

}
