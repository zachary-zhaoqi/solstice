package pers.zhaoqi.solstice.userinfo.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import pers.zhaoqi.solstice.userlogin.entity.UserLogin;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-26
 */
@RestController
@RequestMapping("/userinfo/userInfo")
public class UserInfoController {

    @DeleteMapping("/{id}")
    public UserLogin deleteUserLogin(@PathVariable("id") Integer id) {
        return null;
    }

}
