package pers.zhaoqi.solstice.inventory.service;

import pers.zhaoqi.solstice.inventory.dto.InventoryOperationInputDTO;
import pers.zhaoqi.solstice.inventory.entity.InventoryOperation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 库存操作表 服务类
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
public interface IInventoryOperationService extends IService<InventoryOperation> {

    boolean newInventoryOperation(InventoryOperationInputDTO inventoryOperationInputDTO) throws Exception;
}
