package pers.zhaoqi.solstice.order.service.impl;

import pers.zhaoqi.solstice.order.entity.OrderMaster;
import pers.zhaoqi.solstice.order.mapper.OrderMasterMapper;
import pers.zhaoqi.solstice.order.service.IOrderMasterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@Service
public class OrderMasterServiceImpl extends ServiceImpl<OrderMasterMapper, OrderMaster> implements IOrderMasterService {

}
