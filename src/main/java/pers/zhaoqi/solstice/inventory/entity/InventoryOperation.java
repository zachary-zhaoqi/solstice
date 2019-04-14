package pers.zhaoqi.solstice.inventory.entity;

import pers.zhaoqi.solstice.common.BaseEntity;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 库存操作表
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="InventoryOperation对象", description="库存操作表")
public class InventoryOperation extends BaseEntity {

    private static final long serialVersionUID = 1L;

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
