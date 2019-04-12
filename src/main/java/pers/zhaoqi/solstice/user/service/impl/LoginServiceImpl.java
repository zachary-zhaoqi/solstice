package pers.zhaoqi.solstice.user.service.impl;

import pers.zhaoqi.solstice.user.entity.Login;
import pers.zhaoqi.solstice.user.mapper.LoginMapper;
import pers.zhaoqi.solstice.user.service.ILoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登录表 服务实现类
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-12
 */
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements ILoginService {

}
