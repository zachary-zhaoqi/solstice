package pers.zhaoqi.solstice.product.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.zhaoqi.solstice.brand.service.IBrandInfoService;
import pers.zhaoqi.solstice.common.enums.ResultCodeAndMessage;
import pers.zhaoqi.solstice.common.result.ActionResult;
import pers.zhaoqi.solstice.common.result.Result;
import pers.zhaoqi.solstice.common.utils.Utils;
import pers.zhaoqi.solstice.dictionary.service.IDataDictionaryService;
import pers.zhaoqi.solstice.product.entity.ProductInfo;
import pers.zhaoqi.solstice.product.service.IProductInfoService;


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

    public static final String MESSAGE_HEAD = "[产品]";

    @Autowired
    private IProductInfoService productInfoService;
    @Autowired
    private IDataDictionaryService dataDictionaryService;
    @Autowired
    private IBrandInfoService brandInfoService;


    @PostMapping("/{name}")
    public ActionResult SaveProduct(@RequestBody ProductInfo productInfo) {
        QueryWrapper queryWrapper = new QueryWrapper(new ProductInfo().setName(productInfo.getName()));
        if (productInfoService.count(queryWrapper) > 0) {
            return Result.failed(ResultCodeAndMessage.FAIL_SAVA, MESSAGE_HEAD + ResultCodeAndMessage.FAIL_ENTITY_REPEAT+"产品名称");
        }

        Utils.FillCreate(productInfo);
        if (productInfo.getBrandId()!=null)
            productInfo.setBrandName(brandInfoService.getById(productInfo.getBrandId()).getName());
        if (productInfo.getCategorySn()!=null)
            productInfo.setCategoryName(dataDictionaryService.getById(productInfo.getCategorySn()).getLabelZhCn());
        productInfo.setBarCode(GeneratesUniqueCode());

        if (productInfoService.save(productInfo)) {
            return Result.success(MESSAGE_HEAD + ResultCodeAndMessage.SUCCESS_SAVA_MESSAGE);
        } else {
            return Result.failed(ResultCodeAndMessage.FAIL_SAVA, MESSAGE_HEAD + ResultCodeAndMessage.FAIL_SAVA_MESSAGE);
        }
    }

    /**
     * 生成唯一的编码
     * 格式:年月日时分秒+六位哈希码
     *
     * @return
     */
    private String GeneratesUniqueCode() {
//        todo：陈亮
        return null;
    }

}
