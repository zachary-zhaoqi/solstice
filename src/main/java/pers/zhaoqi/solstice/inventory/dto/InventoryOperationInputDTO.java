package pers.zhaoqi.solstice.inventory.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @description:
 * @author: starr
 * @Date: 2019/5/14 17:01
 **/
@Data
@Accessors(chain = true)
@ApiModel(value="InventoryOperationInputDTO对象", description="库存操作表")
public class InventoryOperationInputDTO {

    @ApiModelProperty(value = "批次号")
    private String batchSn;

    @ApiModelProperty(value = "关联库存ID")
    private Integer inventoryId;

    @ApiModelProperty(value = "操作类型")
    private String operationType;

    @ApiModelProperty(value = "操作数量")
    private Integer number;

    @ApiModelProperty(value = "记录操作后产品数量")
    private Integer recordNumber;

    @ApiModelProperty(value = "关联操作的ID")
    private Integer correlationOperationId;
}
