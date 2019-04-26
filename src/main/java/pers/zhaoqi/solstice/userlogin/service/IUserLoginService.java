package pers.zhaoqi.solstice.userlogin.service;

import pers.zhaoqi.solstice.userlogin.dto.UserLoginInputDTO;
import pers.zhaoqi.solstice.userlogin.entity.UserLogin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户登录表 服务类
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-26
 */
public interface IUserLoginService extends IService<UserLogin> {

    /**
     * 通过账户密码进行创建session登录
     *
     * @return*/
    String creatTokenForAccount(UserLoginInputDTO userLoginInputDTO) throws Exception;

    String creatTokenForPhone(UserLoginInputDTO userLoginInputDTO);

    String creatTokenForEmail(UserLoginInputDTO userLoginInputDTO);
}
