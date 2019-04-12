package pers.zhaoqi.solstice.datadictionary.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 数据字典
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-12
 */
@Data
@Accessors(chain = true)
@ApiModel(value="DataDictionary对象", description="数据字典")
public class DataDictionary {

    private static final long serialVersionUID = 1L;

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

    @ApiModelProperty(value = "父ID")
    private Integer parentId;

    @ApiModelProperty(value = "键")
    private String key;

    @ApiModelProperty(value = "值")
    private String value;

    @ApiModelProperty(value = "显示-简体中文")
    private String labelZhCn;

    @ApiModelProperty(value = "显示-美国英文")
    private String labelEnUs;


}
