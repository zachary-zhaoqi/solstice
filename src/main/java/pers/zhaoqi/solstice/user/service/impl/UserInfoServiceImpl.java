package pers.zhaoqi.solstice.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pers.zhaoqi.solstice.user.entity.UserInfo;
import pers.zhaoqi.solstice.user.mapper.UserInfoMapper;
import pers.zhaoqi.solstice.user.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
