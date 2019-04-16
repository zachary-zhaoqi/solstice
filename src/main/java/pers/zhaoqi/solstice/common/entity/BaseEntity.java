package pers.zhaoqi.solstice.common.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@ApiModel(value="BaseEntity对象", description="基础实体类")
public class BaseEntity implements Serializable {

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "逻辑删除标识符 0:未删除1:已删除")
    @TableLogic
    private Integer isRemove;

    @ApiModelProperty(value = "版本号-乐观锁")
    @Version
    private Integer version;

    @ApiModelProperty(value = "创建人ID")
    @TableField("`create`")
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

}
