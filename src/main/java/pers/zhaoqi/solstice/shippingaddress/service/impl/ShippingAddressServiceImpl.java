package pers.zhaoqi.solstice.shippingaddress.service.impl;

import pers.zhaoqi.solstice.shippingaddress.entity.ShippingAddress;
import pers.zhaoqi.solstice.shippingaddress.mapper.ShippingAddressMapper;
import pers.zhaoqi.solstice.shippingaddress.service.IShippingAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 收货地址表 服务实现类
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@Service
public class ShippingAddressServiceImpl extends ServiceImpl<ShippingAddressMapper, ShippingAddress> implements IShippingAddressService {

}
