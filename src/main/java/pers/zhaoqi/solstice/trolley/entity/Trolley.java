package pers.zhaoqi.solstice.trolley.entity;

import java.math.BigDecimal;
import pers.zhaoqi.solstice.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 购物车表
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Trolley对象", description="购物车表")
public class Trolley extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "关联用户ID")
    private Integer userId;

    @ApiModelProperty(value = "关联产品ID")
    private Integer productId;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "产品图片路径")
    private String productPicture;

    @ApiModelProperty(value = "加入购物车时的价格")
    private BigDecimal trolleyProductPrice;

    @ApiModelProperty(value = "购物车产品数量")
    private Integer trolleyProductNumber;


}
