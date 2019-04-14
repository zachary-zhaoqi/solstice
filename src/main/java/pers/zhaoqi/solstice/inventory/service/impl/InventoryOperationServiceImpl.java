package pers.zhaoqi.solstice.inventory.service.impl;

import pers.zhaoqi.solstice.inventory.entity.InventoryOperation;
import pers.zhaoqi.solstice.inventory.mapper.InventoryOperationMapper;
import pers.zhaoqi.solstice.inventory.service.IInventoryOperationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 库存操作表 服务实现类
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@Service
public class InventoryOperationServiceImpl extends ServiceImpl<InventoryOperationMapper, InventoryOperation> implements IInventoryOperationService {

}
