package pers.zhaoqi.solstice.trolley.service.impl;

import pers.zhaoqi.solstice.trolley.entity.Trolley;
import pers.zhaoqi.solstice.trolley.mapper.TrolleyMapper;
import pers.zhaoqi.solstice.trolley.service.ITrolleyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 购物车表 服务实现类
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@Service
public class TrolleyServiceImpl extends ServiceImpl<TrolleyMapper, Trolley> implements ITrolleyService {

}
