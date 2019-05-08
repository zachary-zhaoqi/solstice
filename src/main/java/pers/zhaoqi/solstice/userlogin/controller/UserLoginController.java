package pers.zhaoqi.solstice.userlogin.controller;


import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import pers.zhaoqi.solstice.common.enums.ConstantMessage;
import pers.zhaoqi.solstice.common.result.ActionResult;
import pers.zhaoqi.solstice.common.result.Result;
import pers.zhaoqi.solstice.common.utils.Utils;
import pers.zhaoqi.solstice.userlogin.dto.UserLoginInputDTO;
import pers.zhaoqi.solstice.userlogin.jwt.JWTUtils;
import pers.zhaoqi.solstice.userlogin.service.IUserLoginService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户登录表 前端控制器
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-26
 */
@RestController
@RequestMapping("/userlogin/session")
public class UserLoginController {
    @Autowired
    private IUserLoginService service;

    @ApiOperation(value = "新建会话", notes = "新建会话")
    @PostMapping()
    public ActionResult creatToken(@RequestBody UserLoginInputDTO userLoginInputDTO) {
        if (userLoginInputDTO.getUserPassword() == null) {
            return Result.failed(ConstantMessage.WANT_CORRECT_INPUT, "请输入密码");
        }
        //todo 修改为通过inputDTO中的type来进行判断。
        ActionResult result = null;
        try {
            if (userLoginInputDTO.getUserAccount() != null) {
                result = service.creatTokenForAccount(userLoginInputDTO);//如果有账户就通过账户密码进行创建session登录
            } else if (userLoginInputDTO.getUserPhone() != null) {
                result = service.creatTokenForPhone(userLoginInputDTO);//如果有手机号就通过手机号进行创建session登录
            } else if (userLoginInputDTO.getUserEmail() != null) {
                result = service.creatTokenForEmail(userLoginInputDTO);//如果有邮箱就通过邮箱进行创建session登录
            } else {
                return Result.failed(ConstantMessage.WANT_CORRECT_INPUT, "请输入账户/手机号/邮箱，或使用手机号验证登录");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @ApiOperation(value = "检查令牌", notes = "检查令牌")
    @GetMapping()
    public ActionResult checkToken() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie[] cookies = request.getCookies();
        String token = Utils.getTokenForCookies(cookies);

        try {
            Claims claims = JWTUtils.parseJWT(token);
            return Result.success("验证成功");
        } catch (Exception e) {
            return Result.failed(ConstantMessage.LOGIN_ERROR, "登录信息错误,请重新登录");
        }
    }
}
