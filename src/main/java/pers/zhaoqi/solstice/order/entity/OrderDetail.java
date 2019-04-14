package pers.zhaoqi.solstice.order.entity;

import java.math.BigDecimal;
import pers.zhaoqi.solstice.common.BaseEntity;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单详情表
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="OrderDetail对象", description="订单详情表")
public class OrderDetail extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "关联订单ID")
    private Integer orderId;

    @ApiModelProperty(value = "关联库存ID")
    private Integer inventoryId;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "订单的商品数量")
    private Integer orderProductNumber;

    @ApiModelProperty(value = "购买商品单价")
    private BigDecimal orderProductPrice;

    @ApiModelProperty(value = "产品图片URL")
    private String productPicture;


}
