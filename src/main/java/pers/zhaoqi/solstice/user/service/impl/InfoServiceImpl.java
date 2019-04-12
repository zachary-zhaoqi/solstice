package pers.zhaoqi.solstice.user.service.impl;

import pers.zhaoqi.solstice.user.entity.Info;
import pers.zhaoqi.solstice.user.mapper.InfoMapper;
import pers.zhaoqi.solstice.user.service.IInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-12
 */
@Service
public class InfoServiceImpl extends ServiceImpl<InfoMapper, Info> implements IInfoService {

}
