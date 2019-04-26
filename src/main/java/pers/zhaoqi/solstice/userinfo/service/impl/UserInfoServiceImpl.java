package pers.zhaoqi.solstice.userinfo.service.impl;

import pers.zhaoqi.solstice.userinfo.entity.UserInfo;
import pers.zhaoqi.solstice.userinfo.mapper.UserInfoMapper;
import pers.zhaoqi.solstice.userinfo.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-26
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
