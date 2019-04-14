package pers.zhaoqi.solstice.inventory.service.impl;

import pers.zhaoqi.solstice.inventory.entity.InventoryInfo;
import pers.zhaoqi.solstice.inventory.mapper.InventoryInfoMapper;
import pers.zhaoqi.solstice.inventory.service.IInventoryInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 库存表 服务实现类
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@Service
public class InventoryInfoServiceImpl extends ServiceImpl<InventoryInfoMapper, InventoryInfo> implements IInventoryInfoService {

}
