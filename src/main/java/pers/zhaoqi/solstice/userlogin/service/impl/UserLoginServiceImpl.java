package pers.zhaoqi.solstice.userlogin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import pers.zhaoqi.solstice.common.enums.ConstantMessage;
import pers.zhaoqi.solstice.common.result.ActionResult;
import pers.zhaoqi.solstice.common.result.Result;
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
    public ActionResult creatTokenForAccount(UserLoginInputDTO userLoginInputDTO) throws Exception {
        UserLogin userLogin = new UserLogin();
        BeanUtils.copyProperties(userLoginInputDTO, userLogin);
        QueryWrapper queryWrapper = new QueryWrapper(userLogin);
        userLogin = getOne(queryWrapper);

        UserLoginOutputDTO userLoginOutputDTO = new UserLoginOutputDTO();
        userLoginOutputDTO.setType(userLoginInputDTO.getType());
        if (null == userLogin) {
            userLoginOutputDTO.setUserAuthority("guest");//设置身份为游客
            return Result.failed(ConstantMessage.LOGIN_ERROR,userLoginOutputDTO);
        }else {
            BeanUtils.copyProperties(userLogin, userLoginOutputDTO);
            userLoginOutputDTO.setJwt(JWTUntil.createJWT(userLogin.getId(),null,JWTUntil.JWT_EXPIRES));
            return Result.success("登录成功",userLoginOutputDTO);
        }
    }


    @Override
    public ActionResult creatTokenForPhone(UserLoginInputDTO userLoginInputDTO) {
        return null;
    }

    @Override
    public ActionResult creatTokenForEmail(UserLoginInputDTO userLoginInputDTO) {
        return null;
    }
}
