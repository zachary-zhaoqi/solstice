package pers.zhaoqi.solstice.user.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.zhaoqi.solstice.common.enums.ConstantMessage;
import pers.zhaoqi.solstice.common.result.ActionResult;
import pers.zhaoqi.solstice.common.result.Result;
import pers.zhaoqi.solstice.user.dto.UserInputDTO;
import pers.zhaoqi.solstice.user.dto.UserOutputDTO;
import pers.zhaoqi.solstice.user.entity.UserLogin;
import pers.zhaoqi.solstice.user.service.IUserLoginService;

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
    private IUserLoginService service;

    @ApiOperation(value = "查询用户", notes = "根据id得到用户")
    @GetMapping("/{id}")
    public UserLogin getUserLogin(@PathVariable("id") Integer id) {
        return service.getById(id);
    }

    @ApiOperation(value = "新建会话", notes = "新建会话")
    @PostMapping("/")
    public ActionResult creatSession(@RequestBody UserInputDTO userInputDTO) {
        if (userInputDTO.getUserPassword() == null) {
            return Result.failed(ConstantMessage.WANT_CORRECT_INPUT,"请输入密码");
        }
        String jwt = null;
        if (userInputDTO.getUserAccount() != null) {
            try {
                jwt=service.creatSessionForAccount(userInputDTO);//如果有账户就通过账户密码进行创建session登录
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (userInputDTO.getUserPhone() != null) {
            jwt=service.creatSessionForPhone(userInputDTO);//如果有手机号就通过手机号进行创建session登录
        } else if (userInputDTO.getUserEmail() != null) {
            jwt=service.creatSessionForEmail(userInputDTO);//如果有邮箱就通过邮箱进行创建session登录
        }else{
            return Result.failed(ConstantMessage.WANT_CORRECT_INPUT,"请输入账户/手机号/邮箱，或使用手机号验证登录");
        }
        if(jwt==null){
            return Result.failed(ConstantMessage.FAIL_CODE,"账户或密码错误");
        }
        return Result.success("登录成功",jwt);
    }

    @DeleteMapping("/{id}")
    public UserLogin deleteUserLogin(@PathVariable("id") Integer id) {
        return null;
    }
}
