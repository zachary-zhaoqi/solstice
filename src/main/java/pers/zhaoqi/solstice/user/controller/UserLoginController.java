package pers.zhaoqi.solstice.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.zhaoqi.solstice.user.dto.UserInputDTO;
import pers.zhaoqi.solstice.user.dto.UserOutputDTO;
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

    @ApiOperation(value = "查询用户", notes = "根据id得到用户")
    @GetMapping("/{id}")
    public UserLogin getUserLogin(@PathVariable("id") Integer id) {
        return service.getById(id);
    }

    @ApiOperation(value = "新建会话", notes = "新建会话")
    @PostMapping("/")
    public UserOutputDTO creatSession(@RequestBody UserInputDTO userInputDTO) {
        if (userInputDTO.getUserPassword() == null) {
            return null;
        }
        UserOutputDTO userOutputDTO=null;
        if (userInputDTO.getUserAccount() != null) {
            userOutputDTO=creatSessionForAccount(userInputDTO);//如果有账户就通过账户密码进行创建session登录
        } else if (userInputDTO.getUserPhone() != null) {
            userOutputDTO=creatSessionForPhone(userInputDTO);//如果有手机号就通过手机号进行创建session登录
        } else if (userInputDTO.getUserEmail() != null) {
            userOutputDTO=creatSessionForEmail(userInputDTO);//如果有邮箱就通过邮箱进行创建session登录
        }

        return userOutputDTO;
    }

    private UserOutputDTO creatSessionForAccount(UserInputDTO userInputDTO) {
        UserLogin userLogin = new UserLogin();
        BeanUtils.copyProperties(userInputDTO,userLogin);
        QueryWrapper queryWrapper=new QueryWrapper(userLogin);
        queryWrapper.select("id","user_account","user_password","user_email","user_phone","user_authority","is_remove","version","`create`","create_name","create_time","modify","modify_name","modify_time");//XXX:回头修正为排除password
        userLogin=service.getOne(queryWrapper);
        UserOutputDTO userOutputDTO = new UserOutputDTO();
        BeanUtils.copyProperties(userLogin,userOutputDTO);
        return userOutputDTO;
    }

    private UserOutputDTO creatSessionForPhone(UserInputDTO userInputDTO) {
        //todo:通过手机号创建session登录
        return null;
    }

    private UserOutputDTO creatSessionForEmail(UserInputDTO userInputDTO) {
        //todo:通过邮箱创建session登录
        return null;
    }

    @ApiOperation(value = "更新用户", notes = "更新用户")
    @PutMapping("/{id}")
    public UserLogin updateUserLogin(@PathVariable("id") Integer id) {
        UserLogin userLogin = null;
        if (service.update((UserLogin) service.getById(id).setVersion(1), null)) {
            userLogin = service.getById(id);
        }

        return userLogin;
    }

    @DeleteMapping("/{id}")
    public UserLogin deleteUserLogin(@PathVariable("id") Integer id) {

        return null;
    }
}
