package pers.zhaoqi.solstice.dictionary.entity;

import pers.zhaoqi.solstice.common.BaseEntity;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 数据字典
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="DataDictionary对象", description="数据字典")
public class DataDictionary extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "关联父ID")
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
