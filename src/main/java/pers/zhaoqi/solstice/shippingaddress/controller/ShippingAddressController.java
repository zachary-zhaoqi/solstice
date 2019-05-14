package pers.zhaoqi.solstice.shippingaddress.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import pers.zhaoqi.solstice.common.enums.ResultCodeAndMessage;
import pers.zhaoqi.solstice.common.result.ActionResult;
import pers.zhaoqi.solstice.common.result.Result;
import pers.zhaoqi.solstice.common.utils.Utils;
import pers.zhaoqi.solstice.product.entity.ProductInfo;
import pers.zhaoqi.solstice.shippingaddress.dto.ShippingAddressInputDTO;
import pers.zhaoqi.solstice.shippingaddress.entity.ShippingAddress;
import pers.zhaoqi.solstice.shippingaddress.service.IShippingAddressService;

import javax.swing.*;
import java.util.List;

/**
 * <p>
 * 收货地址表 前端控制器
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@RestController
@RequestMapping("/shippingaddress/shippingAddress")
public class ShippingAddressController {

    public static final String MESSAGE_HEAD = "[收货地址]";

    Logger logger= LoggerFactory.getLogger(ShippingAddressController.class);

    @Autowired
    private IShippingAddressService shippingAddressService;

    @GetMapping
    public ActionResult queryShippingAddress(ShippingAddressInputDTO shippingAddressInputDTO){
        try {
            ShippingAddress shippingAddress = new ShippingAddress();
            BeanUtils.copyProperties(shippingAddressInputDTO, shippingAddress);
            shippingAddress.setUserId(Utils.getCurrentUser().getUserId());
            QueryWrapper queryWrapper = new QueryWrapper(shippingAddress);
            List list = shippingAddressService.list(queryWrapper);
            return Result.success(MESSAGE_HEAD + ResultCodeAndMessage.SUCCESS_QUERY_MESSAGE, list);
        }catch (Exception e){
            logger.debug(MESSAGE_HEAD+"queryProduct"+e.getMessage());
            return Result.failed(ResultCodeAndMessage.FAIL_QUERY,MESSAGE_HEAD+ResultCodeAndMessage.FAIL_QUERY_MESSAGE);
        }
    }

}
