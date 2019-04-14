package pers.zhaoqi.solstice.order.entity;

import pers.zhaoqi.solstice.common.BaseEntity;
import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="OrderMaster对象", description="订单表")
public class OrderMaster extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单编号 yyyymmddnnnnnn")
    private String orderSn;

    @ApiModelProperty(value = "关联用户ID")
    private Integer userId;

    @ApiModelProperty(value = "关联收货地址ID")
    private Integer shippingAddressId;

    @ApiModelProperty(value = "支付方式")
    private String payMethod;

    @ApiModelProperty(value = "订单金额")
    private String orderMoney;

    @ApiModelProperty(value = "优惠金额")
    private String discountAmount;

    @ApiModelProperty(value = "运费金额")
    private String shippingMoney;

    @ApiModelProperty(value = "支付金额")
    private String payMoney;

    @ApiModelProperty(value = "快递公司名称")
    private String shippingCompanyName;

    @ApiModelProperty(value = "快递单号")
    private String shippingSn;

    @ApiModelProperty(value = "支付时间")
    private LocalDateTime payTime;

    @ApiModelProperty(value = "发货时间")
    private LocalDateTime shipmentsTime;

    @ApiModelProperty(value = "收货时间")
    private LocalDateTime receiveTime;

    @ApiModelProperty(value = "订单状态")
    private String orderStatus;


}
