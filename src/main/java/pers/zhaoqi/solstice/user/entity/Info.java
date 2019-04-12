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
 * 用户信息表
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_info")
@ApiModel(value="Info对象", description="用户信息表")
public class Info implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "逻辑删除标识符 0:未删除1:已删除")
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
