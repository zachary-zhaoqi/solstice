package pers.zhaoqi.solstice.order.service.impl;

import pers.zhaoqi.solstice.order.entity.OrderDetail;
import pers.zhaoqi.solstice.order.mapper.OrderDetailMapper;
import pers.zhaoqi.solstice.order.service.IOrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单详情表 服务实现类
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements IOrderDetailService {

}
