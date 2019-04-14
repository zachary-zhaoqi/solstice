package pers.zhaoqi.solstice.brand.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.zhaoqi.solstice.common.BaseEntity;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 品牌信息表
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="BrandInfo对象", description="品牌信息表")
public class BrandInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "品牌名称")
    private String name;

    @ApiModelProperty(value = "品牌联系电话")
    private String tel;

    @ApiModelProperty(value = "品牌logoURL")
    private String logo;

    @ApiModelProperty(value = "品牌具体描述")
    private String describe;

}
