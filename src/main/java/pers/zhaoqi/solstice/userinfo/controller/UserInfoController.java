package pers.zhaoqi.solstice.userinfo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pers.zhaoqi.solstice.common.enums.ResultCodeAndMessage;
import pers.zhaoqi.solstice.common.result.ActionResult;
import pers.zhaoqi.solstice.common.result.Result;
import pers.zhaoqi.solstice.common.utils.Utils;
import pers.zhaoqi.solstice.shippingaddress.controller.ShippingAddressController;
import pers.zhaoqi.solstice.userinfo.dto.UserInfoInputDTO;
import pers.zhaoqi.solstice.userinfo.entity.UserInfo;
import pers.zhaoqi.solstice.userinfo.service.IUserInfoService;

import java.util.List;

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

    public static final String MESSAGE_HEAD = "[用户信息]";

    Logger logger= LoggerFactory.getLogger(UserInfoController.class);
    @Autowired
    private IUserInfoService userInfoService;

    @GetMapping("/{id}")
    public ActionResult selectOnt(@PathVariable("id") Integer id){
        UserInfo userInfo = userInfoService.getById(id);
        if (userInfo==null){
            return Result.failed(ResultCodeAndMessage.ID_ERROR,"查询失败");
        }else {
            return Result.success("查询成功",userInfo);
        }
    }

    @GetMapping
    public ActionResult queryUserInfo(UserInfoInputDTO userInfoInputDTO){
        try {
            UserInfo userInfo = new UserInfo();
            BeanUtils.copyProperties(userInfoInputDTO, userInfo);
            QueryWrapper queryWrapper = new QueryWrapper(userInfo);
            List list = userInfoService.list(queryWrapper);
            return Result.success(MESSAGE_HEAD + ResultCodeAndMessage.SUCCESS_QUERY_MESSAGE, list);
        }catch (Exception e){
            logger.debug(MESSAGE_HEAD+"queryProduct"+e.getMessage());
            return Result.failed(ResultCodeAndMessage.FAIL_QUERY,MESSAGE_HEAD+ResultCodeAndMessage.FAIL_QUERY_MESSAGE);
        }
    }

}
