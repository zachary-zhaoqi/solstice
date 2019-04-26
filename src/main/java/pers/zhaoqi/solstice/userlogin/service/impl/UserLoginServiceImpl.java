package pers.zhaoqi.solstice.userlogin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pers.zhaoqi.solstice.userinfo.service.IUserInfoService;
import pers.zhaoqi.solstice.userlogin.dto.UserLoginInputDTO;
import pers.zhaoqi.solstice.userlogin.dto.UserLoginOutputDTO;
import pers.zhaoqi.solstice.userlogin.entity.UserLogin;
import pers.zhaoqi.solstice.userlogin.jwt.JWTUntil;
import pers.zhaoqi.solstice.userlogin.mapper.UserLoginMapper;
import pers.zhaoqi.solstice.userlogin.service.IUserLoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登录表 服务实现类
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-26
 */
@Service
public class UserLoginServiceImpl extends ServiceImpl<UserLoginMapper, UserLogin> implements IUserLoginService {

    @Override
    public String creatTokenForAccount(UserLoginInputDTO userLoginInputDTO) throws Exception {
        UserLogin userLogin = new UserLogin();
        BeanUtils.copyProperties(userLoginInputDTO, userLogin);
        QueryWrapper queryWrapper = new QueryWrapper(userLogin);
        userLogin = getOne(queryWrapper);
        if (null == userLogin) {
            return null;
        }
        UserLoginOutputDTO userLoginOutputDTO = new UserLoginOutputDTO();
        BeanUtils.copyProperties(userLogin, userLoginOutputDTO);

        return JWTUntil.createJWT(userLoginOutputDTO, JWTUntil.JWT_EXPIRES);
    }


    @Override
    public String creatTokenForPhone(UserLoginInputDTO userLoginInputDTO) {
        return null;
    }

    @Override
    public String creatTokenForEmail(UserLoginInputDTO userLoginInputDTO) {
        return null;
    }
}
