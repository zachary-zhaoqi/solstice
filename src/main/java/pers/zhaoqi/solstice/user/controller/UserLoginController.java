package pers.zhaoqi.solstice.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pers.zhaoqi.solstice.user.entity.UserLogin;
import pers.zhaoqi.solstice.user.service.impl.UserLoginServiceImpl;

/**
 * <p>
 * 用户登录表 前端控制器
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@RestController
@RequestMapping("/user/userLogin")
public class UserLoginController {

    @Autowired
    private UserLoginServiceImpl service;

    @GetMapping("/{id}")
    public UserLogin getUserLogin(@PathVariable("id") String id){
        return service.getById(id);
    }

    @PostMapping("")
    public UserLogin addUserLogin(){


        return null;
    }


}
