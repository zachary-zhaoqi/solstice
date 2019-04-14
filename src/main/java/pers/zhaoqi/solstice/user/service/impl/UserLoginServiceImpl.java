package pers.zhaoqi.solstice.user.service.impl;

import pers.zhaoqi.solstice.user.entity.UserLogin;
import pers.zhaoqi.solstice.user.mapper.UserLoginMapper;
import pers.zhaoqi.solstice.user.service.IUserLoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登录表 服务实现类
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@Service
public class UserLoginServiceImpl extends ServiceImpl<UserLoginMapper, UserLogin> implements IUserLoginService {

}
