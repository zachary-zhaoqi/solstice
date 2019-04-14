package pers.zhaoqi.solstice.log.service.impl;

import pers.zhaoqi.solstice.log.entity.LoginLog;
import pers.zhaoqi.solstice.log.mapper.LoginLogMapper;
import pers.zhaoqi.solstice.log.service.ILoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登录日志表 服务实现类
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements ILoginLogService {

}
