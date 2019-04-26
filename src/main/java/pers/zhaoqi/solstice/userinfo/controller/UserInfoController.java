package pers.zhaoqi.solstice.userinfo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pers.zhaoqi.solstice.common.enums.ConstantMessage;
import pers.zhaoqi.solstice.common.result.ActionResult;
import pers.zhaoqi.solstice.common.result.Result;
import pers.zhaoqi.solstice.userinfo.entity.UserInfo;
import pers.zhaoqi.solstice.userinfo.service.IUserInfoService;

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

    @Autowired
    private IUserInfoService userInfoService;

    @GetMapping("/{id}")
    public ActionResult selectOnt(@PathVariable("id") Integer id){
        UserInfo userInfo = userInfoService.getById(id);
        if (userInfo==null){
            return Result.failed(ConstantMessage.ID_ERROR,"查询失败");
        }else {
            return Result.success("查询成功",userInfo);
        }
    }

}
