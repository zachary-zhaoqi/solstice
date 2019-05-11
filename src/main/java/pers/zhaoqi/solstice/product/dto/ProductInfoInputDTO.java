package pers.zhaoqi.solstice.product.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class ProductInfoInputDTO {

    @ApiModelProperty(value = "分类ID 关联数据字典")
    private Integer categorySn;

    @ApiModelProperty(value = "分类名称 关联数据字典")
    private String categoryName;

    @ApiModelProperty(value = "品牌ID")
    private Integer brandId;

    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    @ApiModelProperty(value = "产品名称")
    private String name;

    @ApiModelProperty(value = "条形码")
    private String barCode;

    @ApiModelProperty(value = "条形码url")
    private String barCodeUrl;

    @ApiModelProperty(value = "产品详细描述")
    private String describe;

    @ApiModelProperty(value = "产品图片URL")
    private String picture;

    @ApiModelProperty(value = "平均成本")
    private BigDecimal averageCost;

    @ApiModelProperty(value = "产品售价")
    private BigDecimal price;

    @ApiModelProperty(value = "产品有效期")
    private String shelfLife;

    @ApiModelProperty(value = "产品状态 0:下架 1:上架 关联数据字典")
    private String productStatus;

}
