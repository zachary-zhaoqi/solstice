package pers.zhaoqi.solstice.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pers.zhaoqi.solstice.common.until.JWTUntil;
import pers.zhaoqi.solstice.user.dto.UserInputDTO;
import pers.zhaoqi.solstice.user.dto.UserOutputDTO;
import pers.zhaoqi.solstice.user.entity.UserLogin;
import pers.zhaoqi.solstice.user.mapper.UserLoginMapper;
import pers.zhaoqi.solstice.user.service.IUserInfoService;
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

    @Autowired
    private IUserInfoService userInfoService;

    @Override
    public String creatTokenForAccount(UserInputDTO userInputDTO) throws Exception {
        UserLogin userLogin = new UserLogin();
        BeanUtils.copyProperties(userInputDTO, userLogin);
        QueryWrapper queryWrapper = new QueryWrapper(userLogin);
//        queryWrapper.select("id", "user_account", "user_email", "user_phone", "user_authority", "is_remove", "version", "`create`", "create_name", "create_time", "modify", "modify_name", "modify_time");//已使用@TableField(select=false)
        userLogin = getOne(queryWrapper);
        if (null == userLogin) {
            return null;
        }
        UserOutputDTO userOutputDTO = new UserOutputDTO();
        BeanUtils.copyProperties(userLogin, userOutputDTO);
//        BeanUtils.copyProperties(userInfoService.getById(userLogin.getId()),userOutputDTO);



        return JWTUntil.createJWT(userOutputDTO,360000000L);
    }


    @Override
    public String creatTokenForPhone(UserInputDTO userInputDTO) {
        return null;
    }

    @Override
    public String creatTokenForEmail(UserInputDTO userInputDTO) {
        return null;
    }
}
