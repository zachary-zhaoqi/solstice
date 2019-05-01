package pers.zhaoqi.solstice.product.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import pers.zhaoqi.solstice.common.result.ActionResult;
import pers.zhaoqi.solstice.product.entity.ProductInfo;

/**
 * <p>
 * 商品信息表 前端控制器
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@RestController
@RequestMapping("/product/productInfo")
public class ProductInfoController {

    @PostMapping()
    public ActionResult AddProductInfo(ProductInfo productInfo){
        return null;
    }
}
