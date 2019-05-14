package pers.zhaoqi.solstice.shippingaddress.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @description:
 * @author: starr
 * @Date: 2019/5/13 23:21
 **/
@Data
@Accessors(chain = true)
public class ShippingAddressInputDTO {

    @ApiModelProperty(value = "关联用户ID")
    private Integer userId;

    @ApiModelProperty(value = "收货人称呼")
    private String consignee;

    @ApiModelProperty(value = "收货人电话")
    private String tel;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "省代码 关联数据字典")
    private String provinceCode;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "市代码 关联数据字典")
    private String cityCode;

    @ApiModelProperty(value = "区")
    private String district;

    @ApiModelProperty(value = "区代码 关联数据字典")
    private String districtCode;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "是否默认地址 0:默认收货地址1:非默认收货地址 关联数据字典")
    private String isDef;
}
