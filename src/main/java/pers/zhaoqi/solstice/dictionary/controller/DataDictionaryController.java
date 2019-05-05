package pers.zhaoqi.solstice.dictionary.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import pers.zhaoqi.solstice.common.result.ActionResult;
import pers.zhaoqi.solstice.common.result.Result;
import pers.zhaoqi.solstice.dictionary.dto.DataDictionaryInputDTO;
import pers.zhaoqi.solstice.dictionary.entity.DataDictionary;
import pers.zhaoqi.solstice.dictionary.service.IDataDictionaryService;
import pers.zhaoqi.solstice.userlogin.service.IUserLoginService;

import javax.swing.*;
import java.util.List;

/**
 * <p>
 * 数据字典 前端控制器
 * </p>
 *
 * @author zachary.zhao
 * @since 2019-04-14
 */
@RestController
@RequestMapping("/dictionary/dataDictionary")
public class DataDictionaryController {

    Logger logger= LoggerFactory.getLogger(DataDictionaryController.class);
    @Autowired
    private IDataDictionaryService dataDictionaryService;

    @GetMapping()
    public ActionResult QueryDataDictionary(DataDictionaryInputDTO dataDictionaryInputDTO) {
//        todo:if (dataDictionaryInputDTO==null)
        DataDictionary dataDictionary=new DataDictionary();
        BeanUtils.copyProperties(dataDictionaryInputDTO,dataDictionary);
        QueryWrapper queryWrapper=new QueryWrapper(dataDictionary);
        List list;
        DataDictionary one;
        try{
//            list = dataDictionaryService.listObjs(queryWrapper);
            one = dataDictionaryService.getOne(queryWrapper);
        }catch (Exception e){
            logger.debug(e.getMessage());
            return Result.failed(-500,"QueryDataDictionary查询出错；");
        }

        return Result.success("查询成功",one);
    }
}
