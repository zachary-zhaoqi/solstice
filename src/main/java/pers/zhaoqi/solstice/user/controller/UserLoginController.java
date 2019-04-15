package pers.zhaoqi.solstice.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
@Api(tags = "UserLoginController")
@RestController
@RequestMapping("/user/session")
public class UserLoginController {

    @Autowired
    private UserLoginServiceImpl service;

    @ApiOperation(value = "查询用户",notes = "根据id得到用户")
    @GetMapping("/{id}")
    public UserLogin getUserLogin(@PathVariable("id") Integer id){
        return service.getById(id);
    }
    @ApiOperation(value = "新建会话",notes = "新建会话")
    @PostMapping("/{account}")
    public UserLogin addUserLogin(Wrapper<UserLogin> userLoginWrapper){
        UserLogin userLogin=service.getOne(userLoginWrapper);

        return userLogin;
    }
    @ApiOperation(value = "更新用户",notes = "更新用户")
    @PutMapping("/{id}")
    public UserLogin updateUserLogin(@PathVariable("id") Integer id){
        UserLogin userLogin = null;
        if(service.update((UserLogin) service.getById(id).setVersion(1),null)){
            userLogin = service.getById(id);
        }

        return userLogin;
    }
    @DeleteMapping("/{id}")
    public UserLogin deleteUserLogin(@PathVariable("id") Integer id){

        return null;
    }
}
