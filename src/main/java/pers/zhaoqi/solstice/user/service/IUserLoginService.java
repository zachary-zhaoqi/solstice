package pers.zhaoqi.solstice.user.service;

import pers.zhaoqi.solstice.user.dto.UserInputDTO;
import pers.zhaoqi.solstice.user.entity.UserLogin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户登录表 服务类
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
public interface IUserLoginService extends IService<UserLogin> {
    /**
     * 通过账户密码进行创建session登录
     *
     * @return*/
    String creatSessionForAccount(UserInputDTO userInputDTO) throws Exception;

    String creatSessionForPhone(UserInputDTO userInputDTO);

    String creatSessionForEmail(UserInputDTO userInputDTO);
}
