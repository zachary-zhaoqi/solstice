package pers.zhaoqi.solstice.brand.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import pers.zhaoqi.solstice.brand.entity.BrandInfo;
import pers.zhaoqi.solstice.brand.service.IBrandInfoService;
import pers.zhaoqi.solstice.common.enums.ResultCodeAndMessage;
import pers.zhaoqi.solstice.common.result.ActionResult;
import pers.zhaoqi.solstice.common.result.Result;

import java.util.List;

/**
 * <p>
 * 品牌信息表 前端控制器
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@RestController
@RequestMapping("/brand/brandInfo")
public class BrandInfoController {

    @Autowired
    IBrandInfoService brandInfoService;

    @GetMapping
    public ActionResult getBrand(BrandInfo brandInfo){
        QueryWrapper queryWrapper=new QueryWrapper(brandInfo);
        List list = brandInfoService.list(queryWrapper);
        if (list==null||list.size()==0){
            return Result.failed(ResultCodeAndMessage.FAIL_CODE,"不存在该品牌;");
        }else {
            return Result.success("查询成功",list);
        }
    }

}
