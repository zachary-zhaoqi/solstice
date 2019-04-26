package pers.zhaoqi.solstice.userlogin.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import pers.zhaoqi.solstice.common.enums.ConstantMessage;
import pers.zhaoqi.solstice.common.result.ActionResult;
import pers.zhaoqi.solstice.common.result.Result;
import pers.zhaoqi.solstice.userlogin.dto.UserLoginInputDTO;
import pers.zhaoqi.solstice.userlogin.service.IUserLoginService;

/**
 * <p>
 * 用户登录表 前端控制器
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-26
 */
@RestController
@RequestMapping("/userlogin/userLogin")
public class UserLoginController {
    @Autowired
    private IUserLoginService service;

    @ApiOperation(value = "新建会话", notes = "新建会话")
    @PostMapping("/")
    public ActionResult creatToken(@RequestBody UserLoginInputDTO userLoginInputDTO) {
        if (userLoginInputDTO.getUserPassword() == null) {
            return Result.failed(ConstantMessage.WANT_CORRECT_INPUT,"请输入密码");
        }
        String jwt = null;
        if (userLoginInputDTO.getUserAccount() != null) {
            try {
                jwt=service.creatTokenForAccount(userLoginInputDTO);//如果有账户就通过账户密码进行创建session登录
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (userLoginInputDTO.getUserPhone() != null) {
            jwt=service.creatTokenForPhone(userLoginInputDTO);//如果有手机号就通过手机号进行创建session登录
        } else if (userLoginInputDTO.getUserEmail() != null) {
            jwt=service.creatTokenForEmail(userLoginInputDTO);//如果有邮箱就通过邮箱进行创建session登录
        }else{
            return Result.failed(ConstantMessage.WANT_CORRECT_INPUT,"请输入账户/手机号/邮箱，或使用手机号验证登录");
        }
        if(jwt==null){
            return Result.failed(ConstantMessage.FAIL_CODE,"账户或密码错误");
        }
        return Result.success("登录成功",jwt);
    }
}
